package com.cleansolution.general.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String welcome(Model model) {
		//model.addAttribute("greeting", "Biernvenidos !");
		//model.addAttribute("tagline", "Cooperative Nettoieprêt");
		
		return "welcome";
	}

}
