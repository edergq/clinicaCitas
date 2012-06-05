package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNMedico;

public class MedicoService {


	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	MedicoDAO medicoDAO = fabrica.getMedicoDAO();
	
	public List<BNMedico> getListaMedicos() throws Exception{
		return medicoDAO.getListaMedicos();
	}
	
	public List<BNMedico> getMedicosPorEspecialidad(String idEspecialidad) throws Exception{
		return medicoDAO.getMedicosPorEspecialidad(idEspecialidad);
	}
	
	public BNMedico  getMedicoPorId(String idMedico) throws Exception{
		return medicoDAO.getMedicoPorId(idMedico);
	}
	
}
