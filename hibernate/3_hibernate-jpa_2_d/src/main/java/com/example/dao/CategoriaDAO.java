package com.example.dao;

// Generated 18/11/2013 09:07:00 PM by Hibernate Tools 4.0.0

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.entity.Categoria;

/**
 * Home object for domain model class Categoria.
 * @see com.example.dao.Categoria
 * @author Hibernate Tools
 */

public class CategoriaDAO {

	private static final Log log = LogFactory.getLog(CategoriaDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Categoria transientInstance) {
		log.debug("persisting Categoria instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Categoria persistentInstance) {
		log.debug("removing Categoria instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Categoria merge(Categoria detachedInstance) {
		log.debug("merging Categoria instance");
		try {
			Categoria result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categoria findById(Integer id) {
		log.debug("getting Categoria instance with id: " + id);
		try {
			Categoria instance = entityManager.find(Categoria.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
