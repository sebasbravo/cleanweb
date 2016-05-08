package com.cleansolution.general.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.exceptions.MessManager;
import com.cleansolution.general.dao.ICountryDAO;
import com.cleansolution.general.dto.CountryDTO;
import com.cleansolution.general.model.Country;


@Transactional
@Service("countryService")
public class CountryService implements ICountryService{
	private static final Logger log = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	protected ICountryDAO countryDao;

	@Override
	@Transactional(readOnly = true)
	public List<Country> getCountry() throws Exception {
		log.debug("finding all Country instances");
		
		List<Country> countries = new ArrayList<Country>();
		
		try {
			countries = countryDao.findAll();
			
		} catch (Exception e) {
			log.error("finding all Country failed", e);
			 throw new MessManager().new GettingException(MessManager.ALL +"Country");
		}finally {
			
		}
		return countries;
	}

	@Override
	public void save(Country country) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Country country) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Country country) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Country getCountryById(Integer countryId) throws Exception {
		Country country;
		
		try {
			country = countryDao.findById(countryId);
			
		} catch (Exception e) {
			log.error("finding by Id Country failed", e);
			 throw new MessManager().new GettingException(MessManager.ID +"Country");
		}finally {
			
		}
		return country;
	}

	@Override
	@Transactional(readOnly=true)
	public List<CountryDTO> getDataCountry() throws Exception {
		try {
            List<Country> country = countryDao.findAll();

            List<CountryDTO> countryDTO = new ArrayList<CountryDTO>();

            for (Country countryTmp : country) {
            	
                CountryDTO countryDTOTmp = new CountryDTO();

                countryDTOTmp.setCountryId(countryTmp.getCountryId());
                countryDTOTmp.setAlpha2(countryTmp.getAlpha2());
                countryDTOTmp.setAlpha3(countryTmp.getAlpha3());
                countryDTOTmp.setCode(countryTmp.getCode());
                countryDTOTmp.setNameEn(countryTmp.getNameEn());
                countryDTOTmp.setNameFr(countryTmp.getNameFr());
                countryDTO.add(countryDTOTmp);
            }
            return countryDTO;
        } catch (Exception e) {
            throw e;
        }
	}

}
