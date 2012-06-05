package org.joedayz.acweb.service;

import java.util.ArrayList;

import org.joedayz.acweb.dao.CitasDao;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.Citas;

public class CitasService {
	
	
	DAOFactory fabrica= DAOFactory.getDAOFactory(DAOFactory.H2);
	CitasDao citasDao= fabrica.getCitasDao();

	public ArrayList<Citas> listaCitas() throws Exception{
		return citasDao.listaCitas();
	}
	
	
	public ArrayList<Citas> listaCitasPorUser(Long long1 ) throws Exception{
		return citasDao.listaCitasPorUser(long1);
	
	}
	
	public int registrarCita(Citas citas) throws Exception{
		return citasDao.registrarCita(citas);

	}

	
	
	
}
