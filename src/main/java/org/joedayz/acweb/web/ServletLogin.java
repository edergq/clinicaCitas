package org.joedayz.acweb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.service.UsuarioService;
import org.joedayz.acweb.util.Constantes;

public class ServletLogin extends HttpServlet{
	
	public static final String VIEWLOGIN="/login.jsp";
	public static final String VIEWMAIN="/pages/mainMenu.jsp";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		
		BNUsuario usuario= new BNUsuario();
		HttpSession session=request.getSession(true);
		UsuarioService servicio= new UsuarioService();
		
		String usu	= request.getParameter("usuario");
		String pass	= request.getParameter("pass");

		if((usu==null || pass==null)||(usu.equals(Constantes.VACIO))|| pass.equals(Constantes.VACIO)){
			request.setAttribute("mensaje", "Usuario y Contrase&ntilde;a Incorrecta.");
			
			getServletContext().getRequestDispatcher(VIEWLOGIN).forward(request, response);
			
		}else{
		
		try {
			usuario=servicio.validarUsuario(usu,pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usuario==null){
			request.setAttribute("mensaje", "No Se encontro el Usuario.");
			getServletContext().getRequestDispatcher(VIEWLOGIN).forward(request, response);

		}else{
			request.getSession().setAttribute("usuario",usuario);
			getServletContext().getRequestDispatcher(VIEWMAIN).forward(request, response);

		}
		

		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		HttpSession sesion = request.getSession();

		sesion.invalidate();

		getServletContext().getRequestDispatcher(VIEWLOGIN).forward(request, response);
	
	}

}
