package com.example.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.example.action.LoginAction;

/**
 * Servlet Filter implementation class FilterValidadorSesion
 */
// @WebFilter(urlPatterns = {"*"})
public class FilterValidadorSesion implements Filter {

	public static Logger logger = Logger.getLogger(FilterValidadorSesion.class
			.getName());

	/**
	 * Default constructor.
	 */
	public FilterValidadorSesion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		logger.info("doFilter - entro");

		boolean esServletPathLogin = false;
		
		logger.info("getServletPath:"+((HttpServletRequest)request).getServletPath() );
		if (((HttpServletRequest) request).getServletPath().equalsIgnoreCase(
				"/login.jsp")) {
			esServletPathLogin = true;
		}
		if (((HttpServletRequest) request).getServletPath().equalsIgnoreCase(
				"/Login.action")) {
			esServletPathLogin = true;
		}
		if (((HttpServletRequest) request).getServletPath().equalsIgnoreCase(
				"/index.html")) {
			esServletPathLogin = true;
		}

		/*- 
		 * Podria proteger acceso directo a jsps creando otra variable que indicara si se 
		 * quiere acceder a un jsp protegido en directo y redireccionar a login.jsp.
		 * NOTA: Con esto no podria navegar a jsps sino que siempre tendria que acceder por
		 * una configuracion de action.
		 * Ejm: 
		 * boolean esServletPathProtectedJSP = false;
		 * if (!url.equalsIgnoreCase("login.jsp") && url.toLowerCase().contains(".jsp")){
		 * 	esServletPathProtectedJSP = true;
		 * }
		 * ...
		 * if (esServletPathLogin || ( esSesionValida && !esServletPathProtectedJSP)) {
		 */

		boolean esSesionValida = false;
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("usuario") != null) {
			esSesionValida = true;
		}

		if ( esServletPathLogin || esSesionValida) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("login.jsp");
			return;
		}

		// pass the request along the filter chain
		// chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
