package org.joedayz.acweb.domain;

import java.io.Serializable;



public class Rol  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long   CO_ROLE_USER ;
	private Long   CO_ROLE ;
	private String DE_ROLE ;
	private String ST_ROLE ;
	
	
	
	
	public Long getCO_ROLE_USER() {
		return CO_ROLE_USER;
	}
	public void setCO_ROLE_USER(Long cO_ROLE_USER) {
		CO_ROLE_USER = cO_ROLE_USER;
	}
	
	
	
	public Long getCO_ROLE() {
		return CO_ROLE;
	}
	public void setCO_ROLE(Long cO_ROLE) {
		CO_ROLE = cO_ROLE;
	}
	public String getDE_ROLE() {
		return DE_ROLE;
	}
	public void setDE_ROLE(String dE_ROLE) {
		DE_ROLE = dE_ROLE;
	}
	public String getST_ROLE() {
		return ST_ROLE;
	}
	public void setST_ROLE(String sT_ROLE) {
		ST_ROLE = sT_ROLE;
	}
	
	
}
 