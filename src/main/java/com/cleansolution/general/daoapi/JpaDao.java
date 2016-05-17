package com.cleansolution.general.daoapi;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings({"unchecked"})
@Transactional
public class JpaDao<T,ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> entityClass;
    private Logger log = null;
    
    @PersistenceContext
    protected EntityManager entityManager;
    private int maxResults = 0;
    
	public JpaDao() {
		super();
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		log = LoggerFactory.getLogger(entityClass);
	}
	
	

	public JpaDao(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
		log = LoggerFactory.getLogger(entityClass);
	}



	@Override
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public T findById(ID id) throws DaoException {
		return (T)entityManager.find(entityClass, id);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void persist(T obj) throws DaoException {
		entityManager.persist(obj);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void merge(T obj) throws DaoException {
		entityManager.merge(obj);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void remove(T obj) throws DaoException {
		entityManager.remove(obj);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void deleteById(ID id) throws DaoException {
		T toDelete = findById(id);
		entityManager.remove(toDelete);
	}


	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void deleteAll() throws DaoException {
		String queryString = "delete from " + entityClass.getName();
        Query queryObject = entityManager.createQuery(queryString);
        	  queryObject.executeUpdate();
	}

	@Override
	public Long count() {
		Query query = createQuery("select count(*) from " +entityClass.getName());
        Long result = (Long) query.getSingleResult();
        return (result != null) ? result : 0;
	}
	
	protected Query createQuery(String queryString) {
        Query query = entityManager.createQuery(queryString);
        prepareQuery(query);

        return query;
    }

    protected void prepareQuery(Query queryObject) {
        if (getMaxResults() > 0) {
            queryObject.setMaxResults(getMaxResults());
        }
    }
    
    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

}
