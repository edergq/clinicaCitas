package org.joedayz.acweb.domain;

import java.io.Serializable;

public class BNUsuario implements Serializable{
	
	private static final long serialVersionUID = -5069094294287446581L;
	private Long coUser ;
	private String userName ;
	private String email ;
	private String nombres ;
	private String apellidos ;
	private char stUsuario ;//bit
	private char sexo ;
	private String direccion ;
	private String telefono;
	private char tipoDocumento;
	private Long documento ;
	private String password ;
	private char accountExpired ;//bit
	private char accountLocked ;//bit
	private char credentialsExpired;//bit
	private char accountEnabled ;//bit
	private String passwordHint;
	
	private Rol rol;
	private String deRol;
	
	
	
	
	
	
	public String getDeRol() {
		return deRol;
	}
	
	public void setDeRol(String deRol) {
		this.deRol = deRol;
	}
	public Long getCoUser() {
		return coUser;
	}
	public void setCoUser(Long coUser) {
		this.coUser = coUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getStUsuario() {
		return stUsuario;
	}
	public void setStUsuario(char stUsuario) {
		this.stUsuario = stUsuario;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public char getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(char tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Long getDocumento() {
		return documento;
	}
	public void setDocumento(Long documento) {
		this.documento = documento;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(char accountExpired) {
		this.accountExpired = accountExpired;
	}
	public char getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(char accountLocked) {
		this.accountLocked = accountLocked;
	}
	public char getCredentialsExpired() {
		return credentialsExpired;
	}
	public void setCredentialsExpired(char credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	public char getAccountEnabled() {
		return accountEnabled;
	}
	public void setAccountEnabled(char accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	} 
	
	
	
}
