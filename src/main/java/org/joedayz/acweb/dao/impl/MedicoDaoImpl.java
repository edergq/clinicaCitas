package org.joedayz.acweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;

public class MedicoDaoImpl implements MedicoDAO{
	private BaseDaoSupport daoSupport = new BaseDaoSupport();
	public int contador = 3;
	public List<BNMedico> getListaMedicos() throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNMedico> medicos = new ArrayList<BNMedico>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select a.co_medico,a.de_medico,b.co_especialidad,b.de_especialidad "+
							" from medico a, especialidad b where a.co_especialidad = b.co_especialidad";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				
				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(3));
				especialidad.setDeEspecialidad(rs.getString(4));

				BNMedico medico = new BNMedico();
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				medico.setEspecialidad(especialidad);
				
				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
 		return medicos;
	}

	public List<BNMedico> getMedicosPorEspecialidad(String idEspecialidad)
			throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNMedico> medicos = new ArrayList<BNMedico>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select a.co_medico,a.de_medico,b.co_especialidad,b.de_especialidad "+
							" from medico a, especialidad b "+
							" where a.co_especialidad = b.co_especialidad"+
							" and b.co_especialidad=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idEspecialidad);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				
				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(3));
				especialidad.setDeEspecialidad(rs.getString(4));

				BNMedico medico = new BNMedico();
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				medico.setEspecialidad(especialidad);
				
				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
 		return medicos;
	}

	public BNMedico getMedicoPorId(String idMedico) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		//List<BNMedico> medicos = new ArrayList<BNMedico>();
		BNMedico medico = new BNMedico();
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select co_medico , de_medico "+
							" from medico "+
							" where  co_medico=?" ;
							
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idMedico);
			rs = pstm.executeQuery();
			
			
			if(rs.next()){
				
				
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				
	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
 		return medico;
 	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
