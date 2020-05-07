package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Poder ver todos los usuarios, crear nuevos, eliminar, editar y buscar por
 * nombre
 * 
 * @author Jose Ramon Chica Ramirez
 *
 */
public class GestionUsuarios {

	public static void main(String[] args) {
		
	try(Scanner sc=new Scanner(System.in)) {

	int option;
	boolean salir=false;
	while (!salir) {
		
		System.out.println("    MENU SELECCIÓN   ");
		System.out.println("*********************");
		System.out.println("1.- BUSCAR TODOS     ");
		System.out.println("2.- BUSCAR POR ID    ");
		System.out.println("3.- BUSCAR POR NOMBRE");
		System.out.println("2.- INSERTAR         ");
		System.out.println("3.- MODIFICAR        ");
		System.out.println("4.- BORRAR           ");
		System.out.println("5.- SALIR            ");
		System.out.println("*********************");
		System.out.println("  ");
		System.out.println("selecciona la opción:");
		
		option=sc.nextInt();
	}
		
	
		
switch (option) {
	
	
case 1:
	UsuarioDAOImpl dao=UsuarioDAOImpl.getInstance();
	ArrayList<Usuario> usuarios=dao.getAll();
	
	System.out.println("listado de Usuarios");
	System.out.println("*******************");
	
	for (Usuario u : usuarios) {
		 System.out.println(u);
	}
		 
	break;
	
	case 2 :
		
		UsuarioDAOImpl  dao2=UsuarioDAOImpl.getInstance();
		
		System.out.println("Listado de usuarios por ID");
		System.out.println("**************************");
		
		for (Usuario  u :dao2.getAll()) {
			
			System.out.println(u);
			
		}
		
			System.out.println("introduce la id del usuario que buscas");	
			int id=Integer.parseInt(sc.nextLine());
			Usuario u = dao2.getById(id);
			
		}
			 	 
		break;

		default
	System.out.println("Solo numeros del 1 al 5");
	break;		
		
	
	
	}catch(

	Exception e)
	{
		System.out.println(e.getMessage());

	}
}
}