package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.Producto;


public class InsertarProducto {

	public static void main(String[] args) {
		
		final String URL="jdbc:mysql://localhost/supermercado";
		final String USUARIO="debian-sys-maint";
		final String PASS ="o8lAkaNtX91xMUcV";
		final String SQL="INSERT INTO producto(nombre,imagen, precio,id_usuario,) VALUES (?,?,?,1);";
		
		
		
		try
		{
			// comprobar que tengamos el . jar de mysql
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("existe el .jar para mysql");
		   // Conectarnos a una BBDD supermercado//
		   Connection conexion = DriverManager.getConnection (URL,USUARIO,PASS);
		   System.out.println("CONEXION CON EXITO");
		   
		   //Realizar una consulta 
		   PreparedStatement pst = conexion.prepareStatement(SQL);
		   //ResultSet rs= pst.executeQuery();
		   
		   
		   System.out.println("Insertar  Productos");
		   System.out.println("--------------------");
		   
		   //TODO pedir el nombre del producto a insertsçar por pantalla por teclado 
		   //cambiamos el 1º ? de la  SQL por "galletitas saladas
		   
		   pst.setString(1,"galletitas saladas");
		   
		   int affectedRows=pst.executeUpdate();
		   // realizar 1 a 1 los resultados hasta que no existan mas registros
		  //affectesRows es el numero de registros insertados
		   System.out.println("numero de registros insertados : "+affectedRows );
		   
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		} 
		
		
		
		
		
	}
	
	
}
