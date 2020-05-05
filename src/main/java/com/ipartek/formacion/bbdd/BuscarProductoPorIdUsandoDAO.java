package com.ipartek.formacion.bbdd;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

public class BuscarProductoPorIdUsandoDAO
{

	public static void main(String[] args) throws Exception {
		
		ProductoDAO dao=ProductoDAO.getInstance();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------");
		
		for (Producto p :dao.getAll()) {
			
			System.out.println(p);
			
		}
		try(Scanner sc= new Scanner(System.in)) {
			System.out.println("introduce la id del producto que buscas");
			
			int id=Integer.parseInt(sc.nextLine());
			Producto p = dao.getById(id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

}