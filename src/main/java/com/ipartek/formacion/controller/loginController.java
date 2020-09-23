package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String rol = request.getParameter("rol");

		

		HttpSession session = request.getSession();

		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		Usuario usuario = dao.existe(nombre, pass);

		if (usuario != null) {

			session.setMaxInactiveInterval(60 * 5); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("usuario_login", usuario);

			request.setAttribute("alerta", new Alerta("success", "Ongi Etorri, ya estas Logeado"));
			request.getRequestDispatcher(".jsp").forward(request, response);

		} else {

			request.setAttribute("alerta", new Alerta("warning", "Credenciales Incorrectas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}