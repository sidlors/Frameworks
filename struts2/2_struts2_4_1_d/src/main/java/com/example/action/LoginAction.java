package com.example.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.example.dto.UsuarioDTO;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
public class LoginAction extends ActionSupport implements RequestAware,
		SessionAware {

	public static Logger logger = Logger.getLogger(LoginAction.class.getName());

	private Map<String, Object> session;
	private Map<String, Object> request;

	private String username;
	private String password;

	@Action(value = "Login", results = {
			@Result(name = "SUCCESS", location = "/welcome.jsp"),
			@Result(name = "input", location = "/login.jsp") })
	public String execute() {

		logger.info("execute - entro");
		
		if (getUsername().equalsIgnoreCase("entrar")
				&& getPassword().equalsIgnoreCase("entrar")) {
			UsuarioDTO usuarioDTO = new UsuarioDTO("entrar", "entrar", "entrar");
			session.put("usuario", usuarioDTO);
			return "SUCCESS";
		} else {
			addActionError("Login/Password incorrectos");
			return "input";
		}

	}

	@SkipValidation
	@Action(value = "Logout", results = {
			@Result(name = "SUCCESS", location = "/welcome.jsp"),
			@Result(name = "input", location = "/login.jsp") })
	public String logout() {

		logger.info("logout - entro");		
		
		// Code fragment from class implementing SessionAware containing the
		// session map in a instance variable "session". Attempting to
		// invalidate
		// an already-invalid session will result in an IllegalStateException.
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			try {
				((org.apache.struts2.dispatcher.SessionMap) session)
						.invalidate();
			} catch (IllegalStateException e) {
				logger.error(e);
			}
		}
		return "input";

	}

	public void validate() {
		if (getUsername()== null || "".equals(getUsername().trim())) {
			addFieldError(getText("global.username"), getText("username.required"));
		}
		if (getPassword()== null || "".equals(getPassword().trim())) {
			addFieldError(getText("global.password"), getText("password.required"));
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}