package com.cleansolution.general.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.JpaDao;
import com.cleansolution.general.model.Organization;


@Repository("organizationDao")
@Transactional
public class OrganizationDAO extends JpaDao<Organization, Integer> implements IOrganizationDAO {
	
	

	public OrganizationDAO() {
		super();
		
	}

	public OrganizationDAO(Class<Organization> entityClass) {
		super(entityClass);
	}

	@Override
	public List<Organization> findAll() throws DaoException {
		return entityManager.createNamedQuery("Organization.findAll").getResultList();
	}

	@Override
	public Organization findByName(String name) throws DaoException {
		return (Organization) entityManager.createNamedQuery("Organization.findByName").setParameter("name", name).getSingleResult();
	}

	@Override
	public Organization findByPartyId(Integer partyId) throws DaoException {
		return (Organization) entityManager.createNamedQuery("Organization.findByPartyId").setParameter("partyId", partyId).getSingleResult();
	}

	@Override
	public Organization findByNis(String nis) throws DaoException {
		return (Organization) entityManager.createNamedQuery("Organization.findByNis").setParameter("nis", nis).getSingleResult();
	}

	
}
