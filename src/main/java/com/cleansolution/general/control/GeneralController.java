package com.cleansolution.general.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	
	@RequestMapping("/")
	public String welcome(Model model) {
		return "welcome";
	}
	
	@RequestMapping("countries")
	public String country(Model model) {
		return "countries";
	}
	
	@RequestMapping("/organizations")
	public String organizations(Model model) {
		return "organizations";
	}

}
