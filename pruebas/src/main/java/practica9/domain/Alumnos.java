package practica9.domain;

public class Alumnos extends Entity {
	
	private Long matricula;
	private String nombre;
	private String apellido;
	private Long cursoId;
	
	/*public Alumnos() {
		
	}*/

	public Alumnos(Long id, Long matricula, String nombre, String apellido, Long cursoId) {
		super(id);
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.setCursoId(cursoId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getCursoId() {
		return cursoId;
	}
	
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	@Override
	public String toString() {
		return "Alumnos [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", cursoId="
				+ cursoId + "]";
	}
	
}
