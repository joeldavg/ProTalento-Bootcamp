package practica4;

public class Ovni extends Volador {
	
	private String forma;
	private String color;
	
	public Ovni(String nombre, String forma, String color) {
		super(nombre);
		this.forma = forma;
		this.color = color;
	}
	

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " Ovni [forma=" + forma + ", color=" + color + "]";
	}
	
	

}
