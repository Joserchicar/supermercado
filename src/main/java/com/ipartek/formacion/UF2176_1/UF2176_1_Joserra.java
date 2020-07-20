package com.ipartek.formacion.UF2176_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UF2176_1_Joserra {
	
	private final static String URL = "jdbc:mysql://localhost/UF2176_act1_Joserra";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";

	public static void main(String[] args) throws SQLException {
	
		Connection con = DriverManager.getConnection(URL, USUARIO, PASS);
		
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("1.- listado de todos los productos");
		System.out.println(
				"_____________________________________________________________________________________________");
		
		

		String sql = "SELECT id, nombre, precio,cod_fabricante FROM producto ORDER BY nombre ASC;";

		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "" + rs.getString("nombre") + "" + rs.getFloat("precio")+""+rs.getInt("cod_fabricante"));
		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("2 listar  todas las columnas de la tabla producto");
		System.out.println(
				"_____________________________________________________________________________________________");

		 sql = "SELECT * FROM producto ORDER BY nombre ASC; ";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "" + rs.getString("nombre") + "" + rs.getFloat("precio") + ""+ rs.getString("descripcion") +""+ rs.getInt("cod_Fabricante"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println(
				"3 listar los nombres y precios de la tabla productos , convirtiendo los nombres a mayusculas");
		System.out.println(
				"_____________________________________________________________________________________________");

		 sql = "SELECT UPPER(nombre) AS nombre, precio FROM producto ORDER BY nombre ASC;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio")); 

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("4 lista nombres y precios redondeando el precio.");
		System.out.println(
				"_____________________________________________________________________________________________");

		sql = "SELECT nombre,ROUND (precio,2) AS precio FROM producto ORDER BY nombre ASC;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("5_ listar codigo de los fabricantes que tienen productos en la tabla productos  ");
		System.out.println(
				"_____________________________________________________________________________________________");

		 sql = "SELECT DISTINCT cod_fabricante 'codFabricante' FROM producto ORDER BY cod_fabricante  DESC ;"; 

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("cod_fabricante"));

		}
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("6- Listar los nombres de los fabricantes de forma descendente ");
		System.out.println(
				"_____________________________________________________________________________________________");

		sql = "SELECT nombre FROM fabricantes ORDER BY nombre DESC ;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("7- listado de productos con nombre y ordenado por el precio mas bajo");
		System.out.println(
				"_____________________________________________________________________________________________");

		 sql = "SELECT nombre, precio FROM producto ORDER BY precio ASC;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("8 - lista productos que tienen un precio mayor o igual a 400€");
		System.out.println(
				"_____________________________________________________________________________________________");

		sql = "SELECT nombre, precio FROM producto WHERE precio >=400 ORDER BY precio asc;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("9 - Listar todos los productos que su nombre contenga ' portatil'");
		System.out.println(
				"_____________________________________________________________________________________________");

		 sql = "SELECT nombre FROM producto WHERE nombre like '%portatil%' ORDER BY nombre ASC;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre"));

		}

		System.out.println(
				"____________________________________________________________________________________________________________");

		System.out.println(
				"10 - Listar todos los productos que su nombre contenga 'monitor' y su precio sea inferior a 215 €");
		System.out.println(
				"____________________________________________________________________________________________________________");

		 sql = "SELECT nombre, precio FROM producto WHERE nombre like '%monitor%'  AND precio < 215 ORDER BY nombre ASC;";

		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

	}
		
		
		
	}


