<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zero</title>
</head>
<body>

	<%
		/*- Obtenemos el ActionContext que es un ThreadLocal-*/	
		ActionContext actionContext = ActionContext.getContext();
		/*- Asignamos el actionContext a pageContext para usarlo en EL-*/
		pageContext.setAttribute("actionContext", actionContext);
	%>
	<c:if
		test="${actionContext.getValueStack().findValue('mensajesValidacion')!=null}">
			Error:
	<ul>
			<c:forEach
				items="${actionContext.getValueStack().findValue('mensajesValidacion')}"
				var="mensaje">
				<li>${mensaje}</li>
			</c:forEach>
		</ul>
	</c:if>
 
	<form action="<c:url value='Pojo.action'/>" method="post">
		<table>
			<tr>
				<td>*Nombre:</td>
				<td><input type="text" name="nombre"
					value='${actionContext.getValueStack().findValue("nombre")}' /></td>
			</tr>
			<tr>
				<td>*Apellido Paterno:</td>
				<td><input type="text" name="apellidoPaterno"
					value='${actionContext.getValueStack().findValue("apellidoPaterno")}' /></td>
			</tr>
			<tr>
				<td>Apellido Materno:</td>
				<td><input type="text" name="apellidoMaterno"
					value='${actionContext.getValueStack().findValue("apellidoMaterno")}' /></td>
			</tr>
			<tr>
				<td>*Edad:</td>
				<td><input type="text" name="edad"
					value='${actionContext.getValueStack().findValue("edad")}' /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			<tr>
		</table>
	</form>

</body>
</html>