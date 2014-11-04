package com.example.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Nota: LocaleAction no necesita heredar de ActionSupport porque no usa
 * la Internalizacion/Localizacion dentro de la clase. (se usa en la vista)
 * @author usuario1
 *
 */
@ParentPackage("default")
public class LocaleAction{

	
	public static Logger logger = Logger.getLogger(LocaleAction.class.getName());

	@Action(value = "Locale", results = {
			@Result(name = "SUCCESS", location = "/login.jsp") })
	public String execute() {
		
		logger.info("execute - entro");

		return "SUCCESS";

	}

}