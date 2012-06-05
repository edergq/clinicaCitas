package org.joedayz.acweb.dao;

import java.util.ArrayList;

import org.joedayz.acweb.domain.BNUsuario;

public interface UsuarioDAO {
	
	public BNUsuario validarUsuario(String usuario,String password)throws Exception; 
	public ArrayList<BNUsuario> listadoUsuarios() throws Exception;
	public int registrarUsuario(BNUsuario usuario) throws Exception;
}
