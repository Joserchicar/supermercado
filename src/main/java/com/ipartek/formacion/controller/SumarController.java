package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumarController
 */
@WebServlet("/sumar")
public class SumarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recoger parametros del formulario
		String parametro1 = request.getParameter("op1");
		String parametro2 = request.getParameter("op2");
		
		//cualquiera de las dos formas son validas
		
		//int op1=Integer.parseInt(parametro1);
		//int op2=Integer.parseInt(parametro2);
		//int resultado = op1 + op2;
		int resultado=Integer.parseInt(parametro1)+Integer.parseInt(parametro2);
		
		
		//TODO Parsear a int y sumar
		//String resultado = parametro1 + parametro2;
		
		//volver a enviar los PARAMETROS recibido como ATRIBUTOS
		request.setAttribute("op1", parametro1);		
		request.setAttribute("op2", parametro2);	
		
		request.setAttribute("resultado", resultado);		
		request.getRequestDispatcher("getYpost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//recoger parametros del formulario
		String parametro1 = request.getParameter("op1");
		String parametro2 = request.getParameter("op2");
		request.setAttribute("op1", parametro1);		
		request.setAttribute("op2", parametro2);
		//TODO Parsear a int y sumar
		
		//int op1=Integer.parseInt(parametro1);
		//int op2=Integer.parseInt(parametro2);
		//int resultado = op1 + op2;
		int resultado=Integer.parseInt(parametro1)+Integer.parseInt(parametro2);
		//volver a enviar los PARAMETROS recibido como ATRIBUTOS
		
		request.setAttribute("resultado", resultado);
	}catch(Exception e) {
		request.setAttribute("mensaje", "introduce un valor numerico");
	}finally {
		
		request.getRequestDispatcher("getYpost.jsp").forward(request, response);
	}
	}

}
