package org.joedayz.acweb.service;

import java.util.ArrayList;

import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNUsuario;

public class UsuarioService {
	
	DAOFactory fabrica 	  = DAOFactory.getDAOFactory(DAOFactory.H2);
	UsuarioDAO usuarioDao = fabrica.getUsuarioDAO(); 
	
	
	public BNUsuario validarUsuario(String usuario, String password) throws Exception  {
		return usuarioDao.validarUsuario(usuario,password);
	}
	
	public ArrayList<BNUsuario> listadoUsuarios() throws Exception{
		return usuarioDao.listadoUsuarios();
	}
	
	public int registrarUsuario(BNUsuario usuario) throws Exception{
		return usuarioDao.registrarUsuario(usuario);
	}
	
}
