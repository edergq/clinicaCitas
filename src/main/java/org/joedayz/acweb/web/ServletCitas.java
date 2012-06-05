package org.joedayz.acweb.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.domain.Citas;
import org.joedayz.acweb.service.CitasService;
import org.joedayz.acweb.service.EspecialidadService;
import org.joedayz.acweb.service.MedicoService;
import org.joedayz.acweb.service.RolService;
import org.joedayz.acweb.util.Constantes;




/**
 * Servlet implementation class ServletCitas
 */
public class ServletCitas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VIEWCITAS="/pages/cita/listadoCita.jsp";
	public static final String VIEWCITASREGISTRAR="/pages/cita/registrarCita.jsp";

	Citas citas=new Citas();
	CitasService servicio= new CitasService();

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String registrar=request.getParameter("f_registrar");

		
		
		BNUsuario usuariosession=(BNUsuario)request.getSession().getAttribute("usuario"); 
		
		//if(usuariosession.getDeRol().equalsIgnoreCase(Constantes.ADMIN) && registrar!=null){
		if(registrar!=null){
			ArrayList<Citas> citas=null;
			try {
				
				if(usuariosession.getDeRol().equalsIgnoreCase(Constantes.ADMIN)){
					citas=servicio.listaCitas();
					
					System.out.print("id rol "+usuariosession.getDeRol()+"-----");
				}else {
					citas=servicio.listaCitasPorUser(usuariosession.getCoUser());
					
					
				}

				System.out.println(citas.size());
				
				
				
			} catch (Exception e) {
				System.out.println("Error en listado "+e.getMessage());
			}

			
			
			request.setAttribute("citas",citas);
			request.getRequestDispatcher(VIEWCITAS).forward(request, response);
			
			
			
			
		}else	if(registrar!=null){
				/*Formulario de Registro*/
				
				getServletContext().getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);
				
			
		}else if(registrar==null){
				request.getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);	
				
	}
			
			
			


		
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String modo    			=request.getParameter("f_modo");
	
		
		
		
		String co_especialidad  =request.getParameter("f_co_especialidad");
		String co_medico  		=request.getParameter("f_co_medico");
		
		String fecha    		=request.getParameter("f_fecha");
		//if(fecha.equals("")||fecha==null) fecha="2012-06-01";
		
		String horario  		=request.getParameter("f_horario");
		String co_usuario   	=request.getParameter("f_co_paciente");
		String comentario       =request.getParameter("f_comentario");
		
	
		
		int resultado=0;
		int resultado1=0;
		
		try {
			List<BNMedico> medicos = null;
			
			MedicoService medicoService = new MedicoService();
			RolService 	  rolService=new RolService();
			
			//BNMedico medicos=medicoService.getMedicoPorId(co_medico);
			EspecialidadService especialidadService = new EspecialidadService();
			BNEspecialidad especialidad = especialidadService.getEspecialidadPorId(co_especialidad);
			
			
			if(modo.equals("M"))  {
				System.out.println("modo     ="+modo);
				System.out.println("idEspecialidad     ="+co_especialidad);
				
				medicos = medicoService.getMedicosPorEspecialidad(co_especialidad);
				especialidad=especialidadService.getEspecialidadPorId(co_especialidad);
						
				request.setAttribute("especialidad", especialidad);
				request.setAttribute("medicos", medicos);
				request.setAttribute("idEspecialidad", co_especialidad);
				request.setAttribute("modo",modo);	
				getServletContext().getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);

			}
			
			if(modo.equals("E")){
				
				BNMedico medico = null;
				medico = medicoService.getMedicoPorId(co_medico);
				especialidad=especialidadService.getEspecialidadPorId(co_especialidad);
				
				request.setAttribute("especialidad", especialidad);
				request.setAttribute("medicos", medico);
				
				request.setAttribute("idEspecialidad", co_especialidad);
				request.setAttribute("idMedico", co_medico);
				
				request.setAttribute("modo",modo);
				getServletContext().getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);
				
			}
			
			
			
			if(modo.equals("R"))  {
				
				Date sfecha=null;

				SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");

				try {  sfecha= formatoDeFecha.parse(fecha);  
				} catch (ParseException e) {  
					e.printStackTrace();
				}
				

				
				    
				
					citas.setFecha(sfecha);
					citas.setHorario(horario);
					citas.setCo_medico(Long.parseLong(co_medico));
					citas.setCo_usuario(Long.parseLong(co_usuario));
					citas.setCo_especialidad(Long.parseLong(co_especialidad));
					citas.setComentario(comentario);
					
					citas.setSt_cita("1");
				
					resultado=servicio.registrarCita(citas);


				if(resultado==0){
					request.setAttribute("mensaje","Problemas al registar la cita");
				}else{
					request.setAttribute("mensaje","Se Registro Correctamente");
				} 
					
					
					
				request.setAttribute("modo",modo);				
				getServletContext().getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);

			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Error al registrar -----"+e.getMessage());
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
