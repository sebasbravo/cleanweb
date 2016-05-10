package com.cleansolution.general.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.exceptions.MessManager;
import com.cleansolution.general.dao.ICitiesDAO;
import com.cleansolution.general.dto.CitiesDTO;
import com.cleansolution.general.model.Cities;



@Transactional
@Service("cityService")
public class CityService implements ICityService {
	private static final Logger log = LoggerFactory.getLogger(StateService.class);

	@Autowired
	protected ICitiesDAO cityDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cities> getCities() throws Exception {
		log.debug("finding all States instances");
		List<Cities> cities = new ArrayList<Cities>();

		try {

			cities = cityDao.findAll();

		} catch (Exception e) {
			log.error("finding all Cities failed", e);
			throw new MessManager().new GettingException(MessManager.ALL + "Cities");
		} finally {
		}

		return cities;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Cities city) throws Exception {
		log.debug("finding all States instances");

		try {
			cityDao.persist(city);
			log.debug("save Cities successful");
		} catch (Exception e) {
			log.error("save Cities failed", e);
            throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Cities city) throws Exception {
		log.debug("finding all States instances");
		
		try {
			cityDao.deleteById(city.getCityId());
			log.debug("delete Cities successful");
			
		} catch (Exception e) {
			log.error("delete Cities failed", e);
            throw e;
		}finally {
		}

	}

	@Override
	public void update(Cities city) throws Exception {
		log.debug("updating Cities instance");
		
		try {
			
		} catch (Exception e) {
			cityDao.merge(city);
			log.debug("update Cities successful");
		}finally {
		}

	}

	@Override
	public Cities getCityById(Integer cityId) throws Exception {
		log.debug("getting Cities instance");

        Cities city = null;

        try {
        	city = cityDao.findById(cityId);
        } catch (Exception e) {
            log.error("get City failed", e);
            throw new MessManager().new FindingException("Cities");
        } finally {
        }

        return city;
	}

	@Override
	public List<CitiesDTO> getDataCity() throws Exception {
		  try {
	            List<Cities> cities = cityDao.findAll();
	            List<CitiesDTO> citiesDTO = new ArrayList<CitiesDTO>();

	            for (Cities citiesTmp : cities) {
	                CitiesDTO citiesDTOTmp = new CitiesDTO();

	                citiesDTOTmp.setCityId(citiesTmp.getCityId());
	                citiesDTOTmp.setAbbreviation(citiesTmp.getAbbreviation());
	                citiesDTOTmp.setName(citiesTmp.getName());
	                citiesDTOTmp.setStateId(citiesTmp.getStates().getStateId());
	                citiesDTO.add(citiesDTOTmp);
	            }

	            return citiesDTO;
	        } catch (Exception e) {
	            throw e;
	        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cities> findByState(Integer stateId) throws Exception {
		log.debug("finding cities by State instances");
		List<Cities> cities = new ArrayList<Cities>();

		try {

			cities = cityDao.findByState(stateId);

		} catch (Exception e) {
			log.error("finding Cities by state failed", e);
			throw new MessManager().new GettingException(MessManager.ID + "Cities");
		} finally {
		}

		return cities;
	}

}
