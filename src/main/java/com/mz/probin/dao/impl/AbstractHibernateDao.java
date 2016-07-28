package com.mz.probin.dao.impl;

import com.mz.probin.dao.AbstractDao;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Super class of all Hibernate based DAOs.
 */
public abstract class AbstractHibernateDao extends AbstractDao {

    private final SessionFactory sessionFactory;


    public AbstractHibernateDao(SessionFactory sessionFactory) {
        Assert.notNull(sessionFactory, "SessionFactory cannot be null");
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public <T> T getEntityById(Class<T> clazz, Object id) {
        if (clazz == null || id == null) {
            return null;
        }

        return (T) getSession(false).get(clazz, (Serializable) id) ;
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
	@Transactional
    public <T> T getEntityByStringValue( String field, String fieldValue, Class<T> clazz ){
    	
    	return (T) this.sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.eq(field, fieldValue));
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
	public <T> List<T> getEntityListByStringValue( String field, String fieldValue, Class<T> clazz ){
    	
		List<T> objList = this.sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.eq(field, fieldValue)).list();
    	
    	if(objList.size() <= 0){
    		return Collections.EMPTY_LIST; 
    	}
    	
    	return objList;
    	
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <T> T persist(T entity) {
        if (entity == null) {
            return null;
        }

        getSession(false).saveOrUpdate(entity);
        return (T) entity;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getAll(Class<T> entityClass) {
        if (entityClass == null) {
            return Collections.EMPTY_LIST;
        }

        return createCriteria(entityClass).list();
    }

    /**
     * Get a {@link Session} from the underlying {@link SessionFactory}.
     * <p>The {@link Session} can be gotten in two different ways:
     * Either by retrieving an already existing session if any, or
     * creating a new one regardless of any currently running one.
     * @param openNewSession boolean value to determine if we should open
     * a new session and ignore any currently running one.
     * @return a {@link Session} from the {@link SessionFactory}.
     */
    protected Session getSession(boolean openNewSession) {
        if (openNewSession) {
            return this.sessionFactory.openSession();
        }

        return this.sessionFactory.getCurrentSession();
    }

    /**
     * Create a {@link Query} from a query string.
     *
     * @param query the query string.
     * @return a {@link Query} created from the query string.
     */
    protected Query createQuery(String query) {
        Assert.hasText(query, "Query string cannot be null or blank");
        return getSession(false).createQuery(query);
    }

    /**
     * Create a {@link SQLQuery} from a query string.
     *
     * @param query the query string
     * @return a {@link SQLQuery} created from the query string
     */
    protected SQLQuery createSQLQuery(String query) {
        Assert.hasText(query, "Query string cannot be null or blank");
        return getSession(false).createSQLQuery(query);
    }

    /**
     * Create a {@link Criteria} from an entity class.
     *
     * @param entityClass the entity class to create the {@link Criteria} from.
     * @return a {@link Criteria} with the entity class as the root.
     */
    protected Criteria createCriteria(Class<?> entityClass) {
        Assert.notNull(entityClass, "Entity class cannot be null");
        return getSession(false).createCriteria(entityClass);
    }

    protected SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
}
