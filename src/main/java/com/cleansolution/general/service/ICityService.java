package com.cleansolution.general.service;

import java.util.List;

import com.cleansolution.general.dto.CitiesDTO;
import com.cleansolution.general.model.Cities;

public interface ICityService {
	public List<Cities> getCities() throws Exception;

    public void save(Cities city) throws Exception;

    public void delete(Cities city) throws Exception;

    public void update(Cities city) throws Exception;

    public Cities getCityById(Integer cityId) throws Exception;
    
    public List<CitiesDTO> getDataCity() throws Exception;

}
