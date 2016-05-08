package com.cleansolution.general.presentation.businessDelegate;

import java.util.List;

import com.cleansolution.general.dto.CitiesDTO;
import com.cleansolution.general.dto.CountryDTO;
import com.cleansolution.general.dto.StatesDTO;
import com.cleansolution.general.model.Cities;
import com.cleansolution.general.model.Country;
import com.cleansolution.general.model.Organization;
import com.cleansolution.general.model.States;

public interface IGeneralBusinessDelegate {

	public List<Cities> getCities() throws Exception;
	public Cities getCityById(Integer cityId) throws Exception;
	public List<CitiesDTO> getDataCity() throws Exception;
	public List<Country> getCountry() throws Exception;
	public List<States> getStates() throws Exception;
	public List<States> getStatesByCountry(Integer countryId) throws Exception;
	public States getStateById(Integer stateId) throws Exception;
	public List<StatesDTO> getDatastate() throws Exception;
	public Country getCountryById(Integer countryId) throws Exception;
	public List<CountryDTO> getDataCountry() throws Exception;
	
	public List<Organization> getOrganizations() throws Exception;
	public void saveOrganization(Organization organization) throws Exception;
	public void updateOrganization(Organization organization) throws Exception;
	public Organization findOrganizationByNis(String nis) throws Exception;
	public Organization findOrganizationByName(String name) throws Exception;

}
