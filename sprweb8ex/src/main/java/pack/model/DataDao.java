package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DataDao {
	
	
	// 클래스의 포함관계 DataMapperInterface에서 설정한 DB 쿼리문을 호출하기 위해 사용되었다.
	@Autowired
	private DataMapperInterface dataMapper; 
	 
	public DataDao() {}
	
	// DB 확인용 출력
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = dataMapper.selectAll();
		return list;
	}
	
	// 검색용
	public List<SangpumDto> getDataSearch(String svalue){
		List<SangpumDto> list = dataMapper.selectSearch(svalue);
		return list;
	}
	
	
	
}
