<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
String mjs=(String)request.getAttribute("mensaje");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JoeDayz - myClinic | Login</title>
<link rel="stylesheet" type="text/css" href="css/tuempresa.css" />
</head>
<body>

<div id="contenedor">
    <div id="back">
        <div id="fondo">
        <form id="form" action="ServletLogin" method="post">
        <div id="title">
        my<span>Clinic </span><br /><span class="texto">versi&oacute;n 1.0.0</span><br /><br />
        <span class="texto">Ingrese su Usuario: </span><input name="usuario" id="usuario" type="text"/><br />
        <span class="texto">Ingrese su Password:</span><input name="pass" id="pass" type="password"/><br /><br />
        <div class="centrado"><input type="submit" value="Ingresar" class="button"/></div>
	      <%if(mjs!=null){ %>
		  <span class="error"><%=mjs %></span>
		  <%} %>
        </div> 
        </form>
        </div>
  </div>

  <div id="footer_login">
        <div class="left">&copy; Copyright, Todos los Derechos Reservados 2011</div>
        <div class="right"><img src="images/logo.png"/><br />Powered by <a href="http://www.joedayz.pe">JoeDayz E.I.R.L</a></div>
    </div>
</div>

</body>
</html> 
