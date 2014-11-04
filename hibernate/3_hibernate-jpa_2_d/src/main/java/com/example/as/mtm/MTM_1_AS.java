package com.example.as.mtm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.example.dao.AccionBursatilDAO;
import com.example.dao.CategoriaDAO;
import com.example.entity.AccionBursatil;
import com.example.entity.Categoria;
import com.example.entity.helper.AccionBursatilEH;
import com.example.entity.helper.CategoriaEH;
import com.example.util.JPAUtil;

public class MTM_1_AS {

	public void m1() throws Exception {
		EntityManager em = null;
		try {
			em = JPAUtil.getEMF1().createEntityManager();

			em.getTransaction().begin();

			AccionBursatilDAO accionBursatilDAO = new AccionBursatilDAO();
			accionBursatilDAO.setEntityManager(em);

			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.setEntityManager(em);

			/*- >>>INICIO - Declaraciones<<<*/

			AccionBursatil accionBursatil_AlimentoPerros = new AccionBursatil();
			accionBursatil_AlimentoPerros.setCodigoAccion(UUID.randomUUID()
					.toString().substring(0, 15));
			accionBursatil_AlimentoPerros
					.setNombreAccion("Alimento para perros");

			AccionBursatil accionBursatil_AlimentoGatos = new AccionBursatil();
			accionBursatil_AlimentoGatos.setCodigoAccion(UUID.randomUUID()
					.toString().substring(0, 15));
			accionBursatil_AlimentoGatos.setNombreAccion("Alimento para gatos");

			Categoria categoria_Alimentos = new Categoria();
			categoria_Alimentos.setNombre("Alimentos");
			categoria_Alimentos
					.setDescripcion("Todo tipo de accion relacionada con alimentos");

			Categoria categoria_Caninos = new Categoria();
			categoria_Caninos.setNombre("Caninos");
			categoria_Caninos
					.setDescripcion("Todo tipo de accion relacionada con perros");

			/*- >>>FIN - Declaraciones<<<*/

			/*- >>>INICIO - Relaciones<<<*/

			Collection<AccionBursatil> accionBursatils_AlimentosPerros_AlimentosGatos = new ArrayList<AccionBursatil>();
			accionBursatils_AlimentosPerros_AlimentosGatos
					.add(accionBursatil_AlimentoPerros);
			accionBursatils_AlimentosPerros_AlimentosGatos
					.add(accionBursatil_AlimentoGatos);

			Collection<AccionBursatil> accionBursatils_AlimentoPerros = new ArrayList<AccionBursatil>();
			accionBursatils_AlimentoPerros.add(accionBursatil_AlimentoPerros);

			Collection<Categoria> categorias_Alimentos_Caninos = new ArrayList<Categoria>();
			categorias_Alimentos_Caninos.add(categoria_Alimentos);
			categorias_Alimentos_Caninos.add(categoria_Caninos);

			Collection<Categoria> categoriaEntitys_Alimentos = new ArrayList<Categoria>();
			categoriaEntitys_Alimentos.add(categoria_Alimentos);

			accionBursatil_AlimentoPerros
					.setCategorias((List<Categoria>) categorias_Alimentos_Caninos); 
			/*-inverso de relacion relacionado */
			
			accionBursatil_AlimentoGatos
					.setCategorias((List<Categoria>) categoriaEntitys_Alimentos); 
			/*-inverso de relacion relacionado */
			
			categoria_Alimentos
					.setAccionesBursatiles((List<AccionBursatil>) accionBursatils_AlimentosPerros_AlimentosGatos); 
			/*-propietario de relacion relacionado */
			
			categoria_Caninos
					.setAccionesBursatiles((List<AccionBursatil>) accionBursatils_AlimentoPerros); 
			/*-propietario de relacion relacionado */

			/*- >>>FIN - Relaciones<<<*/

			/*- >>>INICIO - Operacion/Persistencia<<<*/

			/*- por restriccion de llave foranea, orden persistencia : 
			 * No hay. Solo hay que tener a propietario de relacion relacionado 
			 * (sino no se almacena relacion, pero no hay error porque el query de tabla intermedia se hace 
			 * al final)
			 * NOTA:
			 * Si inverso de relacion relacionado o propietario de relacion relacionado tuviera cascade=ALL, 
			 * se propaga la "operacion" a la otra entidad 
			 * @ManyToMany(cascade = CascadeType.ALL..) 
			 */

			/*- InicioCaso1 - por restriccion de llave foranea, correcto (default)*/
			accionBursatilDAO.persist(accionBursatil_AlimentoPerros);
			accionBursatilDAO.persist(accionBursatil_AlimentoGatos);
			// Thread.sleep(1000*30);//Ver queries
			categoriaDAO.persist(categoria_Alimentos);
			categoriaDAO.persist(categoria_Caninos);
			/*- FinCaso1*/

			/*- InicioCaso2 - por restriccion de llave foranea, correcto*/
			 categoriaDAO.persist(categoria_Alimentos);
			 categoriaDAO.persist(categoria_Caninos);
			 Thread.sleep(1000*30);//Ver queries
			 accionBursatilDAO.persist(accionBursatil_AlimentoPerros);
			 accionBursatilDAO.persist(accionBursatil_AlimentoGatos);
			/*- FinCaso2*/

			/*- >>>FIN - Operacion/Persistencia<<<*/

			/*- >>>INICIO - Recuperacion<<<*/

			em.flush();

			em.clear();

			AccionBursatil accionBursatilObtenido = accionBursatilDAO
					.findById(accionBursatil_AlimentoPerros
							.getIdAccionBursatil());

			System.out.println(">>>accionBursatilObtenido:"
					+ AccionBursatilEH.toString(accionBursatilObtenido));

			Collection<Categoria> categoriaEntitysObtenidos = accionBursatilObtenido
					.getCategorias();

			System.out.println(">>>categoriaObtenidos.size:"
					+ categoriaEntitysObtenidos.size());

			Iterator<Categoria> it1 = categoriaEntitysObtenidos.iterator();
			Categoria categoriaEntityTmp;
			while (it1.hasNext()) {
				categoriaEntityTmp = it1.next();
				System.out.println(">>>categoriaTmp:" +  CategoriaEH.toString( categoriaEntityTmp) );

				Iterator<AccionBursatil> it2 = categoriaEntityTmp
						.getAccionesBursatiles().iterator();
				AccionBursatil accionBursatilEntityTmp;
				while (it2.hasNext()) {
					accionBursatilEntityTmp = it2.next();
					System.out.println(">>>accionBursatilTmp:"
							+  AccionBursatilEH.toString(accionBursatilEntityTmp) );
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
