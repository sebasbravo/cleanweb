package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleansolution.general.model.Cities;
import com.cleansolution.general.model.States;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;


@RestController
@RequestMapping("/")
public class CityController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
		
	@RequestMapping(value="allCities", method = RequestMethod.GET)
	public @ResponseBody List<Cities> allCities() throws Exception{
		return businessDelegate.getCities();
	}
	
	@RequestMapping(value="citiesByState/{stateId}", method = RequestMethod.GET)
	public @ResponseBody List<Cities> citiesByState(@PathVariable("stateId") Integer stateId) throws Exception{
		return businessDelegate.findCitiesByState(stateId);
	}

}
