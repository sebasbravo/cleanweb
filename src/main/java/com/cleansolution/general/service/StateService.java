package com.cleansolution.general.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.exceptions.MessManager;
import com.cleansolution.general.dao.IStatesDAO;
import com.cleansolution.general.dto.StatesDTO;
import com.cleansolution.general.model.States;

@Transactional
@Service("statesService")
public class StateService implements IStateService {
	private static final Logger log = LoggerFactory.getLogger(StateService.class);
	
	@Autowired
	protected IStatesDAO stateDao;

	@Override
	@Transactional(readOnly = true)
	public List<States> getStates() throws Exception {
		log.debug("finding all States instances");
		List<States> states = new ArrayList<States>();
		
		try {
			states = stateDao.findAll();
			
		} catch (Exception e) {
			log.error("finding all States failed", e);
			 throw new MessManager().new GettingException(MessManager.ALL +"States");
		}finally {
			
		}
		
		return states;
	}

	@Override
	public void save(States state) throws Exception {
		log.debug("finding all States instances");
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
		}
		
	}

	@Override
	public void delete(States state) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(States state) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public States getStateById(Integer stateId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatesDTO> getDatastate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<States> getStatesByCountry(Integer countryId) throws Exception {
		
		log.debug("finding States by Country");
		List<States> states = new ArrayList<States>();
		
		try {
			states = stateDao.findByCountry(countryId);
			
		} catch (Exception e) {
			log.error("finding States by Country failed", e);
			 throw new MessManager().new GettingException(MessManager.ALL +"States");
		}finally {
			
		}
		
		return states;
	}

}
