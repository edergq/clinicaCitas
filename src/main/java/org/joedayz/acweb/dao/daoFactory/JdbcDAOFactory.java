package org.joedayz.acweb.dao.daoFactory;

import org.joedayz.acweb.dao.CitasDao;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.RolDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.impl.CitasDaoImpl;
import org.joedayz.acweb.dao.impl.EspecialidadDaoImpl;
import org.joedayz.acweb.dao.impl.JdbcUsuarioDaoImpl;
import org.joedayz.acweb.dao.impl.MedicoDaoImpl;
import org.joedayz.acweb.dao.impl.RolDaoImpl;



public class JdbcDAOFactory extends DAOFactory{
	
	public UsuarioDAO getUsuarioDAO() {
		return new JdbcUsuarioDaoImpl();
	}

	@Override
	public CitasDao getCitasDao() {
		// TODO Auto-generated method stub
		return new CitasDaoImpl();
	}

	
	public EspecialidadDAO getEspecialidadDAO(){
		return new EspecialidadDaoImpl();
	}

	@Override
	public MedicoDAO getMedicoDAO() {
		// TODO Auto-generated method stub
		return new MedicoDaoImpl();
	}

	
	public RolDAO getRolDAO() {
		// TODO Auto-generated method stub
		return new RolDaoImpl();
	}

	
}
