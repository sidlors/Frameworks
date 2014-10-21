<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Internalizacion y Mensajes</title>
</head>

<body>
<h1>Internalizacion y Mensajes</h1>

<s:form action="Login" >
	<s:textfield key="global.username" name="username" />
	<s:password key="global.password" name="password"/>	
	<s:submit key="global.submit" name="submit" />
</s:form>

<s:url id="localeES" action="Locale" >
   <s:param name="request_locale" >es</s:param>
</s:url>
<s:url id="localeEN" action="Locale" >
   <s:param name="request_locale" >en</s:param>
</s:url>
<s:url id="localeDE" action="Locale" >
   <s:param name="request_locale" >de</s:param>
</s:url>
<s:url id="localeFR" action="Locale" >
   <s:param name="request_locale" >fr</s:param>
</s:url>

<s:a href="%{localeES}" >Español</s:a>
<s:a href="%{localeEN}" >English</s:a>
<s:a href="%{localeDE}" >German</s:a>
<s:a href="%{localeFR}" >France</s:a>
 
</body>
</html>