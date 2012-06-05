<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="select" uri="/WEB-INF/tag/tagLib.tld" %>
<%@page import="org.joedayz.acweb.domain.*"%>
<html>



<%
   BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); 
   
   String idEsp=(String)request.getAttribute("idEspecialidad"); 
   String idMedico=(String)request.getAttribute("idMedico");
   Long idUser=usuario.getCoUser();
   
%>






<body>
<div id="conteiner">
	<!--cabecera-->
    <div id="top">
    	<jsp:include page="/cabecera.jsp" />
    	</div>   
 	</div>
    <!--middle-->
  <div id="middle">
  
	<div id="menu">
	
    		<jsp:include page="/menu.jsp" />
   	</div>
     
	<div  style="border-color:blue;border: 1px; width:800px;">
	<form id="formulario" action="ServletCitas" method="post">
	
	<table width="80%" border="0"  style="margin-left: auto">
	<tr>
	<th colspan="2"><h2 class="titleForm">Formulario de Registro de Citas</h2>
	</th>
	</tr>
	

		
	<c:choose>
  		<c:when test="${modo == null}"  >
	  

		<tr>
		<td><label class="labels">Especialidad</label></td>
		<td><select name="f_co_especialidad">
		<select:ComboEspecialidad/>
		</select>
		</td>
		</tr>		
			<input type="hidden"  name ="f_modo" value="M"/>

  		</c:when>
  
 		<c:when test="${modo == 'M'}"  >
 		<tr>
		<td><label class="labels">Especialidad</label>	</td>
 		<td class="labels" align="left"><c:out value="${especialidad.deEspecialidad}"></c:out></td>
 		</tr>
 		
 		<tr>
 				
 			<td><label class="labels">Medico</label>	</td>	
			<td>
			
				<select:ComboMedicoPorId idEspecialidad="<%=idEsp%>" />
				
			<input type="hidden"  name ="f_modo" value="E"/>
			<input type="hidden"  name ="f_co_especialidad" value="<%=idEsp%>"/>	
			</td>
			<% out.println("--"+idEsp+"---"); %>
			</tr>

  		</c:when>
  		
  
 		<c:when test="${modo == 'E'}"  >
 		
 		<tr>
		<td><label class="labels">Especialidad</label>	</td>
 		<td class="labels" align="left"><c:out value="${especialidad.deEspecialidad}"></c:out></td>
 		</tr>
 		
 		<tr>
		<td><label class="labels">Medico</label>	</td>

 		<td class="labels" align="left"><c:out value="${medicos.deMedico}"></c:out></td>
 		
 		</tr>
 		

		<tr>
			<td><label class="labels">Fecha:</label>	</td>
 			<td class="labels" align="left" ><input type="date"  name="f_fecha"></td>
 		
 		</tr>

 		
		<tr>
			<td><label class="labels">Hora:</label>	</td>
 			<td class="labels" align="left" ><input type="text"  name="f_horario"></td>
 		
 		</tr>
 		
 		<tr>
			<td><label class="labels">Comentario:</label></td>
			<td><textarea name="f_comentario"></textarea></td>
 		</tr>
 		
 		
 		
 		
 		
 			
			<input type="hidden"  name ="f_co_especialidad" value="<%=idEsp%>"/>
			<input type="hidden"  name ="f_co_medico" value="<%=idMedico%>"/>	
			<input type="hidden"  name ="f_co_paciente" value="<%=idUser%>"/>	
				<input type="hidden"  name ="f_modo" value="R"/>
 		
 		</c:when>  		
  		
  		
  		
  		
  
  	 	
	</c:choose>
          
          	
		
		

	
	
	<tr>
	<td colspan="2" align="center"><input type="submit" id="Registrar" size="60" value="Continuar"   style="width:100px;">	</td>
	</tr>
	
	

	
	<tr>
	<c:choose>
	<c:when test="${not empty mensaje}">
	<td colspan="2" align="center" class="labels">
	<c:out value="${mensaje}"/>
	</td>
	</c:when>
	<c:otherwise>
	<td colspan="2" align="center">
	</td>
	</c:otherwise>
		
	</c:choose>
	
	</tr>
	</table>
	</form>
	</div>
 </div>

    
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>
</body>
</html>