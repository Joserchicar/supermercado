package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl INSTANCE = null;

	// executequery=>ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre, contrasenia, id_rol  FROM usuario ORDER BY id DESC;";
	private final String SQL_GET_BY_ID = " SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE id=?; ";
	private final String SQL_GET_BY_NOMBRE = "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre like ?; ";
	private final String SQL_EXISTE = "SELECT id, nombre, contrasenia,id_rol FROM usuario WHERE nombre = ? AND contrasenia = ?; ";
	// executeUpdate=> int numero de filas afectadas

	private final String SQL_INSERT = " INSERT INTO usuario (nombre,contrasenia, id_rol) VALUES ( ? , 12345,1) ; ";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id=?;";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre=? WHERE id=?; ";

	private UsuarioDAOImpl() {
		super();
	}

	public static synchronized UsuarioDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}

		return INSTANCE;
	}

	@Override
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			System.out.println("SQL= " + pst);

			while (rs.next()) {				
				usuarios.add( mapper(rs) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario getById(int id) throws Exception {

		Usuario usuario = new Usuario();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);

		) {

			pst.setInt(1, id);

			System.out.println("SQL= " + pst);

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = mapper(rs);
				} else {
					throw new Exception("Usuario no encontrado id = " + id);
				}

			} // 2º try

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public Usuario delete(int id) throws Exception {

		Usuario usuario = getById(id);

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			if (pst.executeUpdate() != 1) {
				throw new Exception("No se puede eliminar registro " + id);
			}

		}

		return usuario;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						pojo.setId(rsKeys.getInt(1));
					}
				}

			} else {
				throw new Exception("No se puede insertar registro " + pojo);
			}

		}

		return pojo;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());

			if (pst.executeUpdate() != 1) {
				throw new Exception("No se puede modificar registro " + pojo);
			}

		}

		return pojo;
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {

		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);) {

			pst.setString(1, "%" + palabraBuscada + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					registros.add( mapper(rs) );
				} // while

			} // 2º try

		} catch (Exception e) {

			e.printStackTrace();
		}

		return registros;
	}

	@Override
	public Usuario existe(String nombre, String password) {

		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);

		) {

			pst.setString(1 , nombre);
			pst.setString(2 , password);

			System.out.println("SQL= " + pst);

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = mapper(rs);
				} 

			} // 2º try

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	
	private Usuario mapper( ResultSet rs ) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasenia( rs.getString("contrasenia"));
		usuario.setIdRol( rs.getInt("id_rol"));
		
		return usuario;
		
	}

}