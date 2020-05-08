package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.ejercicios.bbdd.modelo.ConnectionManager;

public class RolDAOImpl implements RolDAO {
	
	private static RolDAOImpl INSTANCE = null;

	private RolDAOImpl() {
		super();
	}

	public static synchronized RolDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RolDAOImpl();
		}

		return INSTANCE;
	}
	// executequery=>ResultSet
		private final String SQL_GET_ALL = " SELECT id, nombre FROM rol ORDER BY id DESC;";
		private final String SQL_GET_BY_ID = " SELECT id, nombre FROM rol WHERE id=?; ";
		

		// executeUpdate=> int numero de filas afectadas

		private final String SQL_INSERT = " INSERT INTO rol (nombre) VALUES  ?; ";
		private final String SQL_DELETE = "DELETE FROM rol WHERE id=?;";
		private final String SQL_UPDATE = "UPDATE rol SET nombre=? WHERE id=?; ";

	@Override
	public ArrayList<Rol> getAll() throws Exception {
		ArrayList<Rol> registros = new ArrayList<Rol>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();

		) {
			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Rol r = new Rol(nombre);
				r.setId(id);

				registros.add(r);

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

		return registros;
	}
		
	@Override
	public Rol getById(int id) throws Exception {
		
		Rol registro = new Rol();
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
	public Rol delete(int id) throws Exception {
		Rol registro = new Rol();
		// LISTAMOS EL ROL ANTES DE ELIMINARLO.
		registro = getById(id);

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);

		) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				System.out.println("El nombre del rol  ha sido eliminado");
			} else {
				throw new Exception("No ha sido posible eliminar el registro numero " + id);
			}
		}

		return registro;
	}

	@Override
	public Rol insert(Rol p) throws Exception {
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, com.mysql.jdbc.PreparedStatement.RETURN_GENERATED_KEYS);

		) {
		pst.setString(1, p.getNombre());
			int affectedRows = pst.executeUpdate();
			// affedetedRows es el numero de registros insertados
			if (affectedRows == 1) {
				System.out.println("El producto se ha guardado con exito");
				// continuar = false;
			} else {
				throw new Exception("No se ha podido guardar");
			}
		}

		return p;
	}

	@Override
	public Rol update(Rol pojo) throws Exception {

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


}
