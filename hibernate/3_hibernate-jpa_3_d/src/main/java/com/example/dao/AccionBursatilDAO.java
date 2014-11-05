package com.example.dao;

// Generated 18/11/2013 09:07:00 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.entity.AccionBursatil;

/**
 * Home object for domain model class AccionBursatil.
 * @see com.example.dao.AccionBursatil
 * @author Hibernate Tools
 */

public class AccionBursatilDAO {

	private static final Log log = LogFactory.getLog(AccionBursatilDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(AccionBursatil transientInstance) {
		log.debug("persisting AccionBursatil instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AccionBursatil persistentInstance) {
		log.debug("removing AccionBursatil instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AccionBursatil merge(AccionBursatil detachedInstance) {
		log.debug("merging AccionBursatil instance");
		try {
			AccionBursatil result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccionBursatil findById(Integer id) {
		log.debug("getting AccionBursatil instance with id: " + id);
		try {
			AccionBursatil instance = entityManager.find(AccionBursatil.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	/***********************/
	/***********************/
	/***********************/

    

    public List<AccionBursatil> jpql_obtenerAccionDTOs() throws Exception {

        //List<AccionBursatilEntity> accionBursatilEntitys = entityManager.createQuery(
        //        "completar!! - Obtener todas las AccionBursatilEntity").getResultList();
        
        List<AccionBursatil> accionBursatilEntitys = entityManager.createQuery(
                "from AccionBursatil a where a.nombreAccion like :busqueda").
                setParameter("busqueda", "%perros%").getResultList();

        return accionBursatilEntitys;

    }

    public List<Object[]> jpql_obtenerAccionDTOsInnerJoinRegistroDiarioDTOs() throws Exception {

        List<Object[]> datos = entityManager.createQuery(
                "completar!! - Obtener todas las AccionBursatilEntity inner join registroDiarioAccionEntityCollection").
                getResultList();

        return datos;

    }

    public List<Object[]> jpql_obtenerAccionDTOsLeftJoinRegistroDiarioDTOs() throws Exception {

        List<Object[]> datos = entityManager.createQuery(
                "from AccionBursatilEntity a left join a.registroDiarioAccionEntityCollection a_rd").getResultList();

        return datos;

    }

    public List<Object[]> jpql_obtenerSelect1DeAccion() throws Exception {

        List<Object[]> datos = entityManager.createQuery(
                " select a.codigoAccion, a.nombreAccion from AccionBursatilEntity a "
                + " where a.nombreAccion like :nombreAccion").
                setParameter("nombreAccion", "%Alimento%").getResultList();

        return datos;

    }

    public int jpql_updateAccion(Integer idAccionBursatil) throws Exception {

        int res = entityManager.createQuery(
                " update AccionBursatilEntity a "
                + " set "
                + " a.codigoAccion = :codigoAccion, "
                + " a.nombreAccion = :nombreAccion "
                + " where a.idAccionBursatil = :idAccionBursatil").
                setParameter("codigoAccion", "actualizado!!").
                setParameter("nombreAccion", "actualizado!!").
                setParameter("idAccionBursatil", idAccionBursatil).executeUpdate();

        return res;

    }

    public int jpql_insertAccion(Integer idAccionBursatil) throws Exception {

        int res = entityManager.createQuery(
                " insert into AccionBursatilEntity(codigoAccion,nombreAccion) "
                + " select a.codigoAccion,a.codigoAccion from AccionBursatilEntity a "
                + " where a.idAccionBursatil = :idAccionBursatil").
                setParameter("idAccionBursatil", idAccionBursatil).executeUpdate();

        return res;

    }

    public int jpql_deleteDetalleAccion() throws Exception {

        int res = entityManager.createQuery(
                "completar!! - Eliminar todas las DetalleAccionEntity").
                executeUpdate();

        return res;

    }
    

	
	/***********************/
	/***********************/
	/***********************/


    

    public List<Object[]> sql_select() throws Exception {

        List<Object[]> datos = entityManager.createNativeQuery(
                " completar!! - seleccionar codigo_accion, nombre_accion de acciones_bursatiles"+
                " con nombre_accion like :nombreAccion").
                setParameter("nombreAccion", "%Alimento%").getResultList();

        return datos;

    }

    public List<AccionBursatil> sql_selectEntity() throws Exception {

        List<AccionBursatil> datos = entityManager.createNativeQuery(
                " select a.id_accion_bursatil,a.codigo_accion,a.nombre_accion from acciones_bursatiles a "
                + " where a.nombre_accion like :nombreAccion","sql_selectEntity").
                setParameter("nombreAccion", "%Alimento%").getResultList();

        return datos;

    }


    public int sql_insert() throws Exception {


        int res = entityManager.createNativeQuery(
                " completar!! - insertar en acciones_bursatiles(codigo_accion, nombre_accion) los valores (:uno, :dos)").
                setParameter("uno", "uno..").
                setParameter("dos", "dos..").
                executeUpdate();

        return res;

    }

    public int sql_update() throws Exception {


        int res = entityManager.createNativeQuery(
                " update acciones_bursatiles set nombre_accion = :nombreAccion where id_accion_bursatil = :idAccion").
                setParameter("nombreAccion", "alterado!!").
                setParameter("idAccion", 1).
                executeUpdate();

        return res;

    }

    public int sql_delete() throws Exception {


        int res = entityManager.createNativeQuery(
                " delete from variaciones_diarias").
                executeUpdate();

        return res;

    }
    
	
	
	
	
}
