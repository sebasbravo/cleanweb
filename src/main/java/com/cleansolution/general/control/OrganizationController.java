package com.cleansolution.general.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleansolution.general.dto.OrganizationDTO;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;


@RestController
@RequestMapping("/")
public class OrganizationController {
	
	@Autowired
	private IGeneralBusinessDelegate businessDelegate;
	
		
	@RequestMapping(value="allOrganizations", method = RequestMethod.GET)
	public @ResponseBody List<OrganizationDTO> allOrganizations() throws Exception{
		return businessDelegate.getOrganizations();	
	}
	
	@RequestMapping(value="createOrganization", method = RequestMethod.POST)
	public void createOrganization(@RequestBody OrganizationDTO organization) throws Exception{
		System.out.println("test fine");
		if(businessDelegate.findOrganizationByNis(organization.getNis())!= null){
			throw new Exception("The Organization already exist!");
		}
		businessDelegate.saveOrganization(organization);
	}
	
	
}
