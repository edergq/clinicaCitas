package org.joedayz.acweb.dao;

import java.util.List;

import org.joedayz.acweb.domain.BNMedico;

public interface MedicoDAO {

	public List<BNMedico> getListaMedicos() throws Exception;
	public List<BNMedico> getMedicosPorEspecialidad(String idEspecialidad) throws Exception;
	public BNMedico getMedicoPorId(String idMedico) throws Exception;
	
}
