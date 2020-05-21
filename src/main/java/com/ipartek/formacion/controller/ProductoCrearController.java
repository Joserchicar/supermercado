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
     * @see HttpServlet#HttpServlet()
     */
    public ProductoCrearController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger los valores del formulario
		
		
		String nombre=request.getParameter("nombre");
		Producto producto=new Producto();
		String mensaje="";
		ProductoDAO dao = ProductoDAO.getInstance();
		
		producto.setNombre(nombre);
		
		
		try {
		mensaje=" El producto se ha insertado correctamente";
		
			doGet(request, response);
		}catch(Exception e){  
			
			mensaje=" El producto no se ha insertado. se ha producido el error "+ e.getMessage();
			
			e.printStackTrace();
		}
		
		//insertar mensaje en la vista
		
		request.setAttribute("mensaje", mensaje);
		
		// ir a la nueva vista o jsp
				request.getRequestDispatcher("formulario-producto").forward(request, response);	
		}
		
	}


