package com.cleansolution.general.daoapi;


public interface GenericDao<T, ID> {
	
	T findById(ID id) throws DaoException;
	
	void persist(T obj) throws DaoException;
	
	void merge(T obj)throws DaoException;
	
	void remove(T obj)throws DaoException;
	
    void deleteById(ID id) throws DaoException;

    void deleteAll() throws DaoException;

    Long count();

   }
