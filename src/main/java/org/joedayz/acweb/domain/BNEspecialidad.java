package org.joedayz.acweb.domain;

import java.io.Serializable;

public class BNEspecialidad  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long coEspecialidad;
	private String deEspecialidad;
	private char stEspecialidad;
	
	public Long getCoEspecialidad() {
		return coEspecialidad;
	}
	public void setCoEspecialidad(Long coEspecialidad) {
		this.coEspecialidad = coEspecialidad;
	}
	public String getDeEspecialidad() {
		return deEspecialidad;
	}
	public void setDeEspecialidad(String deEspecialidad) {
		this.deEspecialidad = deEspecialidad;
	}
	public char getStEspecialidad() {
		return stEspecialidad;
	}
	public void setStEspecialidad(char stEspecialidad) {
		this.stEspecialidad = stEspecialidad;
	}
	
}
