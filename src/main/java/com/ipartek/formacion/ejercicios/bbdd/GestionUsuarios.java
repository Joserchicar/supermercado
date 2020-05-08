package com.ipartek.formacion.ejercicios.bbdd;

import java.lang.invoke.SwitchPoint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
import com.ipartek.formacion.modelo.RolDAOImpl;
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

	static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	static boolean continuar = false;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
	try(Scanner sc=new Scanner(System.in)) {
		
	int option;
	
	boolean salir=false;
	while (!salir) {
		
		System.out.println("    MENU SELECCIÓN   ");
		System.out.println("*********************");
		System.out.println("1.- LISTAR TODOS     ");
		System.out.println("2.- BUSCAR POR ID    ");
		System.out.println("3.- BUSCAR POR NOMBRE");
		System.out.println("4.- INSERTAR         ");
		System.out.println("5.- MODIFICAR        ");
		System.out.println("6.- BORRAR           ");
		System.out.println("7.- SALIR            ");
		System.out.println("*********************");
		System.out.println("  ");
		System.out.println("selecciona la opción:");
		
		option=sc.nextInt();
	}
	
	do {
		
		System.out.println("Por favor digite el numero de la accion que desea realizar");
		int opcion = Integer.parseInt(sc.nextLine());
		
		
		switch (option) {
		case 1:
			ArrayList<Usuario> usuarios=dao.getAll();
			
			System.out.println("listado de Usuarios");
			System.out.println("*******************");
			
			for (Usuario u : usuarios) {
				 System.out.println(u);
			}
			break;
			
		case 2:
			System.out.println("Listado de usuarios por ID");
			System.out.println("**************************");
			
			for (Usuario  u :dao.getAll()) {
				
				System.out.println(u);	
			}
			break;
				
		case 3:
			String palabraBuscada = sc.nextLine();
			
			usuarios =dao.getAllByNombre("%"+palabraBuscada+"%");
			
			System.out.println("listado de Usuarios por nombre");
			System.out.println("******************************");
				
				for (Usuario usuario : usuarios) {
					
					System.out.println(usuario);
				}			
			break;
					
		case 4:
			try {
				boolean continuar = true;
			 usuarios = dao.getAll();
				do {
					try {
						System.out.println("Dime el nombre del usuario a insertar");
						String nombre = sc.nextLine();
						Usuario u = new Usuario();

						u = dao.insert(u);

						  continuar = false;

					} catch (Exception e) {
						System.out.println("Lo sentimos pero el usuario ya existe, dime otro:");
					}

				} while (continuar);

			} catch (Exception e) {

				System.out.println("Tenemos un problema " + e.getMessage());
			}

		}
					
			break;
						
		case 5:
							
			break;
							
		case 6:
								
			break;
								
		case 7:
									
			break;

		default:
			break;
		}

	private static void Listar() {
		ArrayList<Usuario> usuarios = dao.getAll();

		System.out.println("listado de Usuarios");
		System.out.println("*******************");

		for (Usuario u : usuarios) {
			System.out.println(u);
		}
	}

	private static void BuscarPorId() {
		System.out.println("Listado de usuarios por ID");
		System.out.println("**************************");
		
		for (Usuario  u :dao.getAll()) {
			
			System.out.println(u);	
		}
	}
	
	private static void BuscarPorNombre()
	
	
	/**
	 * switch (option) {
	 * 
	 * 
	 * case 2: System.out.println("Listado de usuarios por ID");
	 * System.out.println("**************************");
	 * 
	 * for (Usuario u :dao.getAll()) {
	 * 
	 * System.out.println(u); } break; case 3: String palabraBuscada =
	 * sc.nextLine();
	 * 
	 * usuarios =dao.getAllByNombre("%"+palabraBuscada+"%");
	 * 
	 * System.out.println("listado de Usuarios por nombre");
	 * System.out.println("******************************");
	 * 
	 * for (Usuario usuario : usuarios) {
	 * 
	 * System.out.println(usuario); } break; case 4: try { boolean continuar = true;
	 * usuarios = dao.getAll(); do { try { System.out.println("Dime el nombre del
	 * usuario a insertar"); String nombre = sc.nextLine(); Usuario u = new
	 * Usuario();
	 * 
	 * u = dao.insert(u);
	 * 
	 * continuar = false;
	 * 
	 * } catch (Exception e) { System.out.println("Lo sentimos pero el usuario ya
	 * existe, dime otro:"); }
	 * 
	 * } while (continuar);
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("Tenemos un problema " + e.getMessage()); }
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * 
	 * default:
	 * 
	 * break; }
	 * 
	 * /** switch (opcion) { case 1: ArrayList<Usuario> usuarios=dao.getAll();
	 * 
	 * System.out.println("listado de Usuarios");
	 * System.out.println("*******************");
	 * 
	 * for (Usuario u : usuarios) { System.out.println(u); }
	 * 
	 * break; case 2:
	 * 
	 * System.out.println("Listado de usuarios por ID");
	 * System.out.println("**************************");
	 * 
	 * for (Usuario u :dao.getAll()) {
	 * 
	 * System.out.println(u);
	 * 
	 * } break;
	 * 
	 * case 3:
	 * 
	 * String palabraBuscada = sc.nextLine();
	 * 
	 * ArrayList<Usuario>usuarios =dao.getAllByNombre("%"+palabraBuscada+"%");
	 * 
	 * System.out.println("listado de Usuarios por nombre");
	 * System.out.println("******************************");
	 * 
	 * for (Usuario usuario : usuarios) {
	 * 
	 * System.out.println(usuario); }
	 * 
	 * break;
	 * 
	 * case 4:
	 * 
	 * try { boolean continuar = true; ArrayList<Usuario> usuarios = dao.getAll();
	 * do { try { System.out.println("Dime el nombre del usuario a insertar");
	 * String nombre = sc.nextLine(); Usuario u = new Usuario();
	 * 
	 * u = dao.insert(u);
	 * 
	 * continuar = false;
	 * 
	 * } catch (Exception e) { System.out.println("Lo sentimos pero el usuario ya
	 * existe, dime otro:"); }
	 * 
	 * } while (continuar);
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("Tenemos un problema " + e.getMessage()); }
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * case 5:
	 * 
	 * System.out.println("Listado de Usuarios");
	 * System.out.println("----------------------------------------");
	 * 
	 * for (Usuario u : dao.getAll()) { System.out.println(u); }
	 * 
	 * try { System.out.println("Dime el id para modificar el producto"); int id =
	 * Integer.parseInt(sc.nextLine());
	 * 
	 * System.out.println("Dime el nuevo nombre del producto"); String nombre =
	 * sc.nextLine();
	 * 
	 * Usuario u = new Usuario(); u.setId(id); u.setNombre(nombre);
	 * 
	 * dao.update(u); System.out.println("Tu lista se ha modificado con exito");
	 * 
	 * } catch (SQLException e) { System.out.println("Nombre duplicado");
	 * 
	 * } catch (Exception e) { System.out.println("persona no encontrada"); }
	 * 
	 * continuar = true;
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * case 6:
	 * 
	 * System.out.println("Listado de productos");
	 * 
	 * System.out.println("--------------------");
	 * 
	 * 
	 * for (Producto p : dao.getAll()) {
	 * 
	 * System.out.println(p); }
	 * 
	 * boolean continuar = true;
	 * 
	 * ArrayList<Usuario>usuarios= dao.getAll();
	 * 
	 * try{
	 * 
	 * do { try { System.out.println("Dime el numero del producto a Borrar"); int id
	 * = Integer.parseInt(sc.nextLine());
	 * 
	 * Usuario usuario=new Usuario();
	 * 
	 * UsuarioDAO=dao.delete(id);
	 * 
	 * continuar=false;
	 * 
	 * } catch (Exception e) { System.out.println("Lo sentimos pero elproducto no
	 * existe, dime otro:");
	 * 
	 * }
	 * 
	 * } while(continuar);
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("Tenemos un problema " + e.getMessage());
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * 
	 * case 7: System.out.println("Cerrar el programa");
	 * System.out.println("---------------------------------------------");
	 * 
	 * System.out.println("Hasta Pronto!!!");
	 * 
	 * continuar = false; break;
	 * 
	 * 
	 * default: break; }
	 * 
	 * while(continuar);
	 **/
	}catch(

	Exception e)
	{
		System.out.println(e.getMessage());
	}

}
