package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.SangpumBean;
import pack.model.SangpumModel;

@Controller
public class InputController {
	@Autowired
	private SangpumModel sangpumModel; // 클래스의 포함관계
	
	@GetMapping("insdata")
	public String submitCall() {
		return "redirect:http://localhost/input.html"; // redirect 방식
	}
	
	@PostMapping("insdata")
	// 들어오는 데이터 값이 많을 때 FormBean사용
	public String submit(SangpumBean bean, Model model) {
		String imsi = sangpumModel.sangProcess(bean); 
		model.addAttribute("sangdata", imsi);
		return "result2"; // forward 방식 (기본이다)
	}
}
