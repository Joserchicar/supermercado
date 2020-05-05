package com.ipartek.formacion.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

//import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * 
 * 
 * Usamos executeUpdate() siempre que usamos una SQL con (INSERT, DELETE o
 * UPDATE ) y nos retorna "int" con numero de filas afectadas
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class UpdateProductosUsandoDAO {

	public static void main(String[] args) throws Exception {

		ProductoDAO dao = ProductoDAO.getInstance();

		System.out.println("Listado de productos");

		System.out.println("--------------------");

		for (Producto p : dao.getAll()) {

			System.out.println(p);
		}

		try (Scanner sc = new Scanner(System.in);) {

			System.out.println("Dime el ID del producto a modificar");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println("Dime el nombre del nuevo  producto ");
			String nombre = sc.nextLine();

			Producto p = new Producto();
			p.setId(id);
			p.setNombre(nombre);
			p = dao.update(p);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
