package com.cleansolution.general.dao;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.JpaDao;
import com.cleansolution.general.model.Cities;


@Repository("citiesDao")
@Transactional
public class CitiesDAO extends JpaDao<Cities, Integer> implements ICitiesDAO {
	
	

	public CitiesDAO() {
		super(Cities.class);
	}

	@Override
	public List<Cities> findAll() throws DaoException {
		return entityManager.createNamedQuery("Cities.findAll").getResultList();
	}

	@Override
	public List<Cities> findByState(Integer stateId) throws DaoException {
		return entityManager.createNamedQuery("Cities.findByState").setParameter("stateId", stateId).getResultList();
	}
	
	
}