package com.example.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("default")
public class PojoAction {

	public static Logger logger = Logger.getLogger(PojoAction.class.getName());	
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer edad;

	private String[] mensajesValidacion;
	
    @Action(value="Pojo",results={
    		@Result(name="resultado",location="/prueba_fin.jsp"),
    		@Result(name="error",location="/prueba_inicio.jsp")
    })	
    public String execute() {

    	logger.info("execute - entro");
    	
    	logger.info("edad:"+edad);
    	
    	validacion();
    	if( this.mensajesValidacion!= null){
        	logger.info("this.mensajesValidacion!= null");
    		return "error";
    	}
    	
        return "resultado";
    }

    
    public void validacion(){
    	ArrayList<String> mensajesValidacionTmp = new ArrayList<String>();
    	
    	if(nombre== null || nombre.length()<=0 ){
    		mensajesValidacionTmp.add( "Error en el nombre" );
    	}
    	if(apellidoPaterno== null || apellidoPaterno.length()<=0 ){
    		mensajesValidacionTmp.add( "Error en el apellidoPaterno" );
    	}
    	if(edad== null ){
    		mensajesValidacionTmp.add( "Error en el edad" );
    	}
    	
    	if(mensajesValidacionTmp.size()>0){
        	logger.info("mensajesValidacionTmp.size()>0");
    		
    		this.mensajesValidacion = mensajesValidacionTmp.toArray(new String[mensajesValidacionTmp.size()]);
    	}
    	
    }
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String[] getMensajesValidacion() {
		return mensajesValidacion;
	}

	public void setMensajesValidacion(String[] mensajesValidacion) {
		this.mensajesValidacion = mensajesValidacion;
	}

	
	
	
}
