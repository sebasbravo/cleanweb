package com.cleansolution.general.service;

import java.util.List;

import com.cleansolution.general.dto.CountryDTO;
import com.cleansolution.general.model.Country;



public interface ICountryService {
	
	public List<Country> getCountry() throws Exception;

    public void save(Country country) throws Exception;

    public void delete(Country country) throws Exception;

    public void update(Country country) throws Exception;

    public Country getCountryById(Integer countryId) throws Exception;
    
    public List<CountryDTO> getDataCountry() throws Exception;

}
