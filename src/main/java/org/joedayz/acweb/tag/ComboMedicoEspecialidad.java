package org.joedayz.acweb.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.service.MedicoService;

public class ComboMedicoEspecialidad extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String idEspecialidad;
	
	public String getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	@Override
	public int doEndTag() throws JspException {
		
		try {
			JspWriter salida =  pageContext.getOut();
			
			MedicoService  servicio =  new MedicoService();
			List<BNMedico> medicos = servicio.getMedicosPorEspecialidad(getIdEspecialidad());
			
			salida.print("<select id=\"idMedico\" name=\"f_co_medico\" >");
			for (BNMedico medico : medicos) {
				salida.print("<option value=");
				salida.print(medico.getCoMedico());
				salida.print(">");
				salida.print(medico.getDeMedico());
				salida.println("</option>");
			}
			salida.print("</select>");
			System.out.println("MedicoTag.doEndTag()");
			System.out.println("bien :)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	

}
