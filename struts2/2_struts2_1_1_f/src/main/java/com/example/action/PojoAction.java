package com.example.action;

import org.apache.log4j.Logger;

public class PojoAction {

	public static Logger logger = Logger.getLogger(PojoAction.class.getName());
	
	private String mensaje;
	
    public String execute() {
    	logger.info("execute - entro");
    	this.mensaje = "Hola querido y odiado DF!!";
        return "resultado";
    }

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

    
}
