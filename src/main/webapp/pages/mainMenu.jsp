<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myClinic | Men&uacute; Principal</title>
<link rel="stylesheet" type="text/css" href="css/tuempresa.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/redmond/jquery-ui-1.8.16.custom.css" />
<script src="js/jquery-1.6.3.min.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery-ui-1.8.16.min.js" type="text/javascript" language="javascript"></script>
<script src="js/myClinic.js" type="text/javascript"></script>
<script src="js/tableMyClinic.js" type="text/javascript"></script>
<%@page import="org.joedayz.acweb.domain.*"%>

<%BNUsuario usuario=(BNUsuario)request.getSession().getAttribute("usuario"); %>
<%Citas citas=(Citas)request.getSession().getAttribute("citas"); %>
<%String url=getServletContext().getContextPath(); %>



</head>

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
        
      
    </div>
    <div id="footer_main">
     <jsp:include page="/footer.jsp" />
     </div>

</body>
</html>
