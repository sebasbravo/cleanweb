package com.cleansolution.general.dao;

import java.util.List;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.GenericDao;
import com.cleansolution.general.model.Cities;


public interface ICitiesDAO extends GenericDao<Cities, Integer>{
	
	List<Cities> findAll()throws DaoException;
	List<Cities> findByState(Integer stateId)throws DaoException;
	
}