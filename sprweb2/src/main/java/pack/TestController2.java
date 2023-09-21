package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller


public class TestController2 {
	//
	
	@RequestMapping(value = "test9", method = RequestMethod.GET)
	
	// GET, POST방식만 처리한다고 가정했을 때는
	//@RequestMapping(method = RequestMethod.GET)
	public String def(Model model) {
		model.addAttribute("msg", "success get");
		return "list";	// forward 방식 	
	}
	
	@RequestMapping(value = "test9", method = RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";	// forward 방식 	
	}

}
