package com.example.as;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.example.dao.AccionBursatilDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.helper.AccionBursatilEH;
import com.example.util.JPAUtil;

public class AccionBursatilAS {

	public void m1() throws Exception {
		EntityManager em = null;
		try {

			
			//si el em es manejado por el contenedor esto no seria necesario
			// yo administro la vida del em
			em = JPAUtil.getEMF1().createEntityManager();

			// Si el em fuera manejado por por el contenedor y las transacciones 
			//son de tipo no extendido (Transaccional) 

			em = JPAUtil.getEMF1().createEntityManager();


			em.getTransaction().begin();

			AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
			accionBursatilDAO.setEntityManager(em);

			AccionBursatil accionBursatil = new AccionBursatil();
			accionBursatil.setCodigoAccion(UUID.randomUUID().toString()
					.substring(0, 15));
			accionBursatil.setNombreAccion("Alimento para gatos");
			System.out.println(">>>accionBursatil:" + AccionBursatilEH.toString(accionBursatil) );
			accionBursatilDAO.persist(accionBursatil);
			// int i= 1/0; //error

			AccionBursatil accionBursatil2 = new AccionBursatil();
			accionBursatil2.setCodigoAccion(UUID.randomUUID().toString()
					.substring(0, 15));
			accionBursatil2.setNombreAccion("Alimento para perros");
			System.out
					.println(">>>accionBursatil2:" +  AccionBursatilEH.toString(accionBursatil2) );
			accionBursatilDAO.persist(accionBursatil2);

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
