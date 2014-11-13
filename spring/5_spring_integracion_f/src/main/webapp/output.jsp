<%
response.setContentType("application/json");
out.print(request.getAttribute("data"));
%>