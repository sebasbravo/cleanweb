package com.cleansolution.general.dao;

import java.util.List;
import java.util.Set;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.GenericDao;
import com.cleansolution.general.model.Country;


public interface ICountryDAO extends GenericDao<Country, Integer> {
		List<Country> findAll()throws DaoException;
		Country findById(Integer countryId)throws DaoException;
		Country findByNameEn(String nameEn) throws DaoException;
		Country findByNameFr(String nameFr) throws DaoException;
}