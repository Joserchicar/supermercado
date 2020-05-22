package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto-crear")
public class ProductoCrearController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		try {
			String parametroId = request.getParameter("id");
			Producto producto = new Producto();

			if (parametroId != null) {

				int id = Integer.parseInt(parametroId);
				ProductoDAO dao = ProductoDAO.getInstance();
				producto = dao.getById(id);
			}

			request.setAttribute("producto", producto);

		} catch (Exception e) {
			mensaje = "Lo sentimos fallo en GET " + e.getMessage();
			e.printStackTrace();

		} finally {

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensaje = "";
		Producto producto = new Producto();

		try {
			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			int id = Integer.parseInt(idParametro);

			ProductoDAO dao = ProductoDAO.getInstance();

			producto.setId(id);
			producto.setNombre(nombre);

			if (id == 0) {
				dao.insert(producto);

			} else {
				dao.update(producto);
			}

			mensaje = "Producto guardado";

		} catch (Exception e) {
			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();

		} finally {
			// enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("producto", producto);

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);

		}

	}

}