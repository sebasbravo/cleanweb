package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cleansolution.general.model.Country;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;


@Controller
public class CountryController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
	@RequestMapping("/countries")
	public String welcome(Model model) {
		return "countries";
	}
	
	
	@RequestMapping(value="/allCountries", method = RequestMethod.GET)
	public @ResponseBody List<Country> allCountries() throws Exception{
		return businessDelegate.getCountry();
		
	}
		
	

}
