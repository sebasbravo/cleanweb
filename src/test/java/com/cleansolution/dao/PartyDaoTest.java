package com.cleansolution.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cleansolution.general.dao.ICitiesDAO;
import com.cleansolution.general.dao.IPartyDAO;
import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.model.Address;
import com.cleansolution.general.model.Party;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-application-context.xml", "classpath:test-mvc-config.xml" })
public class PartyDaoTest {
	
	@Autowired
	IPartyDAO partyDao;
	
	@Autowired
	ICitiesDAO cityDao;
	
	@Test
	public void insertPartyTest() throws DaoException {
		
		Party party = new Party();

		party.setCel("12345");
		party.setEmail("myemail@gmail.com");
		party.setPhone("23456");
		party.setStatus(true);
		party.setTaxFederal("g345");
		party.setTaxProvincial("tp123");
		party.setWebsite("www.mycorp.com");

		Address address = new Address();
		address.setApartment("1");
		address.setCities(cityDao.findById(1375));
		address.setCivicAddress("rue nouvelle scotia");
		address.setPostalCode("G1E5J4");

		party.setPartyAddresses(address.getPartyAddresses());

		
		partyDao.persist(party);

		Party partyDb = partyDao.findByPartyId(party.getPartyId());
		assertNotNull(partyDb);
		

	}
	
	

}
