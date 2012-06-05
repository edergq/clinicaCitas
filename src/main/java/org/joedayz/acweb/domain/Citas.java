package org.joedayz.acweb.domain;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;

public class Citas  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long   co_cita ;
	private Date   fecha ;
	private String horario ;
	private Long   co_medico ;
	private Long   co_usuario ;
	private String st_cita ;
	private Long   co_especialidad ;
	private String comentario ;
	private BNEspecialidad especialidad;
	private BNMedico medico;
	private BNUsuario usuario;
	
	
	public BNEspecialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(BNEspecialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	public BNMedico getMedico() {
		return medico;
	}
	public void setMedico(BNMedico medico) {
		this.medico = medico;
	}
	
	
	
	public BNUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(BNUsuario usuario) {
		this.usuario = usuario;
	}
	public Long getCo_cita() {
		return co_cita;
	}
	public void setCo_cita(Long co_cita) {
		this.co_cita = co_cita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Long getCo_medico() {
		return co_medico;
	}
	public void setCo_medico(Long co_medico) {
		this.co_medico = co_medico;
	}
	public Long getCo_usuario() {
		return co_usuario;
	}
	public void setCo_usuario(Long co_usuario) {
		this.co_usuario = co_usuario;
	}
	public String getSt_cita() {
		return st_cita;
	}
	public void setSt_cita(String st_cita) {
		this.st_cita = st_cita;
	}
	public Long getCo_especialidad() {
		return co_especialidad;
	}
	public void setCo_especialidad(Long co_especialidad) {
		this.co_especialidad = co_especialidad;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

	
	
	
}
 