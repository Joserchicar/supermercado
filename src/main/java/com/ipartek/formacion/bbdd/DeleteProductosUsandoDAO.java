package com.ipartek.formacion.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;


//import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
//import com.ipartek.formacion.modelo.ProductoDAO;



/**
 * 
 * 
 * Usamos executeUpdate() siempre que usamos una SQL con (INSERT, DELETE o UPDATE ) y nos retorna "int" con numero de filas afectadas 
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php 
 * @author javaee
 *
 */
public class DeleteProductosUsandoDAO {

	
	
	public static void main(String[] args) throws Exception {
		
		
		ProductoDAO dao=ProductoDAO.getInstance();
	
		System.out.println("Listado de productos");

		System.out.println("--------------------");
		
		
		for (Producto p : dao.getAll()) {
			
			System.out.println(p);
		}
		
		boolean continuar = true; 
		
		ArrayList<Producto>productos= dao.getAll();
		
		try(Scanner sc = new Scanner(System.in);){
	
			do {
				try {
				System.out.println("Dime el numero del producto a Borrar");
				 int id = Integer.parseInt(sc.nextLine());
				 
				Producto producto=new Producto();
		
				producto =dao.delete(id);
				
				continuar=false;	
					
				} catch (Exception e) {
					//System.out.println("Lo sentimos pero elproducto no  existe, dime otro:");
					
				}
				
			} while(continuar);	
				

		} catch (Exception e) {

			System.out.println("Tenemos un problema " + e.getMessage());

		}
		
	
	}

}
