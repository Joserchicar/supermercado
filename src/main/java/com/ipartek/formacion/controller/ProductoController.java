package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/productos")
public class ProductoController extends HttpServlet {
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
		
		//llamar a la base datos para conseguir los productos
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		ArrayList<Producto> producto = null;
		try {
			producto = dao.getAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		// datos para enviar a la vista
		request.setAttribute("productos",producto);
		
		// ir a la nueva vista o jsp
		request.getRequestDispatcher("producto.jsp").forward(request, response);
		
	}

}
