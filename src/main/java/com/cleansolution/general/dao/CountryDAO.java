package com.cleansolution.general.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.JpaDao;
import com.cleansolution.general.model.Country;

@Repository("countryDao")
@Transactional
public class CountryDAO extends JpaDao<Country, Integer> implements ICountryDAO {
	
	

	public CountryDAO() {
		super(Country.class);
	}

	@Override
	public List<Country> findAll() throws DaoException {
		return entityManager.createNamedQuery("Country.findAll").getResultList();
	}

	@Override
	public Country findByNameEn(String nameEn) throws DaoException {
		return (Country) entityManager.createNamedQuery("Country.findByNameEn").setParameter("nameEn", nameEn).getSingleResult();
	}

	@Override
	public Country findByNameFr(String nameFr) throws DaoException {
		return (Country) entityManager.createNamedQuery("Country.findByNameFr").setParameter("nameFr", nameFr).getSingleResult();
	}

	@Override
	public Country findById(Integer countryId) throws DaoException {
		return (Country) entityManager.createNamedQuery("Country.findById").setParameter("countryId", countryId).getSingleResult();
	}
	
}