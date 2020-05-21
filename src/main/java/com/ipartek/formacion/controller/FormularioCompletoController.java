package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/formulario-completo")

public class FormularioCompletoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> validationes = new ArrayList<>();

		try {

			// recogemos parametros del formulario
			String nombre = request.getParameter("name");
			String apellido = request.getParameter("surname");

			String estudios = request.getParameter("Studies");
			String genero = request.getParameter("gender");
			String[] horario = request.getParameterValues("hours");
			String comentario = request.getParameter("comment");
			String foto = request.getParameter("photo");

			if ("".equalsIgnoreCase(nombre)) {
				validationes.add("El NOMBRE es obligatorio");
			}

			if ("".equalsIgnoreCase(apellido)) {
				validationes.add("El APELLIDO es obligatorio");
			}
			int edad = Integer.parseInt(request.getParameter("age"));

			if (estudios.equalsIgnoreCase("u")) {
				estudios = "University";
			} else if (estudios.equalsIgnoreCase("v")) {
				estudios = "Vocational training";
			} else {
				estudios = "Others";
			}

			// Checking shift selected by user
			ArrayList<String> hoursSelected = new ArrayList<String>();
			if (horario != null) {
				for (String selection : horario) {

					if (selection.equalsIgnoreCase("ft")) {
						hoursSelected.add("Full time");
					} else if (selection.equalsIgnoreCase("pt")) {
						hoursSelected.add("Part time");
					} else {
						hoursSelected.add("Other");
					}

				}
			}
			// End shift checking

			if (genero.equalsIgnoreCase("m")) {
				genero = "Male";
			} else if (genero.equalsIgnoreCase("f")) {
				genero = "Female";
			} else {
				genero = "Other";
			}

			// devolvemos al formulario como atributos

			// request.getRequestDispatcher("formulario-resumen.jsp").forward(request,
			// response);
			request.setAttribute("name", nombre);
			request.setAttribute("surname", apellido);
			request.setAttribute("age", edad);
			request.setAttribute("Studies", estudios);
			request.setAttribute("gender", genero);
			request.setAttribute("hours", horario);
			request.setAttribute("comment", comentario);
			request.setAttribute("photo", foto);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("mensaje", "Lo sentimos pero tenemos un ERROR " + e.getMessage());

		} finally {

			// Send all back to the view

			if (validationes.isEmpty()) {
				request.getRequestDispatcher("formulario-resumen.jsp").forward(request, response);

			} else {

				request.setAttribute("validationes", validationes);
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
			}

		} // finally
	}
}
