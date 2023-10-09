package pack.model;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;


// Repository (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMappingInter mappingInter;
	
	// 전체 자료 읽기
	public List<Board> list()	{
		List<Board> list = null;
		try {
			list = mappingInter.selectList();
			logger.info("list.size : " + list.size());
		} catch (Exception e) {
			logger.info("list err : " + e);
		}
		return list;
	}
	
	@Transactional
	public boolean insertData(BoardBean bean) {
		boolean b = false;
		int re = mappingInter.insert(bean);
		if(re > 0) b = true;
		return b;	
	}
	
	public List<Board> search(BoardBean bean) {
		List<Board> slist = mappingInter.selectSearch(bean);
		return slist;
	}
	
	// 상세보기용
	public Board detail(String num) {
		// 게시물 조회수 증가 
		mappingInter.updateReadcnt(num);
		Board board = mappingInter.selectOne(num);
		return board;
	}
	
	@Transactional // 성공하면 커밋 오류나면 롤백
	public boolean update(BoardBean bean) {
		boolean b = false;
		int re = mappingInter.update(bean); 
		if(re > 0) b = true;
		return b;
	}
	
	// 게시물 삭제하기
	@Transactional // 성공하면 커밋 오류나면 롤백
	public boolean delete(String num) {
		boolean b = false;
		int re = mappingInter.delete(num); 
		if(re > 0) b = true;
		return b;
	}
}
