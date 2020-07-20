package com.ipartek.formacion.UF2176_2_Joserra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UF2176_2_Joserra {

	private final static String URL = "jdbc:mysql://localhost/UF2176_2_Joserra";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";

	public static void main(String[] args) throws SQLException {
	
		Connection con = DriverManager.getConnection(URL, USUARIO, PASS);
	
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("1 listar el primer apellido de los empleados.");
		System.out.println(
				"_____________________________________________________________________________________________");
		
		String sql="SELECT ape1 from empleado ORDER BY ape1 ASC ;";

		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("ape1") );
		}
	
		
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("2 listar el codigo de los departamentos de los empleados que aparecen en la tabla.");
		System.out.println(
				"_____________________________________________________________________________________________");

		
		sql="SELECT codigo,cod_departamento 'codDep' FROM empleado ORDER BY codigo ASC LIMIT 100;"; 
		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("codigo") + " " +rs.getInt("codDep") );

		}
		
		
		
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("3 Lista nombre y apellidos de los empleados en una unica columna");
		System.out.println(
				"_____________________________________________________________________________________________");

		

		sql="SELECT CONCAT( nombre,',  ' ,ape1 ,' ',ape2 ) AS 'nombreCompleto' FROM empleado ORDER BY codigo ASC;";
		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("nombreCompleto")) ;

		}
		
		
	
		
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("4 nombre de los departamnetos y el valor del presupuesto ordenado de forma asc");
		System.out.println(
				"_____________________________________________________________________________________________");

		

		sql="SELECT nombre, presupuesto FROM departamento ORDER BY presupuesto ASC;";	
		
		
		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("nombre") + " " + rs.getDouble("presupuesto")) ;

		}
		
		
		
		System.out.println(
				"_____________________________________________________________________________________________");

		System.out.println("5 lista el nombre de los departamentos ordenados de forma ascendente");
		System.out.println(
				"_____________________________________________________________________________________________");
		
	
		sql="SELECT nombre FROM departamento ORDER BY codigo ASC;";
		
		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("nombre") );

		}
		
		
		
		
		
		System.out.println(
				"________________________________________________________________________________________________");

		System.out.println("6 lista de departamentos y presupuesto, para un presupuesto mayor o igual que 150000€");
		System.out.println(
				"________________________________________________________________________________________________");
		


		sql="SELECT nombre, presupuesto FROM departamento WHERE presupuesto >= 150000 ORDER BY presupuesto ASC;";
		
		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("nombre") + " " + rs.getDouble("presupuesto"));
		}
		
		
	
		System.out.println(
				"________________________________________________________________________________________________");

		System.out.println("7 lista de departamentos y presupuesto, para un presupuesto entre 100000 y 200000 €");
		System.out.println(
				"________________________________________________________________________________________________");
		

	
	

		sql="SELECT nombre, presupuesto FROM departamento WHERE presupuesto >= 100000 && presupuesto <= 200000 ORDER BY presupuesto ASC;";

		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println( rs.getString("nombre") + " " + rs.getDouble("presupuesto"));		}
		
		
		
		
		
		System.out.println(
				"_____________________________________________________________________________________________________________________");

		System.out.println("8 Lista de departamentos, gastos y presupuesto donde los gastos sean menores que el presupuesto que poseen");
		System.out.println(
				"_____________________________________________________________________________________________________________________");
		

		
		 
		sql="SELECT nombre, presupuesto, gasto FROM departamento WHERE gasto< presupuesto  ORDER BY nombre ASC;";

		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("nombre") + " " + rs.getDouble("presupuesto") + " "+ rs.getDouble("gasto"));

		}
		
		
		
		
		
		
		System.out.println(
				"______________________________________________________________________________");

		System.out.println("9 lista nombre apellidos y nif de los empreados del departamento 3 ");
		System.out.println(
				"______________________________________________________________________________");
		

		
		sql="SELECT cod_departamento, nombre, ape1, ape2 FROM empleado WHERE cod_departamento=3 ORDER BY ape1 ASC;";

		
		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("cod_departamento") + " " + rs.getString("nombre") + " " + rs.getString("ape1") + " " +rs.getString("ape2"));
			

		}
		
		
		
		System.out.println(
				"___________________________________________________________________________________________________");

		System.out.println("10 Listado empleados con los datos de los departamentos donde trabaja cada uno de ellos.");
		System.out.println(
				"___________________________________________________________________________________________________");
		

		
		
		sql="SELECT  e.codigo 'codigo',e.nif, e.nombre ,e.ape1 , e.ape2 ,d.nombre 'departamento',d.presupuesto'presupuesto' ,d.gasto 'gasto'" + 
				"FROM empleado e LEFT JOIN departamento d ON e.cod_departamento =d.codigo  ORDER BY e.codigo ASC LIMIT 100;";


		pst = (PreparedStatement) con.prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("codigo") + " " + rs.getString("e.nif") + " " +rs.getString("e.nombre") + " " +rs.getString("e.ape1") + " " +rs.getString("e.ape2")
			+ " " + rs.getString("departamento") + " " +rs.getDouble("presupuesto") + " "+ rs.getDouble("gasto"));

		}
		
		
		
		
	}
}
