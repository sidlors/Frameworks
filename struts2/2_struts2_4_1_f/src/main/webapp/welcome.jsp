<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Internalizacion y Mensajes</title>
</head>


<body>
<h1>Internalizacion y Mensajes</h1>

<h4>
Username: <s:property value="username"/>
</h4>

<a href="<s:url value="/Logout.action"/>" >Logout</a>
</html>