package com.example.as.oto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.example.dao.AccionBursatilDAO;
import com.example.dao.DetalleAccionDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.DetalleAccion;
import com.example.entity.helper.AccionBursatilEH;
import com.example.entity.helper.DetalleAccionEH;
import com.example.util.JPAUtil;

public class OTO_1_AS {

	public void m1() throws Exception {
		EntityManager em = null;
		try {
			em = JPAUtil.getEMF1().createEntityManager();

			em.getTransaction().begin();

			AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
			accionBursatilDAO.setEntityManager(em);

			DetalleAccionDAO detalleAccionDAO = new DetalleAccionDAO();
			detalleAccionDAO.setEntityManager(em);

			/*- >>>INICIO - Declaraciones<<<*/

			AccionBursatil accionBursatil = new AccionBursatil();
			accionBursatil.setCodigoAccion(UUID.randomUUID().toString()
					.substring(0, 15));
			accionBursatil.setNombreAccion("Alimento para perros");

			DetalleAccion detalleAccion = new DetalleAccion();
			detalleAccion.setDescripcionCompania("Comida para Perros");
			detalleAccion.setNombreCompania("PerroFeliz");
			detalleAccion.setFechaRevision(new Date());

			/*- >>>FIN - Declaraciones<<<*/

			/*- >>>INICIO - Relaciones<<<*/

			accionBursatil.setDetalleAccion(detalleAccion); 
			/*- inverso de relacion relacionado - opcional*/
			
			detalleAccion.setAccionBursatil(accionBursatil); 
			/*- propietario de relacion relacionado - tipicamente obligatorio*/

			/*- >>>FIN - Relaciones<<<*/

			/*- >>>INICIO - Operacion/Persistencia<<<*/

			/*- Por restriccion de llave foranea, orden persistencia :
			 * Persistir inverso de relacion, Persistir propietario de relacion relacionado 
			 * (sino se produce error)
			 * 
			 * NOTA:
			 * Si inverso de relacion relacionado o propietario de relacion relacionado tuviera cascade=ALL, 
			 * se propaga la "operacion" a la otra entidad en orden requerido
			 * @OneToOne(cascade = CascadeType.ALL..)
			 */


			/*- InicioCaso1 - por restriccion de llave foranea, correcto (inverso puede o no tener 
			 * cascade=ALL)(default)*/
			accionBursatilDAO.persist(accionBursatil);
			detalleAccionDAO.persist(detalleAccion);
			/*- FinCaso1*/

			/*- InicioCaso2 - cascade=ALL*/
			 accionBursatilDAO.persist(accionBursatil);
			/*- FinCaso2*/
			
			
			/*- >>>FIN - Operacion/Persistencia<<<*/

			/*- >>>INICIO - Recuperacion<<<*/
			em.flush();

			em.clear();

			if (!em.contains(accionBursatil)) {
				System.out.println(">>>accionBursatilEntity fue desalojada..");
			}
			if (!em.contains(detalleAccion)) {
				System.out.println(">>>detalleAccionEntity fue desalojada..");
			}

			AccionBursatil accionBursatilObtenido = (AccionBursatil) accionBursatilDAO
					.findById(accionBursatil.getIdAccionBursatil());

			em.clear();

			System.out.println(">>>accionBursatil1Obtenido:"
					+ AccionBursatilEH.toString(accionBursatilObtenido) );
			System.out.println(">>>accionBursatil1Obtenido.getDetalleAccion():"
					+  DetalleAccionEH.toString(accionBursatilObtenido.getDetalleAccion()) ); 
			/*-Relacion *ToOne es Fetch Eager, por eso podemos ver la entidad*/
			/*- >>>FIN - Recuperacion<<<*/

			/*- >>>INICIO - Remove<<<*/
			AccionBursatil accionBursatilObtenido2 = (AccionBursatil) accionBursatilDAO
					.findById(accionBursatil.getIdAccionBursatil());

			/*- InicioCaso1 -  */
			/*- por restriccion de llave foranea, correcto si inverso de relacion relacionado 
			 * tuviera cascade=ALL*/
			em.remove(accionBursatilObtenido2);
			/*- FinCaso1*/

			/*- InicioCaso2 - por restriccion de llave foranea,correcto removiendo propietario de 
			 * relacion y desreferenciando*/
			DetalleAccion detalleAccionObtenido2 = accionBursatilObtenido2.getDetalleAccion();
			accionBursatilObtenido2.setDetalleAccion(null);
			em.remove(detalleAccionObtenido2);			
			/*- FinCaso2*/
			
			
			accionBursatilObtenido2.setDetalleAccion(null);
			
			/*- >>>FIN - Remove<<<*/

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				if (em != null && em.getTransaction() != null
						&& em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				throw e2;
			}

			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
