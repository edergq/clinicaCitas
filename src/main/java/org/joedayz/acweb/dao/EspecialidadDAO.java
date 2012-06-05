package org.joedayz.acweb.dao;

import java.util.List;

import org.joedayz.acweb.domain.BNEspecialidad;

public interface EspecialidadDAO {
	public List<BNEspecialidad> getEspecialidades() throws Exception;
	public List<BNEspecialidad> getEspecialidadPorMedico(String idMedico) throws Exception;
	public BNEspecialidad getEspecialidadPorId(String idEspecialidad) throws Exception;
}
