package pack.aspact;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspactClass {
	@Autowired
	private SecurityClass class1;
	
	@Around("execution(public String businessMsg()) or execution(public String processMsg())")
	public Object aspProcess(ProceedingJoinPoint joinPoint) throws Throwable {
		class1.mySecurity();
		
		// 핵심 메서드 수행
		Object object = joinPoint.proceed(); 
		
		return object;
	}
}
