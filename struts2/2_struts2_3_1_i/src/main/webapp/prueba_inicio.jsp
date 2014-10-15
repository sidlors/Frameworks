<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tags y OGNL</title>
</head>
<body>

	<s:if test="%{mensajesValidacion!=null}">
		Error:
		<ul>
			<s:iterator value="%{mensajesValidacion}" var="mensaje">
				<li><s:property /></li>
			</s:iterator>
		</ul>
	</s:if>

	<br><br><br>
	Forma1
	<s:form action="Pojo" >
		<s:textfield name="usuarioDTO.nombre" label="*Nombre" />
		<s:textfield name="usuarioDTO.apellidoPaterno"
			label="*Apellido Paterno" />
		<s:textfield name="usuarioDTO.apellidoMaterno"
			label="Apellido Materno" />
		<s:textfield name="usuarioDTO.edad" label="*Edad" />
		<s:submit value="Enviar" align="left"/>
	</s:form>

	<br><br><br>
	Forma2
	<form action="<s:url action="Pojo"/>" method="post">
		<table>
			<tr>
				<td>*Nombre:</td>
				<td><input type="text" name="usuarioDTO.nombre"
					value='<s:property value="usuarioDTO.nombre" />' /></td>
			</tr>
			<tr>
				<td>*Apellido Paterno:</td>
				<td><input type="text" name="usuarioDTO.apellidoPaterno"
					value='<s:property value="usuarioDTO.apellidoPaterno" />' /></td>
			</tr>
			<tr>
				<td>Apellido Materno:</td>
				<td><input type="text" name="usuarioDTO.apellidoMaterno"
					value='<s:property value="usuarioDTO.apellidoMaterno" />' /></td>
			</tr>
			<tr>
				<td>*Edad:</td>
				<td><input type="text" name="usuarioDTO.edad"
					value='<s:property value="usuarioDTO.edad" />' /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enviar"/></td>
			<tr>
		</table>
	</form>


	<br><br><br>
	Prueba de variables en ActionContext
	<br>
	technologyName:
	<s:set name="technologyName" value="%{'Java en Action'}" scope="action" />
	<!--<s:set name="technologyName"  value="%{'Java en Request'}" scope="request"/>-->

	<s:if test="#technologyName=='Java en Action'">
		<div>
			<s:property value="technologyName" />
		</div>
	</s:if>
	<s:elseif test="#request.technologyName=='Java en Request'">
		<div>
			<s:property value="#request.technologyName" />
		</div>
	</s:elseif>
	<s:else>
		<div>NO Java</div>
	</s:else>


</body>
</html>