package com.cleansolution.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cleansolution.general.dao.ICountryDAO;
import com.cleansolution.general.model.Country;
import com.cleansolution.general.presentation.businessDelegate.IGeneralBusinessDelegate;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:test-application-context.xml","classpath:test-mvc-config.xml"})
public class CountryDaoTest{

	@Autowired
	private IGeneralBusinessDelegate bdelegate;
	
	@Autowired ICountryDAO countryDao;
	
	@Test
	public void testFind() throws Exception{
		List<Country> allCountries = bdelegate.getCountry();
		
		assertTrue(allCountries.size() > 0);
		
		Country c1 = allCountries.get(0);
		
		Integer id = c1.getCountryId();
		
		Country c2 = countryDao.findById(id);
		
		assertTrue(c1.getCountryId().equals(c2.getCountryId()));
	}

	
}
