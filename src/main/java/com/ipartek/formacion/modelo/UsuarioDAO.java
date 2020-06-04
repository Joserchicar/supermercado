package com.ipartek.formacion.modelo;

import java.util.ArrayList;

import com.ipartek.formacion.bbdd.CrudAble;

public interface UsuarioDAO extends CrudAble<Usuario>{

	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Alumno>
	 * 
	 * Ej: si palabraBuscada = "a"   <br>
	 *     lista [ "ander", "pepe", "manolo"] <br>
	 *     retorna ["ander","manolo"] <br>
	 *     
	 *  SQL = SELECT id, nombre FROM alumno WHERE nombre LIKE '%a%' ORDER BY nopmbre ASC;   
	 * 
	 */
	ArrayList<Usuario> getAllByNombre( String palabraBuscada );

	
	
	/**
	 * Busca si existe el usuario en la base de datos
	 * @param nombre
	 * @param password
	 * @return Usuario con datos si lo encuentra. Si no existe, retorna null
	 */
	
	
	Usuario existe (String nombre, String password);
		
	
}

