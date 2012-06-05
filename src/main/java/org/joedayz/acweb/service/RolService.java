package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.RolDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.Citas;
import org.joedayz.acweb.domain.Rol;

public class RolService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	RolDAO rolDAO = fabrica.getRolDAO();
	
	public List<Rol> getRoles() throws Exception{
		return rolDAO.getRol();
	}
	
	public int  registrarRolUser(Long co_role) throws Exception{
		return rolDAO.registrarRolUser(co_role);
	}
	  
	 
	 
	 
}
