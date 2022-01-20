package practica9.domain;

public class Alumnos extends Entity {
	
	private Long matricula;
	private String nombre;
	private String apellido;
	
	/*public Alumnos() {
		
	}*/

	public Alumnos(Long id, Long matricula, String nombre, String apellido) {
		super(id);
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
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

	@Override
	public String toString() {
		return "Alumnos [id=" + id + ", matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	
}
