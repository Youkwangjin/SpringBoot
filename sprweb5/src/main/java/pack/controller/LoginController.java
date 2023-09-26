package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
   // Logging이란 프로그램 개발 중이나 완료 후 발생할 수 있는 오류에 대해 디버깅하거나 운영 중인 프로그램 상태를
   // 모니터링 하기 위해 필요한 정보(로그)를 기록하는 것
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   
   @GetMapping("login")
   public String submitcall() {
      return "redirect:http://localhost/login.html";   // redirect 방식, webapp / 원래는 기본이 forward
   }
   /*
   // 방법1 : 전통적 방법을 사용하여 클라이언트 값 받기
   @GetMapping("loginget")
   public String submit(HttpServletRequest request, Model model) {
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      System.out.println("콘솔로 출력하기 " + id + " " + pwd);   // 프로그램 진행 중 값 확인하기
      logger.info("진행 도중 로그 정보를 정보 " + id + " " + pwd); // 로그 레벨 trace > info > warn > error
      
      
      String data ="";
      if(id.equals("aa") && pwd.equals("11"))
    	  data = "로그인 성공";
      else
    	  data = "로그인 실패";
      
      model.addAttribute("data", data);
      
      return "result"; // forwarding 방식 
   }
   */
   
   // 방법2 : 스프링 방법
   // 어노테이션은 "/loginget" 경로로 들어오는 GET 요청을 이 submit 메서드에서 처리
   // Model model는 submit 메서드에서 처리한 데이터값을 view로 보내기위한 객체이다.
   @GetMapping("loginget")
   public String submit(@RequestParam(value = "id")String id,
		                @RequestParam("pwd")String pwd,
		                Model model) {
	      String data ="";
	      if(id.equals("aa") && pwd.equals("11"))
	    	  data = "로그인 성공";
	      else
	    	  data = "오타 공백좀 확인";
	      
	      model.addAttribute("data", data); 
	      
	      return "result"; // forwarding 방식 
   }
}