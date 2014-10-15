<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="d" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tags y OGNL</title>
</head>
<body>

Nombre: <d:property value="usuarioDTO.nombre" /><br/>
Apellido Paterno: <d:property value="usuarioDTO.apellidoPaterno" /><br/>
Apellido Materno: <d:property value="usuarioDTO.apellidoMaterno" /><br/>
Edad: <d:property value="usuarioDTO.edad" /><br/>
<a href="prueba_inicio.jsp">Regresar a inicio..</a>
</body>
</html>