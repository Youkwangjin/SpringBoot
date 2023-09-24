package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  
public class InputController {
	@GetMapping("insdata")
	public String submitCall() {
		return "redirect:http://localhost/input.html"; // redirect 방식
	}
	
	
	@PostMapping("insdata") // index.html 에서 insdata라는 주소를 만나면 다음 메서드가 호출이 된다.
	public String submit(@RequestParam(value = "gugudan")int gugudan, Model model) {
		ArrayList<String> data = new ArrayList<String>();
		for(int j = 1; j < 10; j++) {
			data.add(gugudan + " " + j + "=" + gugudan * j);
		}

	      
	      model.addAttribute("data", data);

	      return "result";
		
	}

}
