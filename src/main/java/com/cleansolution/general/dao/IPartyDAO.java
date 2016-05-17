package com.cleansolution.general.dao;

import com.cleansolution.general.daoapi.DaoException;
import com.cleansolution.general.daoapi.GenericDao;
import com.cleansolution.general.model.Party;

public interface IPartyDAO extends GenericDao<Party, Integer> {
	
	Party findByPartyId(Integer partyId) throws DaoException;
}
