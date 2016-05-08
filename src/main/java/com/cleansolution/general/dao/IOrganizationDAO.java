package com.cleansolution.general.dao;

import java.util.List;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.GenericDao;
import com.cleansolution.general.model.Organization;


public interface IOrganizationDAO extends GenericDao<Organization, Integer>{
	
	List<Organization> findAll() throws DaoException;
	Organization findByName(String name) throws DaoException;
	Organization findByPartyId(Integer partyId) throws DaoException;
	Organization findByNis(String nis) throws DaoException;
	

}
