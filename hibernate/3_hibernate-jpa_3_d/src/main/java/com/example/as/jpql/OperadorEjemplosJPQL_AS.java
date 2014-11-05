/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.as.jpql;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.example.as.CargarDatosAS;
import com.example.dao.AccionBursatilDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.Categoria;
import com.example.entity.RegistroDiarioAccion;
import com.example.entity.helper.AccionBursatilEH;
import com.example.entity.helper.CategoriaEH;
import com.example.entity.helper.DetalleAccionEH;
import com.example.entity.helper.RegistroDiarioAccionEH;
import com.example.util.JPAUtil;

/**
 *
 * @author usuario1
 */
public class OperadorEjemplosJPQL_AS {

    private static Logger logger = Logger.getLogger(OperadorEjemplosJPQL_AS.class.getName());

    public void ejemploFrom() throws Exception {

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
            List<AccionBursatil> accionBursatils = accionBursatilDAO.jpql_obtenerAccionDTOs();

            System.out.println(">>>accionBursatils.size():"
                    +  accionBursatils.size());


            Iterator<AccionBursatil> it1 = accionBursatils.iterator();
            AccionBursatil accionBursatilTmp;
            while (it1.hasNext()) {
            	accionBursatilTmp = it1.next();
                System.out.println(">>>accionBursatilTmp:"
                        + AccionBursatilEH.toString(accionBursatilTmp) );

                System.out.println(">>>accionBursatilTmp.getDetalleAccion():"
                        + DetalleAccionEH.toString( accionBursatilTmp.getDetalleAccion()) );

                Iterator<Categoria> it2 = accionBursatilTmp.getCategorias().iterator();
                Categoria categoriaTmp;
                while (it2.hasNext()) {
                	categoriaTmp = it2.next();
                    System.out.println(">>>categoriaTmp:"
                            + CategoriaEH.toString(categoriaTmp) );
                }

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

    public void ejemploFromInnerJoin() throws Exception {

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
            List<Object[]> datos =
                    accionBursatilDAO.jpql_obtenerAccionDTOsInnerJoinRegistroDiarioDTOs();


            System.out.println(">>>datos.size:"
                    + datos.size());


            Iterator<Object[]> it1 = datos.iterator();
            AccionBursatil accionBursatilEntityTmp;
            Categoria categoriaEntityTmp;
            RegistroDiarioAccion registroDiarioAccionTmp;
            while (it1.hasNext()) {
                Object[] objectsTmp = it1.next();

                System.out.println(">>>objectsTmp.length:"
                        + objectsTmp.length);
                accionBursatilEntityTmp = (AccionBursatil) objectsTmp[0];
                System.out.println(">>>accionBursatilEntityTmp:"
                        +  AccionBursatilEH.toString(accionBursatilEntityTmp) );
                //categoriaTmp = (Categoria) objectsTmp[1];
                //System.out.println(">>>categoriaTmp:"
                //        + categoriaTmp);
                registroDiarioAccionTmp = (RegistroDiarioAccion) objectsTmp[1];
                System.out.println(">>>registroDiarioAccionTmp:"
                        + RegistroDiarioAccionEH.toString(registroDiarioAccionTmp) );

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

    public void ejemploFromOuterJoin() throws Exception {

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
            List<Object[]> datos = accionBursatilDAO.jpql_obtenerAccionDTOsLeftJoinRegistroDiarioDTOs();


            System.out.println(">>>accionDTOs.size:"
                    + datos.size());


            Iterator<Object[]> it1 = datos.iterator();
            AccionBursatil accionBursatilTmp;
            Categoria categoriaTmp;
            RegistroDiarioAccion registroDiarioAccionTmp;
            while (it1.hasNext()) {
                Object[] objectsTmp = it1.next();

                System.out.println(">>>objectsTmp.length:"
                        + objectsTmp.length);
                accionBursatilTmp = (AccionBursatil) objectsTmp[0];
                System.out.println(">>>accionBursatilTmp:"
                        + AccionBursatilEH.toString(accionBursatilTmp) );
                //categoriaTmp = (Categoria) objectsTmp[1];
                //System.out.println(">>>categoriaTmp:"
                //        + categoriaTmp);
                registroDiarioAccionTmp = (RegistroDiarioAccion) objectsTmp[1];
                System.out.println(">>>RegistroDiarioAccion:"
                        + RegistroDiarioAccionEH.toString(registroDiarioAccionTmp) );

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

    public void ejemploSelect() throws Exception {

//        EntityManager em = null;
//
//        try {
//			em = JPAUtil.getEMF1().createEntityManager();
//            em.getTransaction().begin();
//
//            CargarDatosAS cargarDatosAS = new CargarDatosAS();
//            cargarDatosAS.setEntityManager(em);
//            cargarDatosAS.cargarDatos();
//
//            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
//            accionBursatilDAO.setEntityManager(em);
//            List<Object[]> datos = accionBursatilDAO.jpql_obtenerSelect1DeAccion();
//
//            System.out.println(">>>datos.size:"
//                    + datos.size());
//
//            Iterator<Object[]> it1 = datos.iterator();
//            Object[] objectsTmp;
//            String datoTmp;
//            while (it1.hasNext()) {
//                objectsTmp = it1.next();
//                datoTmp = (String) objectsTmp[0];
//
//                System.out.print(">>>datoTmp[0]:"
//                        + datoTmp);
//                datoTmp = (String) objectsTmp[1];
//
//                System.out.print(">>>datoTmp[1]:"
//                        + datoTmp);
//                System.out.println("");
//
//            }
//
//            em.getTransaction().commit();
//
//        } catch (Exception e1_1) {
//
//            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
//            try {
//                if (em != null && em.getTransaction() != null) {
//                    em.getTransaction().rollback();
//                }
//
//            } catch (Exception e1_2) {
//
//                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
//                throw e1_2;
//            }
//            throw e1_1;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }

    }

    public void ejemploUpdate() throws Exception {

//        EntityManager em = null;
//
//        try {
//
//			em = JPAUtil.getEMF1().createEntityManager();
//            em.getTransaction().begin();
//
//            CargarDatosAS cargarDatosAS = new CargarDatosAS();
//            cargarDatosAS.setEntityManager(em);
//            cargarDatosAS.cargarDatos();
//
//            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
//            accionBursatilDAO.setEntityManager(em);
//            AccionBursatil accionBursatil = 
//                    accionBursatilDAO.findById(1);
//
//            System.out.println(">>>accionBursatil:"
//                    + AccionBursatilEH.toString(accionBursatil) );
//
//            int res = accionBursatilDAO.jpql_updateAccion(1);
//
//            System.out.println(">>>res:"
//                    + res);
//
//            em.refresh(accionBursatil);
//            System.out.println(">>>accionBursatil:"
//                    + AccionBursatilEH.toString(accionBursatil) );
//
//
//            em.getTransaction().commit();
//
//        } catch (Exception e1_1) {
//            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
//            try {
//                if (em != null && em.getTransaction() != null) {
//                    em.getTransaction().rollback();
//                }
//
//            } catch (Exception e1_2) {
//
//                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
//                throw e1_2;
//            }
//            throw e1_1;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }

    }

    public void ejemploInsert() throws Exception {
        
//        EntityManager em = null;
//
//        try {
//
//			em = JPAUtil.getEMF1().createEntityManager();
//            em.getTransaction().begin();
//
//            CargarDatosAS cargarDatosAS = new CargarDatosAS();
//            cargarDatosAS.setEntityManager(em);
//            cargarDatosAS.cargarDatos();
//
//            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
//            accionBursatilDAO.setEntityManager(em);
//            
//            AccionBursatil accionBursatil = 
//                    accionBursatilDAO.findById( 1);
//
//            System.out.println(">>>accionBursatil:"
//                    + AccionBursatilEH.toString(accionBursatil) );
//
//            int res = accionBursatilDAO.jpql_insertAccion(1);
//
//            System.out.println(">>>res:"
//                    + res);
//
//            em.getTransaction().commit();
//
//        } catch (Exception e1_1) {
//
//            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
//            try {
//                if (em != null && em.getTransaction() != null) {
//                    em.getTransaction().rollback();
//                }
//
//            } catch (Exception e1_2) {
//
//                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
//                throw e1_2;
//            }
//            throw e1_1;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }

    }

    public void ejemploDelete() throws Exception {
        
//        EntityManager em = null;
//
//
//        try {
//
//			em = JPAUtil.getEMF1().createEntityManager();
//            em.getTransaction().begin();
//
//            CargarDatosAS cargarDatosAS = new CargarDatosAS();
//            cargarDatosAS.setEntityManager(em);
//            cargarDatosAS.cargarDatos();
//
//            AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
//            accionBursatilDAO.setEntityManager(em);
//            
//            AccionBursatil accionBursatil = 
//                    accionBursatilDAO.findById( 1);
//
//            System.out.println(">>>accionBursatil:"
//                    + AccionBursatilEH.toString(accionBursatil) );
//
//            AccionBursatil accionBursatil1 = new AccionBursatil();
//            accionBursatilDAO.setEntityManager(em);
//            int res = accionBursatilDAO.jpql_deleteDetalleAccion();
//
//            System.out.println(">>>res:"
//                    + res);
//
//            em.getTransaction().commit();
//
//        } catch (Exception e1_1) {
//            logger.error("e1_1:" + e1_1.getMessage(), e1_1);
//            try {
//                if (em != null && em.getTransaction() != null) {
//                    em.getTransaction().rollback();
//                }
//
//            } catch (Exception e1_2) {
//
//                logger.error("e1_2:" + e1_2.getMessage(), e1_2);
//                throw e1_2;
//            }
//            throw e1_1;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//


    }
}
