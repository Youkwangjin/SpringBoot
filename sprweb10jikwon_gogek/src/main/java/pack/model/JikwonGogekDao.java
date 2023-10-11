package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonGogekDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMappingInterface dataMappingInterface;
	
	public List<JikwonDto> selectAll(){
		List<JikwonDto> jlist = dataMappingInterface.selectAll();
		logger.info("읽은 자료 수 : " + jlist.size());
		return jlist;
	}
	
	public List<GogekDto> selectGogek(String jikwon_no){
		List<GogekDto> glist = dataMappingInterface.selectGogek(jikwon_no);
		logger.info("읽은 자료 수 : " + glist.size());
		return glist;
	}
	

}
