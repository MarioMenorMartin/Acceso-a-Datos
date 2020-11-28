package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Telefono;

public class DaoTelefono {

	// select
	public ArrayList<Telefono> getTelefonos(String dni) {
		ResultSet rs;
		ArrayList<Telefono> listaTelefonos = new ArrayList<Telefono>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String sql = "SELECT dni, tlf from telefono";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Telefono telefono = new Telefono();
				telefono.setDni(rs.getString("dni"));
				telefono.setTlf(rs.getLong("tlf"));

				listaTelefonos.add(telefono);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return listaTelefonos;
	}

	// insert
	public void insertaTelefono(Telefono telefono) {
		Connection con = Conexion.conecta();
		try {
			String sql;
			sql = "insert into telefono values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, telefono.getDni());
			st.setLong(2, telefono.getTlf());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}

	// update
	public int actualizaTelefono(Telefono telefono) {
		int actualizados = -1;
		Connection con = Conexion.conecta();
		String sql = "update telefono set tlf=? where dni=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, telefono.getTlf());
			st.setString(2, telefono.getDni());
			actualizados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos en la BDs: " + e.getMessage());
		}
		return actualizados;
	}

	// delete
	public int borraTelefono(String dni) {
		int borrados = -1;
		Connection con = Conexion.conecta();
		String sql = "delete from telefono where dni=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, dni);
			borrados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
		}
		return borrados;
	}

}
