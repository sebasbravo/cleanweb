package com.cleansolution.general.service;

import java.util.List;

import com.cleansolution.general.model.Organization;

public interface IOrganizationService {
	public List<Organization> getOrganizations() throws Exception;
	public void saveOrganization(Organization organization) throws Exception;
	public void updateOrganization(Organization organization) throws Exception;
	public Organization findOrganizationByNis(String nis) throws Exception;
	public Organization findOrganizationByName(String name) throws Exception;
	

}
