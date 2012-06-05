package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNEspecialidad;

public class EspecialidadService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	EspecialidadDAO especialidadDAO = fabrica.getEspecialidadDAO();
	
	public List<BNEspecialidad> getListaEspecialidades() throws Exception{
		return especialidadDAO.getEspecialidades();
	}
	
	public List<BNEspecialidad> getEspecialidadesPorMedico(String idMedico) throws Exception{
		return especialidadDAO.getEspecialidadPorMedico(idMedico);
	}
	
	public BNEspecialidad getEspecialidadPorId(String idEspecialidad) throws Exception{
		return especialidadDAO.getEspecialidadPorId(idEspecialidad);
	}
	
}
