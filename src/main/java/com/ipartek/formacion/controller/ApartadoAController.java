package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApartadoAController
 */
@WebServlet("/Apartado-a")
public class ApartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		
		//crear cookie de nombre
				Cookie cNombre = new Cookie("nombre", nombre);
				cNombre.setMaxAge( 60 * 1 * 60 * 24 * 365 ); // duracion 1 año
				// guardar cookie 
				response.addCookie(cNombre);
				
		//crear cookie del color elegido
				Cookie cColor=new Cookie("color",color);
				cColor.setMaxAge(60*1*60*24*365);// Duracion 1 año 		
				
				response.addCookie(cColor);
		
			
				// ir a la nueva vista o jsp
				//request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
				
				
				//Redirección 
					
				response.sendRedirect("resultadoA.jsp");
	}

}
