package com.cleansolution.general.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.JpaDao;
import com.cleansolution.general.model.Party;

@Repository("partyDao")
@Transactional
public class PartyDAO extends JpaDao<Party, Integer> implements IPartyDAO {
	
	

	public PartyDAO() {
		super(Party.class);
	}

	@Override
	@Transactional
	public Party findByPartyId(Integer partyId) throws DaoException {
		return (Party) entityManager.createNamedQuery("Party.findByPartyId").setParameter("partyId", partyId).getSingleResult();
	}

}
