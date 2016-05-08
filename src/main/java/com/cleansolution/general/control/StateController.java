package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cleansolution.general.model.States;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;

@Controller
public class StateController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
	@RequestMapping("/states")
	public String states(Model model) {
		return "states";
	}
	
	
	@RequestMapping(value="/allStates", method = RequestMethod.GET)
	public @ResponseBody List<States> allStates() throws Exception{
		return businessDelegate.getStates();
		
	}
	

	@RequestMapping(value="/statesByCountry/{countryId}", method = RequestMethod.GET)
	public @ResponseBody List<States> statesByCountry(@PathVariable("countryId") Integer countryId) throws Exception{
		return businessDelegate.getStatesByCountry(countryId);
	}
		

}
