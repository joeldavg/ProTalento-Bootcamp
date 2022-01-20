package practica9.domain;

public class Materias extends Entity {

	private String curso;
	private String turno;
	
	public Materias(Long id, String curso, String turno) {
		super(id);
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

	@Override
	public String toString() {
		return "Materias [id=" + id + ", curso=" + curso + ", turno=" + turno + "]";
	}
	
}
