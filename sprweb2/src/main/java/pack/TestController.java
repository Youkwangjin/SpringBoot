package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import jakarta.servlet.http.HttpServletRequest;

// package 하위 package에게 클래스를 만들어준다.
// @Controller은 주로 사용자의 요청을 처리(모델을 다녀온걸 말한다.) 후 지정된 뷰에 모델 객체를 전달하는 역할 (인스턴스 생성)
// 클라이언트와 데이터 입출력 제어하는 클래스

@Controller // 객체생성
public class TestController {
	
	// 핸들러 매핑에 의해 만난다.  (옛날 방식)
	@RequestMapping("test1") // get, post을 모두 매핑한다 // (dispatcherServlet 부터으로 위임 받은 HandlerMapping에 의해 처리)

	public ModelAndView abc() {
		// 비즈니스 로직 또는 모델 영역을 수행하는 역할을 한다. 
		
		
		// Model 인터페이스 : 처리한 데이터를 뷰에 표시하기 위한 데이터를 전달. HttpServletRequest 객체를 사용함
		//HttpServletRequest request = HttpServletRequest();
		//request.setAttribute("msg", "나이스");
		// 클라이언트에게 응답하기 위해 HttpServletRequest 대신해서 ModelAndView 사용 
		return new ModelAndView("list", "msg", "나이스"); // (뷰 파일명, 키, 값); 
		// dispatcherServlet 부터으로 위임받은 ViewResolverd에 의해 처리 
	}
	
	@RequestMapping(value="test2", method = RequestMethod.GET) // method방식을 구분할 때 value를 쓴다. GET 방식을 사용한다. 
	               // value={"test2", "hi", "안녕"}
	public ModelAndView abc2() {
		//System.out.println("테스트용 abc2 처리");
		return new ModelAndView("list", "msg", "나이스2"); // (뷰 파일명, 키, 값); 
	}
	
	@GetMapping("test3") // get요청 처리용 전용 annotation 
	public ModelAndView abc3() {
		//System.out.println("테스트용 abc2 처리");
		return new ModelAndView("list", "msg", "나이스3"); // (뷰 파일명, 키, 값); 
	}
	
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "나이스4"); // (키, 값)
		return "list"; // 뷰 파일명
	}
	
	@RequestMapping(value = "test5", method = RequestMethod.POST) // method방식을 구분할 때 value를 쓴다. GET 방식만 받는다.
	// value={"test2", "hi", "안녕"}
	public ModelAndView abc5() {
		//System.out.println("테스트용 abc2 처리");
		return new ModelAndView("list", "msg", "post 요청 성공5"); // (뷰 파일명, 키, 값);
	}
	
	@PostMapping("test6") // post 요청 처리용 전용 annotation 
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "post 요청 성공6"); // (뷰 파일명, 키, 값); 
	}
	
	@PostMapping("test7") // post 방식을 사용한다
	public String abc7(Model model) {
		model.addAttribute("msg", "post 요청 성공7"); // (키, 값)
		return "list"; // 뷰 파일명
	}
	
	@GetMapping("test8")
	// AJAX 용
	@ResponseBody // 문자열을 리턴값을 반환
	public String abc8() {
		String value = "일반적인 데이터(String,MAP,JSON 등을 전달)";
		return value;

	}
	
	@GetMapping("test8_1")
	// AJAX 용
	@ResponseBody // 문자열을 리턴값을 반환
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(5);
		dto.setName("신기해");
		return dto; // JSON 형태로 반환 (jackson 라이브러리가 자동 지원이 되고 있는거다)
	}
	
}
