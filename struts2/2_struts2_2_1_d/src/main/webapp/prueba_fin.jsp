<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="d"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parametros</title>
</head>
<body>

	<%
		/*- Obtenemos el ActionContext que es un ThreadLocal-*/	
		ActionContext actionContext = ActionContext.getContext();
		/*- Asignamos el actionContext a pageContext para usarlo en EL-*/
		pageContext.setAttribute("actionContext", actionContext);
	%>


Nombre: ${actionContext.getValueStack().findValue("nombre")}<br/>
Apellido Paterno: ${actionContext.getValueStack().findValue("apellidoPaterno")}<br/>
Apellido Materno: ${actionContext.getValueStack().findValue("apellidoMaterno")}<br/>
Edad: ${actionContext.getValueStack().findValue("edad")}<br/>
<a href="prueba_inicio.jsp">Regresar a inicio..</a>
</body>
</html>