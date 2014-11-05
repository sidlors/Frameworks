/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.as;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.example.as.jpql.OperadorEjemplosJPQL_AS;
import com.example.dao.AccionBursatilDAO;
import com.example.dao.CategoriaDAO;
import com.example.dao.DetalleAccionDAO;
import com.example.dao.RegistroDiarioAccionDAO;
import com.example.dao.VariacionDiariaDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.Categoria;
import com.example.entity.DetalleAccion;
import com.example.entity.RegistroDiarioAccion;
import com.example.entity.VariacionDiaria;
import com.example.util.JPAUtil;

/**
 *
 * @author usuario1
 */
public class CargarDatosAS {

    private static Logger logger = Logger.getLogger(CargarDatosAS.class.getName());

	
    private EntityManager em = null;

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * @param args the command line arguments
     */
    public void cargarDatos() throws Exception {


        AccionBursatilDAO accionBursatilDAO =
                new AccionBursatilDAO();
        accionBursatilDAO.setEntityManager(em);

        CategoriaDAO categoriaDAO =
                new CategoriaDAO();
        categoriaDAO.setEntityManager(em);

        RegistroDiarioAccionDAO registroDiarioAccionDAO =
                new RegistroDiarioAccionDAO();
        registroDiarioAccionDAO.setEntityManager(em);

        VariacionDiariaDAO variacionDiariaDAO =
                new VariacionDiariaDAO();
        variacionDiariaDAO.setEntityManager(em);

        DetalleAccionDAO detalleAccionDAO =
                new DetalleAccionDAO();
        detalleAccionDAO.setEntityManager(em);

		/*- >>>INICIO - Declaraciones<<<*/

		/*- Incio bloque 1(si)*/

        AccionBursatil accionBursatil_AlimentoPerros = new AccionBursatil();
        accionBursatil_AlimentoPerros.setCodigoAccion(UUID.randomUUID().toString().substring(0, 15));
        accionBursatil_AlimentoPerros.setNombreAccion("Alimento para perros");

        AccionBursatil accionBursatil_AlimentoGatos = new AccionBursatil();
        accionBursatil_AlimentoGatos.setCodigoAccion(UUID.randomUUID().toString().substring(0, 15));
        accionBursatil_AlimentoGatos.setNombreAccion("Alimento para gatos");

        Categoria categoria_Alimentos = new Categoria();
        categoria_Alimentos.setNombre("Alimentos");
        categoria_Alimentos.setDescripcion("Todo tipo de accion relacionada con alimentos");

        Categoria categoria_Caninos = new Categoria();
        categoria_Caninos.setNombre("Caninos");
        categoria_Caninos.setDescripcion("Todo tipo de accion relacionada con perros");

		/*- Fin bloque 1*/


		/*- Incio bloque 2(si)*/


		/*-RegistroDiarioAccion y VariacionDiarias 1*/
		Calendar now1 = Calendar.getInstance();
		now1.add(Calendar.DATE, -1);

		RegistroDiarioAccion registroDiarioAccion1 = new RegistroDiarioAccion();
		registroDiarioAccion1.setFecha(now1.getTime());
		registroDiarioAccion1.setPrecioApertura(10000.0f);
		registroDiarioAccion1.setPrecioCierre(50000.0f);

		VariacionDiaria variacionDiaria1_1 = new VariacionDiaria();
		variacionDiaria1_1.setVariacion(20000f);

		VariacionDiaria variacionDiaria1_2 = new VariacionDiaria();
		variacionDiaria1_2.setVariacion(20000f);

		/*-RegistroDiarioAccion y VariacionDiarias 2*/
		Calendar now2 = Calendar.getInstance();
		now2.add(Calendar.DATE, -2);

		RegistroDiarioAccion registroDiarioAccion2 = new RegistroDiarioAccion();
		registroDiarioAccion2.setFecha(now2.getTime());
		registroDiarioAccion2.setPrecioApertura(8000.0f);
		registroDiarioAccion2.setPrecioCierre(11000.0f);

		VariacionDiaria variacionDiaria2_1 = new VariacionDiaria();
		variacionDiaria2_1.setVariacion(2000f);

		VariacionDiaria variacionDiaria2_2 = new VariacionDiaria();
		variacionDiaria2_2.setVariacion(1000f);

		/*- Fin bloque 2*/

		/*- Incio bloque 3(si)*/
		DetalleAccion detalleAccion = new DetalleAccion();
		detalleAccion.setDescripcionCompania("Comida para Perros");
		detalleAccion.setNombreCompania("PerroFeliz");
		detalleAccion.setFechaRevision(new Date());

		/*- Fin bloque 3*/
		
		/*- >>>FIN - Declaraciones<<<*/

		/*- >>>INICIO - Relaciones<<<*/

        
		/*- Incio bloque 1(si)*/

        Collection<AccionBursatil> accionBursatilEntitys_AlimentosPerros_AlimentosGatos =
                new ArrayList<AccionBursatil>();
        accionBursatilEntitys_AlimentosPerros_AlimentosGatos.add(accionBursatil_AlimentoPerros);
        accionBursatilEntitys_AlimentosPerros_AlimentosGatos.add(accionBursatil_AlimentoGatos);

        Collection<AccionBursatil> accionBursatilEntitys_AlimentoPerros =
                new ArrayList<AccionBursatil>();
        accionBursatilEntitys_AlimentoPerros.add(accionBursatil_AlimentoPerros);

        Collection<Categoria> categorias_Alimentos_Caninos = new ArrayList<Categoria>();
        categorias_Alimentos_Caninos.add(categoria_Alimentos);
        categorias_Alimentos_Caninos.add(categoria_Caninos);

        Collection<Categoria> categoriaEntitys_Alimentos = new ArrayList<Categoria>();
        categoriaEntitys_Alimentos.add(categoria_Alimentos);

        accionBursatil_AlimentoPerros.setCategorias((List<Categoria>)categorias_Alimentos_Caninos);
        accionBursatil_AlimentoGatos.setCategorias((List<Categoria>)categoriaEntitys_Alimentos);
        categoria_Alimentos.setAccionesBursatiles((List<AccionBursatil>)accionBursatilEntitys_AlimentosPerros_AlimentosGatos);
        categoria_Caninos.setAccionesBursatiles((List<AccionBursatil>)accionBursatilEntitys_AlimentoPerros);

		/*- Fin bloque 1*/
        
        
		/*- Incio bloque 2(si)*/
		/*-RegistroDiarioAccion y VariacionDiarias 1*/
		variacionDiaria1_1.setRegistroDiarioAccion(registroDiarioAccion1); /*-propietario de relacion relacionado - tipicamente obligatorio*/
		variacionDiaria1_2.setRegistroDiarioAccion(registroDiarioAccion1); /*-propietario de relacion relacionado - tipicamente obligatorio*/

		Collection<VariacionDiaria> variacionDiarias1 = new ArrayList<VariacionDiaria>();
		variacionDiarias1.add(variacionDiaria1_1);
		variacionDiarias1.add(variacionDiaria1_2);

		registroDiarioAccion1
				.setVariacionesDiarias((List<VariacionDiaria>) variacionDiarias1); /*-inverso de relacion relacionado - opcional*/

		/*-RegistroDiarioAccion y VariacionDiarias 2*/
		variacionDiaria2_1.setRegistroDiarioAccion(registroDiarioAccion2); /*-propietario de relacion relacionado - tipicamente obligatorio*/
		variacionDiaria2_2.setRegistroDiarioAccion(registroDiarioAccion2); /*-propietario de relacion relacionado - tipicamente obligatorio*/

		Collection<VariacionDiaria> variacionDiarias2 = new ArrayList<VariacionDiaria>();
		variacionDiarias2.add(variacionDiaria2_1);
		variacionDiarias2.add(variacionDiaria2_2);

		registroDiarioAccion2
				.setVariacionesDiarias((List<VariacionDiaria>) variacionDiarias2); /*-inverso de relacion relacionado - opcional*/

		/*-AccionBursatil y RegistroDiarioAcciones*/
		registroDiarioAccion1.setAccionBursatil(accionBursatil_AlimentoPerros); /*-propietario de relacion relacionado - tipicamente obligatorio*/
		registroDiarioAccion2.setAccionBursatil(accionBursatil_AlimentoPerros); /*-propietario de relacion relacionado - tipicamente obligatorio*/

		Collection<RegistroDiarioAccion> registroDiarioAccions = new ArrayList<RegistroDiarioAccion>();
		registroDiarioAccions.add(registroDiarioAccion1);
		registroDiarioAccions.add(registroDiarioAccion2);

		accionBursatil_AlimentoPerros
				.setRegistrosDiariosAcciones((List<RegistroDiarioAccion>) registroDiarioAccions); /*-inverso de relacion relacionado - opcional*/

		/*- Fin bloque 2*/
        
		/*- Incio bloque 3(si)*/
		accionBursatil_AlimentoPerros.setDetalleAccion(detalleAccion); /*- inverso de relacion relacionado - opcional*/
		detalleAccion.setAccionBursatil(accionBursatil_AlimentoPerros); /*- propietario de relacion relacionado - tipicamente obligatorio*/
		/*- Fin bloque 3*/
        
		/*- >>>FIN - Relaciones<<<*/


		/*- >>>INICIO - Operacion/Persistencia<<<*/
        
		/*- Incio bloque 1(si)*/

        accionBursatilDAO.persist(accionBursatil_AlimentoPerros);
        accionBursatilDAO.persist(accionBursatil_AlimentoGatos);
        categoriaDAO.persist(categoria_Alimentos);
        categoriaDAO.persist(categoria_Caninos);

		/*- Fin bloque 1*/

		/*- Incio bloque 2(si)*/

		registroDiarioAccionDAO.persist(registroDiarioAccion1);
		variacionDiariaDAO.persist(variacionDiaria1_1);
		variacionDiariaDAO.persist(variacionDiaria1_2);

		registroDiarioAccionDAO.persist(registroDiarioAccion2);
		variacionDiariaDAO.persist(variacionDiaria2_1);
		variacionDiariaDAO.persist(variacionDiaria2_2);

		/*- Fin bloque 2*/

		/*- Incio bloque 3(si)*/

		detalleAccionDAO.persist(detalleAccion);
		
		/*- Fin bloque 3*/


		/*- >>>FIN - Operacion/Persistencia<<<*/

                
        em.flush();

        em.clear();


    }
    

    public void ejecucionSoloCargaDatos() throws Exception {

        EntityManager em = null;
        
        try {

			em = JPAUtil.getEMF1().createEntityManager();
            em.getTransaction().begin();

            CargarDatosAS cargadorDatosDAO = new CargarDatosAS();
            cargadorDatosDAO.setEntityManager(em);
            cargadorDatosDAO.cargarDatos();


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

    
    public static void main(String[] args)  {

        try {
            CargarDatosAS cargarDatosAS = new CargarDatosAS();
            cargarDatosAS.ejecucionSoloCargaDatos();
            JPAUtil.getEMF1().close();
        } catch (Throwable t) {
            logger.error("t:" + t.getMessage(),t);
            System.out.println("Hubo un pequeño error..");
        }

    }
    
    
}
