package practica4;

public abstract class Volador {
	
	protected String nombre;

	public Volador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Volador [nombre=" + nombre + "]";
	}
	
	public void solicitudAterrizar() {
		// TODO Auto-generated method stub
		System.out.println("Torre de control, se comunica " + getNombre() + " solicitando pista para aterrizar, cambio y fuera.");
	}
	
}
