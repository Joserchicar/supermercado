package com.ipartek.formacion.bbdd;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.Producto;

public class ListaProductoUsandoDAO
{

	public static void main(String[] args) throws Exception {
		ProductoDAO dao=new ProductoDAO();
		ArrayList<Producto>productos= dao.getAll();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------------------------");
		
		for (Producto p : productos) {
			
			System.out.println(p);
			
		}
		
		
		
		
	}

}