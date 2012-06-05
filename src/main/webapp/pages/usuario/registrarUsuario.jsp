<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="select" uri="/WEB-INF/tag/tagLib.tld" %>
<html>

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
	<form id="formulario" action="ServletUsuario" method="post">
	
	<table width="80%" border="0"  style="margin-left: auto">
	<tr>
	<th colspan="2"><h2 class="titleForm">Formulario de Registro de Usuario</h2>
	</th>
	</tr>
	
	<tr>
			<td><label class="labels">Rol</label></td>
			<td><select name="f_co_rol">
					<select:ComboRol/>
				</select>
			</td>
		</tr>	
	
	
	
	<tr>
	<td width="30%"><label class="labels">Nombre Usuario</label></td>
	<td><input type="text" id="username" name="username" size="60">	</td>
	</tr>
	<tr>
	<td><label class="labels">Nombres</label>	</td>
	<td><input type="text" id="nombres" name="nombres"  size="60"></td>
	</tr>
	<tr>
	<td><label class="labels">Apellidos</label>	</td>
	<td><input type="text" id="apellidos" name="apellidos" size="60">	</td>
	</tr>
	
	<tr>
	<td><label class="labels">Sexo</label>	</td>
	<td> <p>
          <label class="labels">Masculino
            <input type="radio" name="sexo" value="1" id="sexo_0"  class="textoAzulCuerpo"/>
            </label>
          <br />
          <label class="labels">Femenino
            <input type="radio" name="sexo" value="2" id="sexo_1"  class="textoAzulCuerpo"/>
            </label>
          <br />
        </p>   </td>
	</tr>
	<tr>
	<td><label class="labels">Password</label>	</td>
	<td><input type="text" id="password" name="password"  size="60">	</td>
	</tr>
	<tr>
	<td><label class="labels">Direccion</label>	</td>
	<td><input type="text" id="direccion"  name="direccion"  size="80"></td>
	</tr>
	
	<tr>
	<td><label class="labels">Telefono</label>	</td>
	<td><input type="text" id="telefono"  name="telefono" size="60">	</td>
	</tr>
	
	<tr>
	<td><label class="labels">Tipo de Documento</label>	</td>
	<td><select id="tipodocumento"   name="tipodocumento">
	<option value="1">DNI</option>
	<option value="2">Pasaporte</option>
	<option value="3">Libreta Militar</option>
	</select></td>
	</tr>
	
	<tr>
	<td><label class="labels">Nro. Documento</label>	</td>
	<td><input type="text" id="nrodocumento" name="nrodocumento" size="60">	</td>
	</tr>
	
	<tr>
	<td><label class="labels">Email</label>	</td>
	<td><input type="text" id="email" name="email" size="60">	</td>
	</tr>
	
	
	
	
	
	
	<tr>
	<td colspan="2" align="center"><input type="submit" id="Registrar" size="60" value="Registrar"   style="width:100px;">	</td>
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