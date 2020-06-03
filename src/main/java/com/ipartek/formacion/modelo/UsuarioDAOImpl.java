package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

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
	private final String SQL_EXISTE = "SELECT id, nombre, contrasenia,id_rol FROM usuario WHERE nombre = ? AND contrasenia = ?; ";
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
		Usuario registro = new Usuario();
		// LISTAMOS EL PRODUCTO ANTES DE ELIMINARLO.
		registro = getById(id);

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);

		) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				System.out.println("El Usuario  ha sido eliminado");
			} else {
				throw new Exception("No ha sido posible eliminar el registro numero " + id);
			}
		}

		return registro;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT,
						com.mysql.jdbc.PreparedStatement.RETURN_GENERATED_KEYS);

		) {
			pst.setString(1, pojo.getNombre());
			int affectedRows = pst.executeUpdate();
			// affedetedRows es el numero de registros insertados
			if (affectedRows == 1) {
				System.out.println("El producto se ha guardado con exito");
				// continuar = false;
			} else {
				throw new Exception("No se ha podido guardar");
			}

		}

		return pojo;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {
		if (pojo == null) {
			throw new Exception("No se puede modificar.Valor NULL");
		}

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);

		) {
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("no se puede modificar el registro " + pojo.getId());
			}
		} catch (Exception e) {
			throw new Exception(" El nombre" + pojo.getNombre() + " del producto ya existe");
		}

		return pojo;

	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {

		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);
				ResultSet rs = pst.executeQuery();) {

			pst.setString(1, "%" + palabraBuscada + "%");

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

	@Override
	public Usuario existe(String nombre, String password) {

		Usuario registro = null;

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);

		) {

			pst.setString(1, nombre);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				registro = new Usuario();
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));

			}

		} catch (

		Exception e) {
			e.printStackTrace();

		}
		return registro;
	}

}