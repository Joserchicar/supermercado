package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApartadoBController
 */
@WebServlet("/Apartado-b")
public class ApartadoBController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApartadoBController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nombre = request.getParameter("nombre");
		String navegador = request.getHeader("user-agent");

		// Crear Session

		HttpSession session = request.getSession();

		// obtener tiempo
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_ HH:mm"));

		// devolver

		session.setAttribute("nombre", nombre);
		session.setAttribute("user-agent", navegador);
		session.setAttribute("tiempo", formattedDate);

		request.getRequestDispatcher("ResultadoB.jsp").forward(request, response);

		
		//Redirección 
		
		//response.sendRedirect("ApartadoB.jsp");
	}

}
