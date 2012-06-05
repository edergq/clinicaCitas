package org.joedayz.acweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.BNEspecialidad;

public class EspecialidadDaoImpl implements EspecialidadDAO{

	private BaseDaoSupport daoSupport = new BaseDaoSupport();
	public int contador = 3;
	
	public List<BNEspecialidad> getEspecialidades() throws Exception{
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNEspecialidad> especialidades = new ArrayList<BNEspecialidad>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select co_especialidad,de_especialidad,st_especialidad "+
							" from especialidad";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(1));
				especialidad.setDeEspecialidad(rs.getString(2));
				especialidades.add(especialidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
		
 		return especialidades;
	}

	public List<BNEspecialidad> getEspecialidadPorMedico(String idMedico) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNEspecialidad> especialidades = new ArrayList<BNEspecialidad>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select b.co_especialidad,b.de_especialidad,b.st_especialidad "+
							" from medico a, especialidad b "+
							" where a.co_especialidad = b.co_especialidad "+
							" and a.co_medico = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idMedico);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(1));
				especialidad.setDeEspecialidad(rs.getString(2));
				especialidades.add(especialidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
		
 		return especialidades;
	}

	public BNEspecialidad getEspecialidadPorId(String idEspecialidad)
			throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		BNEspecialidad especialidad = new BNEspecialidad();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select b.co_especialidad,b.de_especialidad,b.st_especialidad "+
							" from medico a, especialidad b "+
							" where a.co_especialidad = b.co_especialidad "+
							" and b.co_especialidad = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idEspecialidad);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(1));
				especialidad.setDeEspecialidad(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
 		return especialidad;
	}

}
