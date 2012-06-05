package org.joedayz.acweb.dao.impl;



import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.joedayz.acweb.dao.CitasDao;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.domain.Citas;
import org.joedayz.acweb.util.GeneradorId;

import java.util.Date;

public class CitasDaoImpl implements CitasDao {

	
	private BaseDaoSupport daoSupport= new BaseDaoSupport();
	
	public ArrayList<Citas> listaCitas() throws Exception {
			Statement	 st = null;
			Connection   con = null;
			ResultSet    rs= null;
			Citas cita=null;
			ArrayList<Citas>	citas	= new ArrayList<Citas>();
			
			try {
				
				con= daoSupport.getConnexion();
				
				String 
			sql  =" select              				" +
						"			   a.CO_CITA co_cita, " +
						"			   a.FECHA FECHA," +
						"			   a.horario horario, " +
						"			   a.comentario comentario," +
						"			   a.co_especialidad co_especialidad," +
						"			   b.de_especialidad de_especialidad," +
						"			   a.co_medico co_medico, " +
						"              c.de_medico	de_medico,  " +
						"			   a.co_usuario co_usuario, " +
						"			   d.nombres nombres,	" +
						"			   d.apellidos apellidos " +
						//"			   a.st_cita , " +
						"		from citas a, especialidad b, medico c, usuario d " +
						"		where a.co_medico=c.co_medico"+
						"       and   a.co_especialidad=b.co_especialidad "+
						"       and   b.st_especialidad=true " +
						"       and   c.st_medico=true " +
						"       and   a.st_cita=true" +
						"		and   a.co_usuario=d.co_user ";

				//sql= "select FECHA, co_medico, co_especialidad,co_especialidad, comentario, horario from citas ";
				st =con.createStatement();
				rs=st.executeQuery(sql);
				
				while (rs.next()){
					cita=new Citas();
					BNUsuario usuario=new BNUsuario();
					BNEspecialidad especialidad= new BNEspecialidad();
					BNMedico medico= new BNMedico();
					
					cita.setCo_cita(rs.getLong("co_cita"));
					cita.setFecha(rs.getDate("fecha"));
					cita.setHorario(rs.getString("horario"));
					cita.setComentario(rs.getString("comentario"));
					
					especialidad.setCoEspecialidad(rs.getLong("co_especialidad"));
					especialidad.setDeEspecialidad(rs.getString("de_especialidad"));
					
					medico.setCoMedico(rs.getLong("co_medico"));
					medico.setDeMedico(rs.getString("de_medico"));
					
					usuario.setCoUser(rs.getLong("co_usuario"));
					usuario.setNombres(rs.getString("nombres"));
					usuario.setApellidos(rs.getString("apellidos"));
					
					cita.setUsuario(usuario);
					cita.setMedico(medico);
					cita.setEspecialidad(especialidad);

					citas.add(cita);

					System.out.println("select correcto de citas");	
				}

				rs.close();

			} catch (SQLException e) {
				System.out.println("Error en el select de citas "+e.getMessage());
				
				
			} finally{
				st.close();
			}
			
		
		return citas;
	}

	
	
	
	
	
	public ArrayList<Citas> listaCitasPorUser(Long idUser ) throws Exception {
		Statement	 st = null;
		Connection   con = null;
		ResultSet    rs= null;
		Citas cita=null;
		ArrayList<Citas>	citas	= new ArrayList<Citas>();
		
		try {
			
			con= daoSupport.getConnexion();
			
			String 
		sql  =" select              				" +
					"			   a.CO_CITA co_cita, " +
					"			   a.FECHA FECHA," +
					"			   a.horario horario, " +
					"			   a.comentario comentario," +
					"			   a.co_especialidad co_especialidad," +
					"			   b.de_especialidad de_especialidad," +
					"			   a.co_medico co_medico, " +
					"              c.de_medico	de_medico,  " +
					"			   a.co_usuario co_usuario, " +
					"			   d.nombres nombres,	" +
					"			   d.apellidos apellidos " +
					//"			   a.st_cita , " +
					"		from citas a, especialidad b, medico c, usuario d " +
					"		where a.co_medico=c.co_medico"+
					"       and   a.co_especialidad=b.co_especialidad "+
					"       and   b.st_especialidad=true " +
					"       and   c.st_medico=true " +
					"       and   a.st_cita=true" +
					"		and   a.co_usuario=d.co_user " +
					"       and   d.co_user='"+idUser+"'  ";

			//sql= "select FECHA, co_medico, co_especialidad,co_especialidad, comentario, horario from citas ";
			st =con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				cita=new Citas();
				BNUsuario usuario=new BNUsuario();
				BNEspecialidad especialidad= new BNEspecialidad();
				BNMedico medico= new BNMedico();
				
				cita.setCo_cita(rs.getLong("co_cita"));
				cita.setFecha(rs.getDate("fecha"));
				cita.setHorario(rs.getString("horario"));
				cita.setComentario(rs.getString("comentario"));
				
				especialidad.setCoEspecialidad(rs.getLong("co_especialidad"));
				especialidad.setDeEspecialidad(rs.getString("de_especialidad"));
				
				medico.setCoMedico(rs.getLong("co_medico"));
				medico.setDeMedico(rs.getString("de_medico"));
				
				usuario.setCoUser(rs.getLong("co_usuario"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setApellidos(rs.getString("apellidos"));
				
				cita.setUsuario(usuario);
				cita.setMedico(medico);
				cita.setEspecialidad(especialidad);

				citas.add(cita);

				System.out.println("select correcto de citas");	
			}

			rs.close();

		} catch (SQLException e) {
			System.out.println("Error en el select de citas "+e.getMessage());
			
			
		} finally{
			st.close();
		}
		
	
	return citas;
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int registrarCita(Citas citas) throws Exception {
		
		int resultado 	= 0;
		int contador    = 100;
		Connection 	con	= null;
		String sql 		= null;
		PreparedStatement pstm = null;
		
		
		
		try {
			con = daoSupport.getConnexion();


			sql = " insert into citas( CO_CITA ,FECHA ,  horario  , co_medico , co_usuario , st_cita , co_especialidad , comentario) " +
				      " values(?,?,?,?,?,?,?,?) ";
			 
		
			pstm = con.prepareStatement(sql);
			
		
			pstm.setLong(1, GeneradorId.getId("citas", "co_cita"));
			pstm.setDate(2, new java.sql.Date(citas.getFecha().getTime()));
			pstm.setString(3, citas.getHorario());
			pstm.setLong(4, citas.getCo_medico());
			pstm.setLong(5, citas.getCo_usuario());
			pstm.setBoolean(6, true);
			pstm.setLong(7, citas.getCo_especialidad());
			pstm.setString(8, citas.getComentario());
			
			resultado = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en el insert de cita "+e.getMessage());
				pstm.close();
				con.close();
			}
		
			return resultado;
	}

}




