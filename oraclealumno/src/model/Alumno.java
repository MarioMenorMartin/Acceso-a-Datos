package model;

import java.util.ArrayList;

public class Alumno {
	private String dni;
	private String nombre;
	private String curso;
	private ArrayList<Telefono> telefonos;
	private ArrayList<Emilio> emails;
	
	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String curso, ArrayList<Telefono> telefonos, ArrayList<Emilio> emails) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
		this.telefonos = telefonos;
		this.emails = emails;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public ArrayList<Emilio> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<Emilio> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", curso=" + curso + ", telefonos=" + telefonos
				+ ", emails=" + emails + "]";
	}
	
}
