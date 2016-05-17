package com.cleansolution.general.service;

import java.util.List;

import com.cleansolution.general.dto.OrganizationDTO;

public interface IOrganizationService {
	public List<OrganizationDTO> getOrganizations() throws Exception;
	public void saveOrganization(OrganizationDTO organization) throws Exception;
	public void updateOrganization(OrganizationDTO organization) throws Exception;
	public OrganizationDTO findOrganizationByNis(String nis) throws Exception;
	public OrganizationDTO findOrganizationByName(String name) throws Exception;
	

}
