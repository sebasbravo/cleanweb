package com.cleansolution.general.dao;

import java.util.List;
import java.util.Set;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.GenericDao;
import com.cleansolution.general.model.Country;
import com.cleansolution.general.model.States;


public interface IStatesDAO extends GenericDao<States, Integer>{
	List<States> findAll()throws DaoException;
	States findByName(String name) throws DaoException;
	List<States> findByCountry(Integer countryId) throws DaoException;
	
}