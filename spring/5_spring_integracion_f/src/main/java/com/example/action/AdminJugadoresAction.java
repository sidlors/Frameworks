package com.example.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.example.action.helper.DateHelper;
import com.example.action.helper.EquipoSinJugadoresExclusionStrategy;
import com.example.as.AdminJugadoresAS;
import com.example.entity.Jugador;
import com.example.entity.helper.JugadorEH;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
public class AdminJugadoresAction extends ActionSupport implements
		RequestAware, SessionAware {

	private AdminJugadoresAS adminJugadoresAS;
	/**
	 * El jugador a manipular. Esta clase es un entity. Struts2 puede instanciar
	 * automaticamente propiedades en expresiones OGNL profundas, mientras
	 * tengan un constructor sin-argumentos. Notamos que las cadenas recibidas
	 * por request son convertidas a expresiones OGNL. Ver 5.3.2 Mapping form
	 * field names to properties with OGNL expressions-struts2 Manning
	 */
	private Jugador jugador;
	private String fechaNacimiento;

	private Map<String, Object> session;
	private Map<String, Object> request;
	private static Logger logger = Logger.getLogger(AdminJugadoresAction.class
			.getName());

	@Action(value = "AdminJugadoresAction_persist", results = { @Result(name = "result", location = "/output.jsp") })
	public String persist() {
		String data;
		try {
			logger.info("persist - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			jugador.setFechaNacimiento(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaNacimiento));
			logger.info("persist - jugador:" + JugadorEH.toString(jugador));
			this.adminJugadoresAS.persist(jugador);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_persist\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminJugadoresAction_remove", results = { @Result(name = "result", location = "/output.jsp") })
	public String remove() {
		String data;
		try {
			logger.info("remove - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			jugador.setFechaNacimiento(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaNacimiento));
			logger.info("remove - jugador:" + JugadorEH.toString(jugador));
			this.adminJugadoresAS.remove(jugador);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_remove\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminJugadoresAction_merge", results = { @Result(name = "result", location = "/output.jsp") })
	public String merge() {
		String data;
		try {
			logger.info("merge - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			jugador.setFechaNacimiento(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaNacimiento));
			logger.info("merge - equipo:" + JugadorEH.toString(jugador));
			this.adminJugadoresAS.merge(jugador);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_merge\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminJugadoresAction_findByIdJugador", results = { @Result(name = "result", location = "/output.jsp") })
	public String findByIdJugador() {
		String data;
		try {
			logger.info("findByIdJugador - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			logger.info("findByIdJugador - jugador.getIdJugador():"
					+ jugador.getIdJugador());
			Jugador jugadorObtenido = this.adminJugadoresAS
					.findByIdJugadores(jugador.getIdJugador());
			if (jugadorObtenido == null) {
				throw new Exception("el jugadorObtenido es nulo");
			}
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1).create();
			String json = gson.toJson(jugadorObtenido);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_findByIdJugador\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminJugadoresAction_findAllJugadores", results = { @Result(name = "result", location = "/output.jsp") })
	public String findAllJugadores() {
		String data;
		try {
			logger.info("findAllJugadores - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			List<Jugador> jugadors = this.adminJugadoresAS.findAllJugadores();
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1).create();
			String json = gson.toJson(jugadors);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_findAllJugadores\"}");
		} finally {
			return "result";
		}
	}

	
	@Action(value = "AdminJugadoresAction_reporteDetalleJugadorTxt", results = { @Result(name = "result", location = "/outputTxt.jsp") })
	public String reporteDetalleJugadorTxt() {
		String data;
		try {
			logger.info("reporteDetalleJugadorTxt - entro");
			//AdminJugadoresASImplJPA adminJugadoresAS = new AdminJugadoresASImplJPA();
			logger.info("reporteDetalleJugadorTxt - jugador.getIdJugador():"
					+ jugador.getIdJugador());
			Jugador jugadorObtenido = this.adminJugadoresAS
					.findByIdJugadores(jugador.getIdJugador());
			if (jugadorObtenido == null) {
				throw new Exception("el jugadorObtenido es nulo");
			}
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1)
					.setPrettyPrinting()
					.create();
			String json = gson.toJson(jugadorObtenido);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminJugadoresAction_reporteDetalleJugadorTxt\"}");
		} finally {
			return "result";
		}
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public AdminJugadoresAS getAdminJugadoresAS() {
		return adminJugadoresAS;
	}

	public void setAdminJugadoresAS(AdminJugadoresAS adminJugadoresAS) {
		this.adminJugadoresAS = adminJugadoresAS;
	}

	
	
	
	
}