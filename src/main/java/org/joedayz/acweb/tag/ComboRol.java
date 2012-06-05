package org.joedayz.acweb.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.Rol;
import org.joedayz.acweb.service.EspecialidadService;
import org.joedayz.acweb.service.RolService;

public class ComboRol  extends TagSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {
	
		DAOFactory fabrica=DAOFactory.getDAOFactory(7);
		RolService rolService=new RolService();
		List<Rol> roles = new ArrayList<Rol>();
			
		try {
			roles = rolService.getRoles();
			
			JspWriter salida = pageContext.getOut();
			
			for (Rol rol : roles) {
				salida.print("<option value=");
				salida.print(rol.getCO_ROLE());
				salida.print(">");
				salida.print(rol.getDE_ROLE());
				salida.println("</option >");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
