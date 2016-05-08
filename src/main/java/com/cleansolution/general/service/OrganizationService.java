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
import com.cleansolution.general.dao.IOrganizationDAO;
import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.model.Organization;

@Transactional
@Service("organizationService")
public class OrganizationService implements IOrganizationService {

	private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);

	@Autowired
	private IOrganizationDAO organizationDao;

	@Override
	@Transactional(readOnly = true)
	public List<Organization> getOrganizations() {
		List<Organization> organizations = new ArrayList<>();

		try {
			organizations = organizationDao.findAll();
		} catch (DaoException e) {
			log.error("finding all Organizations failed", e);
			throw new MessManager().new GettingException(MessManager.ALL + "Organizations");
		} finally {
		}

		return organizations;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveOrganization(Organization organization) throws Exception {
		try {
			organizationDao.persist(organization);
			log.debug("save Organization successful");
		} catch (Exception e) {
			log.error("save Organization failed", e);
			throw e;
		} finally {
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateOrganization(Organization organization) throws Exception {
		try {
			organizationDao.merge(organization);
			log.debug("update Organization successful");
		} catch (Exception e) {
			log.error("update Organization failed", e);
			throw e;
		} finally {
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Organization findOrganizationByNis(String nis) throws Exception {

		Organization organization = null;
		try {
			organization = organizationDao.findByNis(nis);
		} catch (Exception e) {
			log.error("get by NIS Organization failed", e);
			throw new MessManager().new FindingException("Organization");
		} finally {
		}
		return organization;
	}

	@Override
	public Organization findOrganizationByName(String name) throws Exception {
		Organization organization = null;
		try {
			organization = organizationDao.findByName(name);
		} catch (Exception e) {
			log.error("get by name Organization failed", e);
			throw new MessManager().new FindingException("Organization");
		} finally {
		}
		return organization;

	}

}
