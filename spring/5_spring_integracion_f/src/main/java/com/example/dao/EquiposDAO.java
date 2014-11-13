package com.example.dao;

// Generated 9/12/2013 11:40:57 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Equipo;

/**
 * Home object for domain model class Equipos.
 * @see com.example.dao.Equipos
 * @author Hibernate Tools
 */

public class EquiposDAO {

	private static final Log log = LogFactory.getLog(EquiposDAO.class);

	/**
	 * EntityManager que sera empleado en el DAO. Al ser inyectado por spring,
	 * se usa un proxy que es thread-safe por lo que la clase contenedora puede ser
	 * singleton. (ver spring-framework-reference 3.2.4.release pag ?)
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	public void persist(Equipo transientInstance) {
		log.debug("persisting Equipos instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	public void remove(Equipo persistentInstance) {
		log.debug("removing Equipos instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	public Equipo merge(Equipo detachedInstance) {
		log.debug("merging Equipos instance");
		try {
			Equipo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	public Equipo findById(Integer id) {
		log.debug("getting Equipos instance with id: " + id);
		try {
			Equipo instance = entityManager.find(Equipo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	public List<Equipo> findAll() {
		log.debug("getting all Equipos " );
		try {
			List<Equipo> instances = entityManager.createQuery("from Equipo e").getResultList();
			log.debug("get successful");
			return instances;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}	
	
}
