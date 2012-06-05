<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.joedayz.acweb.domain.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); 
	String url=getServletContext().getContextPath(); 
%>

</head>
<body>
	<div id="menu">
    		<ul>
            	<li><a href="<%=url%>/ServletCitas?f_registrar=R">Citas</a></li>
            	
            	
            	
            	
            	<%if(usuario.getDeRol().equals("ADMIN")){%>
            	<li><a href="<%=url%>/ServletUsuario?list=lista">Administraci&oacute;n</a></li>
            	<%}%>
            	
            	
            </ul>
   	</div>
</body>
</html>