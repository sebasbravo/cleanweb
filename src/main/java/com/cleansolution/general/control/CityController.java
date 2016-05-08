package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleansolution.general.model.Cities;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;


@Controller

public class CityController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
	@RequestMapping("/city")
	public String welcome(Model model) {
		return "city";
	}
	
	@RequestMapping(value="/city/", method = RequestMethod.GET)
	public ResponseEntity<List<Cities>> allCities() throws Exception{
		List<Cities> cities = businessDelegate.getCities();
			if(cities.isEmpty()){
				return new ResponseEntity<List<Cities>>(HttpStatus.NO_CONTENT);
			}
		
		return new ResponseEntity<List<Cities>>(cities, HttpStatus.OK);
		
	}

}
