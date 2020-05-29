package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto")
public class ProductoCrearController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alerta alerta = new Alerta();
		try {
			String parametroId = request.getParameter("id");
			Producto producto = new Producto();

			if (parametroId != null) {

				int id = Integer.parseInt(parametroId);
				ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
				producto = dao.getById(id);
			}

			request.setAttribute("producto", producto);

		} catch (Exception e) {
			alerta = new Alerta ("danger","Lo sentimos fallo en GET " + e.getMessage());
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

		 Alerta alerta =new Alerta(); 
		Producto producto = new Producto();

		try {
			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String imagen = request.getParameter("imagen");
			
			int id = Integer.parseInt(idParametro);
			float preciofloat= Float.parseFloat("precio");

			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

			producto.setId(id);
			producto.setNombre(nombre);
			producto.setImagen(imagen);
			producto.setPrecio(preciofloat);

			if (id == 0) {
				dao.insert(producto);

			} else {
				dao.update(producto);
			}

			alerta= new Alerta ("success", "Producto guardado");

		} catch (Exception e) {
			alerta = new Alerta("danger","Lo sentimos pero hemos tenido una Excepcion " + e.getMessage());
			e.printStackTrace();

		} finally {
			// enviar datos a la vista
			request.setAttribute("alerta", alerta);
			request.setAttribute("producto", producto);

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);

		}

	}// dopost

}