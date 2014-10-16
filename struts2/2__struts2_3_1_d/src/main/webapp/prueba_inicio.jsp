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

	<br>
	<br>
	<br> <strong>Forma1</strong>
	<s:form action="Pojo">
		<s:textfield name="usuarioDTO.nombre" label="*Nombre" />
		<s:textfield name="usuarioDTO.apellidoPaterno"
			label="*Apellido Paterno" />
		<s:textfield name="usuarioDTO.apellidoMaterno"
			label="Apellido Materno" />
		<s:textfield name="usuarioDTO.edad" label="*Edad" />
		<s:submit value="Enviar" align="left" />
	</s:form>

	<br>
	<br>
	<br> <strong>Forma2</strong>
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
				<td colspan="2"><input type="submit" value="Enviar" /></td>
			<tr>
		</table>
	</form>


	<p>
		<br><strong>Prueba de Variables en ActionContext</strong>
		 
		<br>
		 
		<br>(OGNL en ActionContext->ValueStack) usuarioDTO.nombre:
		<s:property value="usuarioDTO.nombre" />
		<br>(OGNL en ActionContext) #usuarioDTO.nombre:
		<s:property value="#usuarioDTO.nombre" />
		<br>
		
		<br> <br>Definicion de Variable technologyName
		<s:set name="technologyName" value="%{'Java'}" scope="action" />
		<!-- Notamos que s:set con scope="action" almacena los valores en action context y en  request.-->
		<!-- Probar tambien con scope="request" -->


		<br />if test #technologyName=='Java':
		<s:if test="#technologyName=='Java'">
			<br />(ActionContext) <s:property value="#technologyName" />
		</s:if>
		<s:else>
			<br />(No en ActionContext)
		</s:else>

		<br>if test technologyName=='Java':
		<s:if test="technologyName=='Java'">
			<br />(ActionContext->ValueStack) <s:property value="technologyName" />
		</s:if>
		<s:else>
			<br />(No en ActionContext->ValueStack)
		</s:else>

		<br>if test #request.technologyName=='Java':
		<s:if test="#request.technologyName=='Java'">
		<br />(ActionContext->Request) <s:property
			value="#request.technologyName" />
		</s:if>
		<s:else>
			<br />(No en ActionContext->Request)
		</s:else>

	</p>

	<s:debug></s:debug>
	
</body>
</html>