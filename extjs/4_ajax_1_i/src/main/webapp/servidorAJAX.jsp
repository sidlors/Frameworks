<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%
    
  if(request.getParameter("valor1")!=null && request.getParameter("valor1").trim().length()>0){
	  System.out.println(this.getClass().getName()+" - El valor1 es:"+request.getParameter("valor1") );
  } else{
	  System.out.println(this.getClass().getName()+" - El valor1 no fue definido" );
  }
  out.println("entro en servidorAJAX.jsp");  
    
%>