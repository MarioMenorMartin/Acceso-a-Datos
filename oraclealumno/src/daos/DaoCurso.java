package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Curso;

public class DaoCurso {

	// select
	public ArrayList<Curso> getCurso() {
		ResultSet rs;
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String sql = "SELECT curso from curso";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCurso(rs.getString("curso"));

				listaCursos.add(curso);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return listaCursos;
	}

	// insert
	public void insertaCurso(Curso curso) {
		Connection con = Conexion.conecta();
		try {
			String sql;
			sql = "insert into curso values(?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curso.getCurso());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}
	
	//update
	public int actualizaCurso(Curso curso) {
		int actualizados = -1;
		Connection con = Conexion.conecta();
		String sql = "update cruso set curso=? where curso=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curso.getCurso());
			actualizados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos en la BDs: " + e.getMessage());		}
		return actualizados;
	}
	
	// delete
		public int borraCurso(String curso) {
			int borrados = -1;
			Connection con = Conexion.conecta();
			String sql = "delete from curso where curso=?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, curso);
				borrados = st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			}
			return borrados;
		}

	}
