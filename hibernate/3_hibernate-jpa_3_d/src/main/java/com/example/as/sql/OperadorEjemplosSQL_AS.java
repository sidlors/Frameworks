/*
APPLICATION SERVICE
 */
package com.example.as.sql;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.example.as.CargarDatosAS;
import com.example.dao.AccionBursatilDAO;
import com.example.dao.VariacionDiariaDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.VariacionDiaria;
import com.example.util.JPAUtil;

/**
 *
 * @author usuario1
 */
public class OperadorEjemplosSQL_AS {

    private static Logger logger = Logger.getLogger(OperadorEjemplosSQL_AS.class.getName());

    public void ejemploSelect() throws Exception {

        EntityManager em = null;

        try {

			em = JPAUtil.getEMF1().createEntityManager();
			em.getTransaction().begin();

            CargarDatosAS cargadorDatosDAO = new CargarDatosAS();
            cargadorDatosDAO.setEntityManager(em);
            cargadorDatosDAO.cargarDatos();

            AccionBursatilDAO accionBursatilDAO =
                    new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);
            
            List<Object[]> datos = accionBursatilDAO.sql_select();


            System.out.println("datos.size:"
                    + datos.size());


            Iterator<Object[]> it1 = datos.iterator();
            Object[] objectsTmp;
            String datoTmp;
            while (it1.hasNext()) {
                objectsTmp = it1.next();
                datoTmp = (String) objectsTmp[0];

                System.out.println("datoTmp:"
                        + datoTmp);
                datoTmp = (String) objectsTmp[1];

                System.out.println("datoTmp:"
                        + datoTmp);

            }

            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void ejemploSelectEntity() throws Exception {

        EntityManager em = null;

        try {
        	
        	em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.setEntityManager(em);
            cargarDatosAS.cargarDatos();

            AccionBursatilDAO accionBursatilDAO =
                    new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);

            List<AccionBursatil> datos = accionBursatilDAO.sql_selectEntity();


            System.out.println("datos.size:"
                    + datos.size());

            
            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void ejemploInsert() throws Exception {

        EntityManager em = null;

        try {
        	
        	em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.setEntityManager(em);
            cargarDatosAS.cargarDatos();

            AccionBursatilDAO accionBursatilDAO =
                    new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);
            
            int res = accionBursatilDAO.sql_insert();


            System.out.println("res:"
                    + res);


            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }


    }

    public void ejemploUpdate() throws Exception {

        EntityManager em = null;

        try {
        	
        	em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.setEntityManager(em);
            cargarDatosAS.cargarDatos();

            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);
            
            
            int res = accionBursatilDAO.sql_update();

            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void ejemploDelete() throws Exception {

        EntityManager em = null;

        try {

        	em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.setEntityManager(em);
            cargarDatosAS.cargarDatos();

            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);
            
            int res = accionBursatilDAO.sql_delete();

            System.out.println("res:"
                    + res);

            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    
    public void ejemploDelete2() throws Exception {

        EntityManager em = null;

        try {
        	
            /*- NOTA: 
             * Si se recupera la entidad, no se altera, se elimina con un query directo, 
             * al concluir la transaccion no marca error(probado)*/
            /*- NOTA: 
             * Si se recupera la entidad, se altera, se elimina con un query directo, 
             * al concluir la transaccion marca error(probado)*/
            /*- NOTA: 
             * Si se recupera la entidad, se altera, se elimina con un query directo, 
             * se hace un refresh marca error porque no se encuentra el id(probado)*/
        	
        	em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.setEntityManager(em);
            cargarDatosAS.cargarDatos();

            VariacionDiariaDAO variacionDiariaDAO = new VariacionDiariaDAO();
            variacionDiariaDAO.setEntityManager(em);
            
            VariacionDiaria variacionDiaria = variacionDiariaDAO.findById(1);
            //variacionDiaria.setVariacion(200.0d);
            System.out.println("variacionDiaria:"+ variacionDiaria);
            
            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
            accionBursatilDAO.setEntityManager(em);

            
            int res = accionBursatilDAO.sql_delete();

            System.out.println("res:"
                    + res);

            //em.refresh(variacionDiaria);
            //System.out.println("variacionDiaria:"+ variacionDiaria);

            
            em.getTransaction().commit();

        } catch (Exception e1_1) {
            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
            try {
                if (em != null && em.getTransaction() != null) {
                    em.getTransaction().rollback();
                }

            } catch (Exception e1_2) {

                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
                throw e1_2;
            }
            throw e1_1;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
    
}
