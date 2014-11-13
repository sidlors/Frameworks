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
import com.example.entity.Jugador;

/**
 * Home object for domain model class Jugadores.
 * @see com.example.dao.Jugadores
 * @author Hibernate Tools
 */

public class JugadoresDAO {

	private static final Log log = LogFactory.getLog(JugadoresDAO.class);

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
	public void persist(Jugador transientInstance) {
		log.debug("persisting Jugadores instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)	
	public void remove(Jugador persistentInstance) {
		log.debug("removing Jugadores instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)	
	public Jugador merge(Jugador detachedInstance) {
		log.debug("merging Jugadores instance");
		try {
			Jugador result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)	
	public Jugador findById(Integer id) {
		log.debug("getting Jugadores instance with id: " + id);
		try {
			Jugador instance = entityManager.find(Jugador.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)	
	public List<Jugador> findAll() {
		log.debug("getting all Jugadors " );
		try {
			List<Jugador> instances = entityManager.createQuery("from Jugador j").getResultList();
			log.debug("get successful");
			return instances;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}		
	
}
