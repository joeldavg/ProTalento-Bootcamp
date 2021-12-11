package practica4;

public class Avion extends Volador implements Aterrizable {
	
	private String aerolinea;
	private Integer asientos;
	
		
	public Avion(String nombre, String aerolinea, Integer asientos) {
		super(nombre);
		this.aerolinea = aerolinea;
		this.asientos = asientos;
	}
	

	public void aterrizar() {
		// TODO Auto-generated method stub
		System.out.println(getNombre() + " cumple contrato aterrizable, tiene pista disponible para aterrizar.");
	}


	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Integer getasientos() {
		return asientos;
	}

	@Override
	public String toString() {
		return super.toString() + " Avion [aerolinea=" + aerolinea + ", asientos=" + asientos + "]";
	}

}
