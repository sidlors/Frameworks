package com.example.as;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EquiposDAO;
import com.example.entity.Equipo;

public class AdminEquiposASImplJPA implements AdminEquiposAS{

	private static Logger logger = Logger.getLogger(AdminEquiposASImplJPA.class.getName());
	
	private EquiposDAO equiposDAO;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override	
	public void persist(Equipo equipo) throws Exception {
		try {
			logger.info("persist - entro");

			this.equiposDAO.persist(equipo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override	
	public void remove(Equipo equipo) throws Exception {
		try {
			logger.info("remove - entro");			
		
			Equipo equipoObtenido=this.equiposDAO.findById(equipo.getIdEquipo());
			if(equipoObtenido==null){
				throw new PersistenceException("equipo a ser removido no existe");
			}
			this.equiposDAO.remove(equipoObtenido);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override		
	public void merge(Equipo equipo) throws Exception {
		try {
			logger.info("merge - entro");

			this.equiposDAO.merge(equipo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}
		

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override		
	public Equipo findByIdEquipoSinJugadores(int id) throws Exception {
		try {
			logger.info("findByIdEquipoSinJugadores - entro");

			Equipo equipo = this.equiposDAO.findById(id);
			
			return equipo;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}

	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override		
	public List<Equipo> findAllEquipoSinJugadores() throws Exception {
		try {
			logger.info("findAllEquipoSinJugadores - entro");			

			List<Equipo> equipos = this.equiposDAO.findAll();
			
			return equipos;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void test1(Equipo equipo,Equipo equipo2) throws Exception {
		try {
			logger.info("test1 - entro");			

			logger.info("test1 - persist equipo#1");
			this.equiposDAO.persist(equipo);
			logger.info("test1 - persist equipo#2");
			this.equiposDAO.persist(equipo2);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}
	
	
	public EquiposDAO getEquiposDAO() {
		return equiposDAO;
	}

	public void setEquiposDAO(EquiposDAO equiposDAO) {
		this.equiposDAO = equiposDAO;
	}


	public static void main(String[] args) throws Exception{

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		AdminEquiposASImplJPA adminEquiposASImplJPA = 
				(AdminEquiposASImplJPA) context.getBean("adminEquiposAS");
				
		Equipo equipo = new Equipo();
		equipo.setNombre("n1");
		equipo.setApodo("apodon1");

		Equipo equipo2 = new Equipo();
		equipo2.setNombre("n2");
		equipo2.setApodo("apodon2");
		
		adminEquiposASImplJPA.test1(equipo, equipo2);
		
	}
	
}
