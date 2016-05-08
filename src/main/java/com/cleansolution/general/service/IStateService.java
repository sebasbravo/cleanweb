package com.cleansolution.general.service;

import java.util.List;

import com.cleansolution.general.dto.StatesDTO;
import com.cleansolution.general.model.States;

public interface IStateService {
	
	public List<States> getStates() throws Exception;
	public List<States> getStatesByCountry(Integer countryId) throws Exception;

    public void save(States state) throws Exception;

    public void delete(States state) throws Exception;

    public void update(States state) throws Exception;

    public States getStateById(Integer stateId) throws Exception;
    
    public List<StatesDTO> getDatastate() throws Exception;

}
