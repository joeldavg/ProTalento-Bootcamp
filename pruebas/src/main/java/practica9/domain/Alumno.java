package practica9.domain;

public class Alumno {
	
	private Long matricula;
	private String nombre;
	private String apellido;
	
	public Alumno(Long matricula, String nombre, String apellido) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
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

}
