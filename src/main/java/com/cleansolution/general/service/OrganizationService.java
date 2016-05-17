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
import com.cleansolution.general.dao.IOrganizationDAO;
import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.dto.OrganizationDTO;
import com.cleansolution.general.model.Address;
import com.cleansolution.general.model.Organization;
import com.cleansolution.general.model.Party;

@Transactional
@Service("organizationService")
public class OrganizationService implements IOrganizationService {

	private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);

	@Autowired
	private IOrganizationDAO organizationDao;
	
	@Autowired
	private ICitiesDAO cityDao;

	@Override
	@Transactional(readOnly = true)
	public List<OrganizationDTO> getOrganizations() {
		List<OrganizationDTO> organizations = new ArrayList<>();

		/*try {
			organizations = organizationDao.findAll();
		} catch (DaoException e) {
			log.error("finding all Organizations failed", e);
			throw new MessManager().new GettingException(MessManager.ALL + "Organizations");
		} finally {
		}*/

		return organizations;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveOrganization(OrganizationDTO organization) throws Exception {
		
		Organization org = new Organization();
		Party party = new Party();
		Address address = new Address();
		
		org.setName(organization.getName());
		org.setNis(organization.getNis());
		
		party.setCel(organization.getCel());
		party.setEmail(organization.getEmail());
		party.setPhone(organization.getPhone());
		party.setStatus(organization.getStatus());
		party.setTaxFederal(organization.getTaxFederal());
		party.setTaxProvincial(organization.getTaxProvincial());
		party.setWebsite(organization.getWebsite());

		address.setApartment(organization.getApartment());
		address.setCities(cityDao.findById(organization.getCityId()));
		address.setCivicAddress(organization.getAddressCivic());
		address.setPostalCode(organization.getCodePostal());

		party.setPartyAddresses(address.getPartyAddresses());
		
		org.setParty(party);
		
		try {
			organizationDao.persist(org);
			log.debug("save Organization successful");
		} catch (Exception e) {
			log.error("save Organization failed", e);
			throw e;
		} finally {
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateOrganization(OrganizationDTO organization) throws Exception {
	/*	try {
			organizationDao.merge(organization);
			log.debug("update Organization successful");
		} catch (Exception e) {
			log.error("update Organization failed", e);
			throw e;
		} finally {
		}*/

	}

	@Override
	@Transactional(readOnly = true)
	public OrganizationDTO findOrganizationByNis(String nis) throws Exception {

		OrganizationDTO organization = null;
		/*try {
			organization = organizationDao.findByNis(nis);
		} catch (Exception e) {
			log.error("get by NIS Organization failed", e);
			throw new MessManager().new FindingException("Organization");
		} finally {
		}*/
		return organization;
	}

	@Override
	public OrganizationDTO findOrganizationByName(String name) throws Exception {
		OrganizationDTO organization = null;
		/*try {
			organization = organizationDao.findByName(name);
		} catch (Exception e) {
			log.error("get by name Organization failed", e);
			throw new MessManager().new FindingException("Organization");
		} finally {
		}*/
		return organization;

	}

}
