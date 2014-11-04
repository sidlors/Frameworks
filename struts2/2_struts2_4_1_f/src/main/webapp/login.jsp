<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Internalizacion y Mensajes</title>
</head>

<body>
	<h1>Internalizacion y Mensajes</h1>

	<s:if test="hasActionErrors()||hasFieldErrors()">
		Error:
		<ul>
			<s:iterator value="actionErrors" var="actionError">
					<li><s:property /></li>
			</s:iterator>
		
			<s:iterator value="fieldErrors" var="fieldError">
				<s:iterator value="value"
					var="fieldErrorValueCollectionElement">
					<li><s:property /></li>
				</s:iterator>
			</s:iterator>			
		</ul>
	</s:if>


	<form action="<s:url action="Login"/>" method="post">
		<table>
			<tr>
				<td><s:text name="global.username" /></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><s:text name="global.password" /></td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="<s:text name="global.submit" /> " /></td>
			</tr>

		</table>
	</form>


	<s:url id="localeES" action="Locale">
		<s:param name="request_locale">es</s:param>
	</s:url>
	<s:url id="localeEN" action="Locale">
		<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url id="localeDE" action="Locale">
		<s:param name="request_locale">de</s:param>
	</s:url>

	<s:a href="%{localeES}">Español</s:a>
	<s:a href="%{localeEN}">English</s:a>
	<s:a href="%{localeDE}">German</s:a>

</body>
</html>