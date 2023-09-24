package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


	
	@GetMapping("thymetest")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프 만세!"); // (Key, Value)  
		// templates 폴더 안에 list1.html을 forwarding 한다. 여기서 list1.html은 타임리프가 적용된 html이다.
		model.addAttribute("msg2", "홍길동");
		
		// DTO 출력
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("마우스");
		sangpum.setPrice("5000");
		model.addAttribute("sangpum", sangpum); 
		
		// Collection을 출력
		ArrayList<Sangpum> list = new ArrayList<>();
		list.add(sangpum);
		Sangpum sangpum2 = new Sangpum();
		sangpum2.setCode("20");
		sangpum2.setSang("모니터");
		sangpum2.setPrice("500000");
		list.add(sangpum2);
		model.addAttribute("sangpums", list);

		
		return "list1";
		
		
	}
}
