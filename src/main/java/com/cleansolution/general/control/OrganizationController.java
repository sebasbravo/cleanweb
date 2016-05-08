package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cleansolution.general.model.Country;
import com.cleansolution.general.model.Organization;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;

@Controller
public class OrganizationController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
	@RequestMapping("/organization")
	public String organizations(Model model) {
		return "organization";
	}
	
	@RequestMapping(value="/allOrganizations", method = RequestMethod.GET)
	public @ResponseBody List<Organization> allOrganizations() throws Exception{
		return businessDelegate.getOrganizations();	
	}
	
	@RequestMapping(value="/createOrganizations", method = RequestMethod.GET)
	public void createOrganizations(@RequestBody Organization organization) throws Exception{
		if(businessDelegate.findOrganizationByNis(organization.getNis())!= null){
			throw new Exception("The Organization already exist!");
		}
		businessDelegate.saveOrganization(organization);
	}

}
