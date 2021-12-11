package practica4;

public class Helicoptero extends Volador implements Aterrizable {
	
	private String modelo;
	private String color;
	
	public Helicoptero(String nombre, String modelo, String color) {
		super(nombre);
		this.modelo = modelo;
		this.color = color;
	}
	

	public void aterrizar() {
		// TODO Auto-generated method stub
		System.out.println(getNombre() + " cumple contrato aterrizable, tiene pista disponible para aterrizar.");
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " Helicoptero [modelo=" + modelo + ", color=" + color + "]";
	}
	

}
