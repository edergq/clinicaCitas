<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.joedayz.acweb.domain.*" %>
<%@page import="org.joedayz.acweb.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="conteiner">
	<!--cabecera-->
    <div id="top">
    	
    	<jsp:include page="/cabecera.jsp" />
    </div>   
 </div>
 
   <div id="middle">
   	<div id="menu">
    		<jsp:include page="/menu.jsp" />
   	</div>
   
      <form>  
     <div align="center">
     
   <div align="left"><input type="button" name="Agregrar" value="Agregrar"  style="width:100px; margin-left: 45px"  onclick="location.href='<c:url value="ServletCitas"/>'"/></div>
    <table id="Table1" class="full" align="center" width="90%">
 	 <tr>
        <th>Cita</th>
        <th>Paciente</th>
       	<th>Fecha / Hora</th>
       	<th>doctor</th>
        <th>especialidad</th>
        <th>Comentario</th>
    
        <th>Modificar</th>
        <th>Eliminar</th>
 	 </tr>
          
	<c:forEach items="${citas}" var="citas" varStatus="contador" >
	<c:choose>
	<c:when test="${not empty citas.co_cita}">
	<tr>
	<td align="center"><c:out value="${citas.co_cita}"></c:out></td>
	
	<td align="center"><c:out value="${citas.usuario.nombres}"></c:out>  <c:out value="${citas.usuario.apellidos}"></c:out>  </td>
	
	<td align="center"><c:out value="${citas.fecha}"></c:out> / <c:out value="${citas.horario}"></c:out></td>
	
	<td align="center"><c:out value="${citas.medico.deMedico}"></c:out></td>
	
	<td align="center"><c:out value="${citas.especialidad.deEspecialidad}"></c:out></td>
	<td align="center"><c:out value="${citas.comentario}"></c:out></td>
	
	
	<td align="center"><a href="#modificar" title="Modificar"><img src="images/iconos/modificar.png"/></a></td>
	<td align="center"><a href="#eliminar" title="Eliminar"><img src="images/iconos/eliminar.png"/></a></td>
	</tr>
	</c:when>
	<c:otherwise>
	<tr >
	<td colspan="6">No hay datos</td>
	</tr>
	</c:otherwise>
	</c:choose>
	
	</c:forEach> 
 </table>
    

    </div>  
   
      </form> 
   
   </div>
   
   
     <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>
 


</body>
</html>