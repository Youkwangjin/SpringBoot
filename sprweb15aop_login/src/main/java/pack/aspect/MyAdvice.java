package pack.aspect;

import java.util.Iterator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Aspect
public class MyAdvice {
   @Autowired
   private LoginClass loginClass;
   
   @Around("execution(* jikProcess*(..))")
   public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
      HttpServletRequest request = null;
      HttpServletResponse response = null;
      
      for(Object obj:joinPoint.getArgs()) { // getArgs은 jikProcess를 읽는다. 
    	  if(obj instanceof HttpServletRequest) {
    		  request = (HttpServletRequest)obj;
    	  }
    	  
    	  if(obj instanceof HttpServletResponse) {
    		  response = (HttpServletResponse)obj;
    	  }
      }
      
      if(loginClass.loginCheck(request, response)) {
    	  // true 반환값일 때 (로그인에 실패할 때) AOP가 실행되지 않는다. 
    	  return null;
      }
      
      // return null 이면 밑에 있는 코드들은 수행되지 않는다. 
      Object object = joinPoint.proceed();
      return object;
   }
}