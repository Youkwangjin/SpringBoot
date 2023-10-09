package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;


@Mapper //XML 파일의 id를 찾아간다.
public interface DataMappingInter {
	
	// 추상 메서드만 올 수 있다.
	// 메서드명은 mapper.xml의 id명과 일치시켜야한다.
	
	// 복수개의 데이터를 보여주기 때문에 List 사용
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	
	int insert(BoardBean bean);
	void updateReadcnt(String num);
	int update(BoardBean bean);
	int delete(String num);
	
	
	
	
	

}
