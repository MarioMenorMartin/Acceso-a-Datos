package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Emilio;

public class DaoEmilio {

	// select
	public ArrayList<Emilio> getEmail(String dni) {
		ResultSet rs;
		ArrayList<Emilio> listaEmails = new ArrayList<Emilio>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String sql = "SELECT dni, email from emilio";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Emilio email = new Emilio();
				email.setDni(rs.getString("dni"));
				email.setEmail(rs.getString("email"));

				listaEmails.add(email);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return listaEmails;
	}

	// insert
	public void insertaEmail(Emilio email) {
		Connection con = Conexion.conecta();
		try {
			String sql;
			sql = "insert into emilio values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email.getDni());
			st.setString(2, email.getEmail());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}

	// update
	public int actualizaEmail(Emilio email) {
		int actualizados = -1;
		Connection con = Conexion.conecta();
		String sql = "update emilio set email=? where dni=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email.getEmail());
			st.setString(2, email.getDni());
			actualizados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos en la BDs: " + e.getMessage());
		}
		return actualizados;
	}

	// delete
	public int borraEmail(String dni) {
		int borrados = -1;
		Connection con = Conexion.conecta();
		String sql = "delete from emilio where dni=?";
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
