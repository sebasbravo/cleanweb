package com.cleansolution.general.presentation.businessDelegate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleansolution.general.dto.CitiesDTO;
import com.cleansolution.general.dto.CountryDTO;
import com.cleansolution.general.dto.OrganizationDTO;
import com.cleansolution.general.dto.StatesDTO;
import com.cleansolution.general.model.Cities;
import com.cleansolution.general.model.Country;
import com.cleansolution.general.model.Organization;
import com.cleansolution.general.model.States;
import com.cleansolution.general.service.ICityService;
import com.cleansolution.general.service.ICountryService;
import com.cleansolution.general.service.IOrganizationService;
import com.cleansolution.general.service.IStateService;


@Service("generalBusinessDelegate")
public class GeneralBusinessDelegate implements IGeneralBusinessDelegate {
	private static final Logger log = LoggerFactory.getLogger(GeneralBusinessDelegate.class);
	
	@Autowired
	private ICityService citiesService;
	@Autowired
	private IStateService stateService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private IOrganizationService organizationService;

	@Override
	public List<Cities> getCities() throws Exception {
		return citiesService.getCities();
	}

	@Override
	public Cities getCityById(Integer cityId) throws Exception {
		return citiesService.getCityById(cityId);
	}
	@Override
	public List<Cities> findCitiesByState(Integer stateId) throws Exception {
		return citiesService.findByState(stateId);
	}

	@Override
	public List<CitiesDTO> getDataCity() throws Exception {
		return citiesService.getDataCity();
	}

	@Override
	public List<Country> getCountry() throws Exception {
		return countryService.getCountry();
	}

	@Override
	public List<States> getStates() throws Exception {
		return stateService.getStates();
	}
	@Override
	public List<States> getStatesByCountry(Integer countryId) throws Exception {
		return stateService.getStatesByCountry(countryId);
	}

	@Override
	public States getStateById(Integer stateId) throws Exception {
		return stateService.getStateById(stateId);
	}

	@Override
	public List<StatesDTO> getDatastate() throws Exception {
		return stateService.getDatastate();
	}

	@Override
	public Country getCountryById(Integer countryId) throws Exception {
		return countryService.getCountryById(countryId);
	}

	@Override
	public List<CountryDTO> getDataCountry() throws Exception {
		return countryService.getDataCountry();
	}

	@Override
	public List<OrganizationDTO> getOrganizations() throws Exception {
		return organizationService.getOrganizations();
	}

	@Override
	public void saveOrganization(OrganizationDTO organization) throws Exception {
		organizationService.saveOrganization(organization);
		
	}

	@Override
	public void updateOrganization(OrganizationDTO organization) throws Exception {
		organizationService.updateOrganization(organization);
		
	}

	@Override
	public OrganizationDTO findOrganizationByNis(String nis) throws Exception {
		return organizationService.findOrganizationByNis(nis);
	}

	@Override
	public OrganizationDTO findOrganizationByName(String name) throws Exception {
		return organizationService.findOrganizationByName(name);
	}
	

}
