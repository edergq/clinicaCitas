package org.joedayz.acweb.dao;

import java.util.ArrayList;

import org.joedayz.acweb.domain.Citas;

public interface CitasDao   {
	

	public ArrayList<Citas> listaCitas() throws Exception;
	public ArrayList<Citas> listaCitasPorUser(Long long1 ) throws Exception;
	
	public int registrarCita(Citas citas) throws Exception;
	
	
}
