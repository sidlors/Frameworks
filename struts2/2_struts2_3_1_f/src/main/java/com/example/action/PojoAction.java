package com.example.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.example.dto.UsuarioDTO;

@ParentPackage("default")
public class PojoAction {

	public static Logger logger = Logger.getLogger(PojoAction.class.getName());

	private UsuarioDTO usuarioDTO;

	private String[] mensajesValidacion;

	@Action(value = "Pojo", results = {
			@Result(name = "resultado", location = "/prueba_fin.jsp"),
			@Result(name = "error", location = "/prueba_inicio.jsp") })
	public String execute() {

		logger.info("execute - entro");

		if (usuarioDTO != null) {
			logger.info("usuarioDTO.getEdad()" + usuarioDTO.getEdad());
		} else {
			logger.info("usuarioDTO es null");
		}

		validacion();
		if (this.mensajesValidacion != null) {
			logger.info("this.mensajesValidacion!= null");
			return "error";
		}

		return "resultado";
	}

	public void validacion() {
		ArrayList<String> mensajesValidacionTmp = new ArrayList<String>();

		if (usuarioDTO == null || usuarioDTO.getNombre() == null
				|| usuarioDTO.getNombre().trim().length() <= 0) {
			mensajesValidacionTmp.add("Error en el nombre");
		}
		if (usuarioDTO == null || usuarioDTO.getApellidoPaterno() == null
				|| usuarioDTO.getApellidoPaterno().trim().length() <= 0) {
			mensajesValidacionTmp.add("Error en el apellidoPaterno");
		}
		if (usuarioDTO == null || usuarioDTO.getEdad() == null) {
			mensajesValidacionTmp.add("Error en el edad");
		}

		if (mensajesValidacionTmp.size() > 0) {
			logger.info("mensajesValidacionTmp.size()>0");

			this.mensajesValidacion = mensajesValidacionTmp
					.toArray(new String[mensajesValidacionTmp.size()]);
		}

	}

	public String[] getMensajesValidacion() {
		return mensajesValidacion;
	}

	public void setMensajesValidacion(String[] mensajesValidacion) {
		this.mensajesValidacion = mensajesValidacion;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
