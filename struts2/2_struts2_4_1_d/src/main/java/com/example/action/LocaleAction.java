package com.example.action;

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

	@Action(value = "Locale", results = {
			@Result(name = "SUCCESS", location = "/login.jsp") })
	public String execute() {
	
		return "SUCCESS";

	}

}