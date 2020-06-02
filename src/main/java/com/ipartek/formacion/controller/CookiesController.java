package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesController
 */
@WebServlet("/CookiesController")
public class CookiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recuerdame = request.getParameter("recuerdame");
		String email = request.getParameter("email");
		String idioma= request.getParameter("idioma");
		// Guardar una cookie con la ultima visita
				Cookie cUltimaVisita = new Cookie("ultima_visita", "1_de_junio_2020");
				cUltimaVisita.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
				response.addCookie(cUltimaVisita);
			
				// gestionar cookie del email		
				Cookie cEmail = new Cookie("cEmail", email );		
				if ( recuerdame != null ) {			
					cEmail.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
							
				}else{
					cEmail.setMaxAge(0);  // invalidar
					
				}		
				response.addCookie(cEmail);
				
				//gestionar el idioma seleccionado
					Cookie cIdioma=new Cookie("cIdioma",idioma);
					cIdioma.setMaxAge(60*1*60*24*364*5);// guarda 5 años la cookie
					//TODO RECOGER COOKIE
					response.addCookie(cIdioma);
				
				
				// recoger todas las cookies en el servidor
				Cookie[] arrayGalletitas = request.getCookies();
				// para buscar una habrai que hacer un for y buscar por su identificador
		
		
		response.getWriter().append("cookies.jsp ").append(request.getContextPath());
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// recoger parametros
		
	}
}
