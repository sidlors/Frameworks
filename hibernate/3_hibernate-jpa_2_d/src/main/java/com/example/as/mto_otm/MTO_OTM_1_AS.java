package com.example.as.mto_otm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.example.dao.AccionBursatilDAO;
import com.example.dao.RegistroDiarioAccionDAO;
import com.example.dao.VariacionDiariaDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.RegistroDiarioAccion;
import com.example.entity.VariacionDiaria;
import com.example.entity.helper.AccionBursatilEH;
import com.example.entity.helper.RegistroDiarioAccionEH;
import com.example.entity.helper.VariacionDiariaEH;
import com.example.util.JPAUtil;

public class MTO_OTM_1_AS {

	public void m1() throws Exception {
		EntityManager em = null;
		try {
			em = JPAUtil.getEMF1().createEntityManager();

			em.getTransaction().begin();

			AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
			accionBursatilDAO.setEntityManager(em);

			RegistroDiarioAccionDAO registroDiarioAccionDAO = new RegistroDiarioAccionDAO();
			registroDiarioAccionDAO.setEntityManager(em);

			VariacionDiariaDAO variacionDiariaDAO = new VariacionDiariaDAO();
			variacionDiariaDAO.setEntityManager(em);

			/*- >>>INICIO - Declaraciones<<<*/

			AccionBursatil accionBursatil = new AccionBursatil();
			accionBursatil.setCodigoAccion(UUID.randomUUID().toString()
					.substring(0, 15));
			accionBursatil.setNombreAccion("Alimento para perros");

			/*->> RegistroDiarioAccion y VariacionDiarias 1*/
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

			/*->> RegistroDiarioAccion y VariacionDiarias 2*/
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

			/*- >>>FIN - Declaraciones<<<*/

			/*- >>>INICIO - Relaciones<<<*/

			/*- >>RegistroDiarioAccion y VariacionDiarias 1*/
			variacionDiaria1_1.setRegistroDiarioAccion(registroDiarioAccion1); 
			/*-propietario de relacion relacionado */
			
			variacionDiaria1_2.setRegistroDiarioAccion(registroDiarioAccion1); 
			/*-propietario de relacion relacionado */

			Collection<VariacionDiaria> variacionDiarias1 = new ArrayList<VariacionDiaria>();
			variacionDiarias1.add(variacionDiaria1_1);
			variacionDiarias1.add(variacionDiaria1_2);

			registroDiarioAccion1
					.setVariacionesDiarias((List<VariacionDiaria>) variacionDiarias1); 
			/*-inverso de relacion relacionado */

			/*- >> RegistroDiarioAccion y VariacionDiarias 2*/
			
			variacionDiaria2_1.setRegistroDiarioAccion(registroDiarioAccion2); 
			/*-propietario de relacion relacionado */
			
			variacionDiaria2_2.setRegistroDiarioAccion(registroDiarioAccion2); 
			/*-propietario de relacion relacionado */

			Collection<VariacionDiaria> variacionDiarias2 = new ArrayList<VariacionDiaria>();
			variacionDiarias2.add(variacionDiaria2_1);
			variacionDiarias2.add(variacionDiaria2_2);

			registroDiarioAccion2
					.setVariacionesDiarias((List<VariacionDiaria>) variacionDiarias2); 
			/*-inverso de relacion relacionado */

			/*- >> AccionBursatil y RegistroDiarioAcciones*/
			registroDiarioAccion1.setAccionBursatil(accionBursatil); 
			/*-propietario de relacion relacionado */
			
			registroDiarioAccion2.setAccionBursatil(accionBursatil); 
			/*-propietario de relacion relacionado */

			Collection<RegistroDiarioAccion> registroDiarioAccions = new ArrayList<RegistroDiarioAccion>();
			registroDiarioAccions.add(registroDiarioAccion1);
			registroDiarioAccions.add(registroDiarioAccion2);

			accionBursatil
					.setRegistrosDiariosAcciones((List<RegistroDiarioAccion>) registroDiarioAccions); /*-inverso de relacion relacionado */

			/*- >>>FIN - Relaciones<<<*/

			/*- >>>INICIO - Operacion/Persistencia<<<*/

			/*- por restriccion de llave foranea, orden persistencia : 
			 * Persistir inverso de relacion, Persistir propietario de relacion relacionado 
			 * (sino se produce error)
			 * NOTA:
			 * Si inverso de relacion relacionado o propietario de relacion relacionado tuviera cascade=ALL, se propaga 
			 * la "operacion" a la otra entidad en orden requerido
			 * @OneToMany(cascade = CascadeType.ALL..) (comunmente usado)
			 * @ManyToOne(cascade = CascadeType.ALL..)
			 */

			/*- InicioCaso1 - por restriccion de llave foranea, correcto (inverso puede o no tener cascade=ALL)*/
			 accionBursatilDAO.persist(accionBursatil);
			
			 registroDiarioAccionDAO.persist(registroDiarioAccion1);
			 variacionDiariaDAO.persist(variacionDiaria1_1);
			 variacionDiariaDAO.persist(variacionDiaria1_2);
			
			 registroDiarioAccionDAO.persist(registroDiarioAccion2);
			 variacionDiariaDAO.persist(variacionDiaria2_1);
			 variacionDiariaDAO.persist(variacionDiaria2_2);
			/*- FinCaso1*/

			
			/*- InicioCaso2 - por restriccion de llave foranea, correcto si inverso relacionado tuviera cascade=ALL*/
			accionBursatilDAO.persist(accionBursatil);
			/*- FinCaso2*/
			
			/*- >>>FIN - Operacion/Persistencia<<<*/

			/*- >>>INICIO - Recuperacion<<<*/
			em.flush();

			em.clear();

			AccionBursatil accionBursatilObtenido = accionBursatilDAO
					.findById(accionBursatil.getIdAccionBursatil());

			System.out.println(">>>accionBursatilObtenido:"
					+  AccionBursatilEH.toString(accionBursatilObtenido) );

			Collection<RegistroDiarioAccion> registroDiarioAccionsObtenidos = accionBursatilObtenido
					.getRegistrosDiariosAcciones();

			System.out.println(">>>registroDiarioAccionsObtenidos.getClass():"
					+ registroDiarioAccionsObtenidos.getClass());
			System.out.println(">>>registroDiarioAccionsObtenidos.size:"
					+ registroDiarioAccionsObtenidos.size());

			Iterator<RegistroDiarioAccion> it1 = registroDiarioAccionsObtenidos
					.iterator();
			RegistroDiarioAccion registroDiarioAccionTmp=null;
			VariacionDiaria variacionDiariaTmp=null;
			while (it1.hasNext()) {
				registroDiarioAccionTmp = it1.next();
				System.out.println(">>>registroDiarioAccionTmp:"
						+  RegistroDiarioAccionEH.toString(registroDiarioAccionTmp) );

				Collection<VariacionDiaria> variacionDiarias = registroDiarioAccionTmp
						.getVariacionesDiarias();

				System.out.println(">>>variacionDiarias.size:"
						+ variacionDiarias.size());

				Iterator<VariacionDiaria> it2 = variacionDiarias.iterator();

				while (it2.hasNext()) {
					variacionDiariaTmp = it2.next();
					System.out.println(">>>variacionDiariaTmp:"
							+ VariacionDiariaEH.toString(variacionDiariaTmp) );
				}

			}
			/*- >>>FIN - Recuperacion<<<*/
			
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
