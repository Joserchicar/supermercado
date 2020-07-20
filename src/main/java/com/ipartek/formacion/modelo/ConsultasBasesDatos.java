package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasBasesDatos {

	private final static String URL = "jdbc:mysql://localhost/ejerciciosupermercado";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection(URL, USUARIO, PASS);
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("1.- listado de todos los productos");
		System.out.println(
				"_____________________________________________________________________________________________");

		// establecer conexion BBDD

		String sql1 = "SELECT id, nombre, precio FROM producto ORDER BY nombre ASC;";

		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql1);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "" + rs.getString("nombre") + "" + rs.getFloat("precio"));
		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("2 listar  todas las columnas de la tabla producto");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql2 = "select * from producto order by nombre asc; ";

		pst = (PreparedStatement) con.prepareStatement(sql2);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "" + rs.getString("nombre") + "" + rs.getInt("id_usuario") + ""
					+ rs.getFloat("precio") + "" + rs.getString("imagen") + "" + rs.getInt("id_usuario"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println(
				"3 listar los nombres y precios de la tabla productos , convirtiendo los nombres a mayusculas");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql3 = "select UPPER(nombre) AS nombre, precio from producto order by nombre asc;";

		pst = (PreparedStatement) con.prepareStatement(sql3);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio")); // UPPER

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("4 lista nombres y precios redondeando el precio.");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql4 = "select nombre,ROUND (precio,1) AS precio from producto order by nombre asc;";

		pst = (PreparedStatement) con.prepareStatement(sql4);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));// ROUND

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("5_ listar nombre de categorias en la lista de la tabla productos  sin repeticiones ");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql5 = "select DISTINCT id_categoria AS id_Categoria from producto order by id_categoria  DESC ;"; // DISTINCT

		pst = (PreparedStatement) con.prepareStatement(sql5);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id_Categoria"));

		}
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("6- Listar los nombres de las categorias de forma descendente ");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql6 = "select nombre from categoria order by nombre DESC ;";

		pst = (PreparedStatement) con.prepareStatement(sql6);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("7- listado de productos con nombre y ordenado por el precio mas bajo");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql7 = "select nombre, precio from producto order by precio asc;";

		pst = (PreparedStatement) con.prepareStatement(sql7);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("8 - lista productos que tienen un precio mayor o igual a 2.35€");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql8 = "select nombre, precio from producto where precio >=2.35 order by precio asc;";

		pst = (PreparedStatement) con.prepareStatement(sql8);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("9 - Listar todos los productos que su nombre contenga \"patatas\"");
		System.out.println(
				"_____________________________________________________________________________________________");

		String sql9 = "select nombre from producto where nombre like '%patatas%' order by nombre asc;";

		pst = (PreparedStatement) con.prepareStatement(sql9);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre"));

		}

		System.out.println(
				"____________________________________________________________________________________________________________");

		System.out.println(
				"10 - Listar todos los productos que su nombre contenga \"patatas\" y su precio sea superior a 2 €");
		System.out.println(
				"____________________________________________________________________________________________________________");

		String sql10 = "select nombre, precio from producto where nombre like '%patatas%'  AND precio>2 order by nombre asc;";

		pst = (PreparedStatement) con.prepareStatement(sql10);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + "" + rs.getFloat("precio"));

		}

	}
}
