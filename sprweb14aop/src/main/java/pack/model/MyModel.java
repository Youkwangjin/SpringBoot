package pack.model;

import org.springframework.stereotype.Repository;

@Repository
public class MyModel implements MyModelInter{

	@Override
	public String processMsg() {
		System.out.println("processMsg 핵심 메서드 수행");
		return "Spring AOP 만세";
	}

	@Override
	public String businessMsg() {
		System.out.println("businessMsg 핵심 메서드 처리");
		return "Spring AOP 엄청 만세";
	}
	
	
}	
