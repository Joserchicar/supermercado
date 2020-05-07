package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl INSTANCE = null;

	private UsuarioDAOImpl() {
		super();
	}

	public static synchronized UsuarioDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}

		return INSTANCE;

	}

	// executequery=>ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre FROM usuario ORDER BY id DESC;";
	private final String SQL_GET_BY_ID = " SELECT id, nombre FROM usuario WHERE id=?; ";
	private final String SQL_GET_BY_NOMBRE = "SELECT id, nombre FROM usuario WHERE nombre like ?; ";

	// executeUpdate=> int numero de filas afectadas

	private final String SQL_INSERT = " INSERT INTO usuario (nombre,contrasenia, id_rol) VALUES ( ? , 12345,1) ; ";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id=?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre=? WHERE id=?; ";

	@Override
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();

		) {
			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Usuario u = new Usuario(nombre);
				u.setId(id);

				registros.add(u);

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}

	@Override
	public Usuario getById(int id) throws Exception {

		Usuario registro = new Usuario();
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);

		) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));

			} else {
				throw new Exception("no se encuentra registro con id= " + id);

			}

		}
		return registro;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {

		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);
				ResultSet rs = pst.executeQuery();

		) {
			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Usuario u = new Usuario(nombre);
				u.setNombre(nombre);

				registros.add(u);

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}
	/*
	 * ArrayList<Usuario>usuarios = new ArrayList<Usuario>();
	 * 
	 * try (Connection conexion = ConnectionManager.getConnection();
	 * PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);
	 * 
	 * ) {
	 * 
	 * pst.setString(2, "nombre"); ResultSet rs = pst.executeQuery();
	 * 
	 * 
	 * while (rs.next()) {
	 * 
	 * Usuario u= new Usuario();
	 * 
	 * u.setId(rs.getInt("id")); u.setNombre(rs.getString("nombre"));
	 * 
	 * } //throw new Exception("no se encuentra registro con  nombre= " +
	 * registro.getNombre());
	 * 
	 * 
	 * 
	 * } return usuarios;
	 * 
	 */

}