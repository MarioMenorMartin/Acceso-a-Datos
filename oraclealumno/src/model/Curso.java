package model;

public class Curso {
	private String curso;

	public Curso() {
		super();
	}

	public Curso(String curso) {
		super();
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Curso [curso=" + curso + "]";
	}

}
