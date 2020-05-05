package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.bbdd.CrudAble;
import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;


public class ProductoDAO implements CrudAble<Producto>  {

	
private static ProductoDAO INSTANCE = null;
	
	private ProductoDAO() {
		super();	
	}
		
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
	}
	
//executequery=>ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre FROM producto ORDER BY id DESC;";
	private final String SQL_GET_BY_ID= " SELECT id, nombre FROM producto WHERE id=?; ";
	
	//executeUpdate=> int numero de filas afectadas
	
	private final String SQL_INSERT= " INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ; ";
	private final String SQL_DELETE="DELETE FROM producto WHERE id=?;";
	private final String SQL_UPDATE="UPDATE producto SET nombre=? WHERE id=?; ";
	
	 
	@Override
	public ArrayList<Producto> getAll() throws Exception {
		
		ArrayList<Producto> registros=new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
								
				registros.add(p);			
				
			} // while
			
			
			
		} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		
		return registros;
	}

	@Override
	public Producto getById(int id) throws Exception {
		Producto registro=new Producto();
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				
			) {
		
			pst.setInt(1, id);
			ResultSet rs= pst.executeQuery();
			
			if (rs.next()) {
				
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
				
			} else {
				throw new Exception ("no se encuentra registro con id= " +id); 

			}
			
		}
		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {
		Producto registro=new Producto();
		// LISTAMOS EL PRODUCTO ANTES DE ELIMINARLO.
		registro=getById(id);
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);
				
			){
			pst.setInt(1,id);
			int affectedRows=pst.executeUpdate();
			if (affectedRows==1) {
				System.out.println("El Producto ha sido eliminado");
			}else {
				throw new Exception("No ha sido posible eliminar el registro numero "+id);
			}
		}
		
			
		
		return registro;
	}

	@Override
	public Producto insert(Producto p) throws Exception {
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT);
				
			){
			pst.setString(1, p.getNombre());
			int affectedRows = pst.executeUpdate();
		// affedetedRows es el numero de registros insertados
		if (affectedRows == 1) {
			System.out.println("El producto se ha guardado con exito");
			//continuar = false;
		}else {
			throw new Exception("No se ha podido guardar");
		}
		
		}
		
		
		return p;
	}

	@Override
	public Producto update(Producto p) throws Exception {
		if (p==null) {
			throw new Exception("No se puede modificar.Valor NULL");
		}
		
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);
				
			){
			pst.setString(1,p.getNombre());
			pst.setInt(2, p.getId());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows!= 1) {
				throw new Exception("no se puede modificar el registro "+ p.getId());
			}
		}catch (Exception e) {
				throw new Exception(" El nombre"+p.getNombre() + " del producto ya existe");
		}
		
		return p;
	}

	

}
