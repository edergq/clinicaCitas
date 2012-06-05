package org.joedayz.acweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.joedayz.acweb.dao.RolDAO;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.Citas;
import org.joedayz.acweb.domain.Rol;
import org.joedayz.acweb.util.GeneradorId;

public class RolDaoImpl implements RolDAO{

	private BaseDaoSupport daoSupport = new BaseDaoSupport();
	public int contador = 3;
	
	public List<Rol> getRol() throws Exception{
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<Rol> roles = new ArrayList<Rol>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql = "select co_role ,de_role "+
							" from role ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Rol rol = new Rol();
				rol.setCO_ROLE(rs.getLong(1));
				rol.setDE_ROLE(rs.getString(2));
				roles.add(rol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
		
 		return roles;
	}
	
	
	public int registrarRolUser(Long co_role) throws Exception {
		
		int resultado 	= 0;
		
		Connection 	con	= null;
		String sql 		= null;
		PreparedStatement pstm = null;
		Rol rol= new Rol();
		try {
			con = daoSupport.getConnexion();
											  
			sql = " insert into USUARIO_ROLE( CO_ROLE_USER ,CO_ROLE,CO_USER ,ST_ROLE_USER ) " +
				      " values(?,?,?,?) ";
		
			pstm = con.prepareStatement(sql);

			pstm.setLong(1, GeneradorId.getId("USUARIO_ROLE", "CO_ROLE_USER"));
			pstm.setLong(2, co_role);
			pstm.setLong(3, GeneradorId.getId("USUARIO", "CO_USER") -1);
			pstm.setBoolean(4, true);
			
			
			
			resultado = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en el insert de rol de usuario "+e.getMessage());
				pstm.close();
				con.close();
			}
		
			return resultado;
	}
	

	

}
