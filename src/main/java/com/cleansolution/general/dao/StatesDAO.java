package com.cleansolution.general.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.JpaDao;
import com.cleansolution.general.model.States;


@Repository("statesDao")
@Transactional
public class StatesDAO extends JpaDao<States, Integer> implements IStatesDAO {
	
	

	public StatesDAO() {
		super(States.class);
	}

	@Override
	public List<States> findAll() throws DaoException {
		return entityManager.createNamedQuery("States.findAll").getResultList();
	}

	@Override
	public States findByName(String name) throws DaoException {
		return (States) entityManager.createNamedQuery("States.findByName").setParameter("name", name).getSingleResult();
	}

	@Override
	public List<States> findByCountry(Integer countryId) throws DaoException {
		return entityManager.createNamedQuery("States.findByCountry").setParameter("countryId", countryId).getResultList();
	}
	
}