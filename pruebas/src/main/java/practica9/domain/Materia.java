package practica9.domain;

public class Materia {

	private Long id;
	private String curso;
	private String turno;
	
	public Materia(Long id, String curso, String turno) {
		this.id = id;
		this.curso = curso;
		this.turno = turno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
}
