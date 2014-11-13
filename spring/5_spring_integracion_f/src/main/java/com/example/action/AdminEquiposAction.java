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
import com.example.as.AdminEquiposAS;
import com.example.entity.Equipo;
import com.example.entity.helper.EquipoEH;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
public class AdminEquiposAction extends ActionSupport implements RequestAware,
		SessionAware {

	private AdminEquiposAS adminEquiposAS;
	/**
	 * El equipo a manipular. Esta clase es un entity. Struts2 puede instanciar
	 * automaticamente propiedades en expresiones OGNL profundas, mientras
	 * tengan un constructor sin-argumentos. Notamos que las cadenas recibidas
	 * por request son convertidas a expresiones OGNL. Ver 5.3.2 Mapping form
	 * field names to properties with OGNL expressions-struts2 Manning
	 */
	private Equipo equipo;
	private String fechaBaja;
	private String fechaFundacion;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private static Logger logger = Logger.getLogger(AdminEquiposAction.class
			.getName());

	@Action(value = "AdminEquiposAction_persist", results = { @Result(name = "result", location = "/output.jsp") })
	public String persist() {
		String data;
		try {
			logger.info("persist - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			equipo.setFechaBaja(DateHelper.convertidorString2DateConLocaleRoot(
					DateHelper.datePattern1, fechaBaja));
			equipo.setFechaFundacion(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaFundacion));
			logger.info("persist - equipo:" + EquipoEH.toString(equipo));
			this.adminEquiposAS.persist(equipo);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminEquiposAction_persist\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminEquiposAction_remove", results = { @Result(name = "result", location = "/output.jsp") })
	public String remove() {
		String data;
		try {
			logger.info("remove - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			equipo.setFechaBaja(DateHelper.convertidorString2DateConLocaleRoot(
					DateHelper.datePattern1, fechaBaja));
			equipo.setFechaFundacion(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaFundacion));
			logger.info("remove - equipo:" + EquipoEH.toString(equipo));
			this.adminEquiposAS.remove(equipo);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data", "{\"exception\":\"AdminEquiposAction_remove\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminEquiposAction_merge", results = { @Result(name = "result", location = "/output.jsp") })
	public String merge() {
		String data;
		try {
			logger.info("merge - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			equipo.setFechaBaja(DateHelper.convertidorString2DateConLocaleRoot(
					DateHelper.datePattern1, fechaBaja));
			equipo.setFechaFundacion(DateHelper
					.convertidorString2DateConLocaleRoot(
							DateHelper.datePattern1, fechaFundacion));
			logger.info("merge - equipo:" + EquipoEH.toString(equipo));
			this.adminEquiposAS.merge(equipo);
			request.put("data", "{\"success\":\"true\"}");
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data", "{\"exception\":\"AdminEquiposAction_merge\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminEquiposAction_findByIdEquipoSinJugadores", results = { @Result(name = "result", location = "/output.jsp") })
	public String findByIdEquipoSinJugadores() {
		String data;
		try {
			logger.info("findByIdEquipoSinJugadores - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			logger.info("findByIdEquipoSinJugadores - equipo.getIdEquipo():"
					+ equipo.getIdEquipo());
			Equipo equipoObtenido = this.adminEquiposAS
					.findByIdEquipoSinJugadores(equipo.getIdEquipo());
			if (equipoObtenido == null) {
				throw new Exception("el equipoObtenido es nulo");
			}
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1).create();
			String json = gson.toJson(equipoObtenido);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminEquiposAction_findByIdEquipoSinJugadores\"}");
		} finally {
			return "result";
		}
	}

	@Action(value = "AdminEquiposAction_findAllEquipoSinJugadores", results = { @Result(name = "result", location = "/output.jsp") })
	public String findAllEquipoSinJugadores() {
		String data;
		try {
			logger.info("findAllEquipoSinJugadores - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			List<Equipo> equipos = this.adminEquiposAS.findAllEquipoSinJugadores();
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1).create();
			String json = gson.toJson(equipos);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminEquiposAction_findAllEquipoSinJugadores\"}");
		} finally {
			return "result";
		}
	}

	
	@Action(value = "AdminEquiposAction_reporteDetalleEquipoSinJugadoresTxt", results = { @Result(name = "result", location = "/outputTxt.jsp") })
	public String reporteDetalleEquipoSinJugadoresTxt() {
		String data;
		try {
			logger.info("reporteDetalleEquipoTxt - entro");
			//AdminEquiposASImplJPA adminEquiposAS = new AdminEquiposASImplJPA();
			logger.info("reporteDetalleEquipoTxt - equipo.getIdEquipo():"
					+ equipo.getIdEquipo());
			Equipo equipoObtenido = this.adminEquiposAS
					.findByIdEquipoSinJugadores(equipo.getIdEquipo());
			if (equipoObtenido == null) {
				throw new Exception("el equipoObtenido es nulo");
			}
			Gson gson = new GsonBuilder()
					.setExclusionStrategies(
							new EquipoSinJugadoresExclusionStrategy())
					.setDateFormat(DateHelper.datePattern1)
					.setPrettyPrinting()
					.create();
			String json = gson.toJson(equipoObtenido);
			request.put("data", json);
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
			request.put("data",
					"{\"exception\":\"AdminEquiposAction_reporteDetalleEquipoSinJugadoresTxt\"}");
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public AdminEquiposAS getAdminEquiposAS() {
		return adminEquiposAS;
	}

	public void setAdminEquiposAS(AdminEquiposAS adminEquiposAS) {
		this.adminEquiposAS = adminEquiposAS;
	}

	
	
	
}