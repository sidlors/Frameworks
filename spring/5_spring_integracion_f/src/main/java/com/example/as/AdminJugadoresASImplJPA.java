package com.example.as;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.action.AdminEquiposAction;
import com.example.dao.JugadoresDAO;
import com.example.entity.Jugador;

public class AdminJugadoresASImplJPA implements AdminJugadoresAS{

	private static Logger logger = Logger.getLogger(AdminJugadoresASImplJPA.class.getName());
	
	private JugadoresDAO jugadoresDAO;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void persist(Jugador jugador) throws Exception {
		try {
			logger.info("persist - entro");

			this.jugadoresDAO.persist(jugador);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override	
	public void remove(Jugador jugador) throws Exception {
		try {
			logger.info("remove - entro");			

			Jugador jugadorObtenido=this.jugadoresDAO.findById(jugador.getIdJugador());
			if(jugadorObtenido==null){
				throw new PersistenceException("jugador a ser removido no existe");
			}
			jugadoresDAO.remove(jugadorObtenido);


		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override		
	public void merge(Jugador jugador) throws Exception {
		try {
			logger.info("merge - entro");

			this.jugadoresDAO.merge(jugador);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}
		
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override		
	public Jugador findByIdJugadores(int id) throws Exception {
		try {
			logger.info("findByIdJugadores - entro");

			Jugador jugador = this.jugadoresDAO.findById(id);
			
			return jugador;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override			
	public List<Jugador> findAllJugadores() throws Exception {
		try {
			logger.info("findAllJugadores - entro");			

			List<Jugador> jugadors = this.jugadoresDAO.findAll();
			
			return jugadors;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);


			throw e;
		}
	}

	public JugadoresDAO getJugadoresDAO() {
		return jugadoresDAO;
	}

	public void setJugadoresDAO(JugadoresDAO jugadoresDAO) {
		this.jugadoresDAO = jugadoresDAO;
	}


	
}
