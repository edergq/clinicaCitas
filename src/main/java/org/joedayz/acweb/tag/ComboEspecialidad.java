package org.joedayz.acweb.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.service.EspecialidadService;

public class ComboEspecialidad  extends TagSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {
	
		DAOFactory fabrica=DAOFactory.getDAOFactory(7);
		EspecialidadService especialidadService = new EspecialidadService();
		List<BNEspecialidad> especialidades = new ArrayList<BNEspecialidad>();
			
		try {
			especialidades = especialidadService.getListaEspecialidades();
			
			JspWriter salida = pageContext.getOut();
			
			for (BNEspecialidad especialidad : especialidades) {
				salida.print("<option value=");
				salida.print(especialidad.getCoEspecialidad());
				salida.print(">");
				salida.print(especialidad.getDeEspecialidad());
				salida.println("</option >");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
