package practica4;

public class Avion extends Volador implements Aterrizable {
	
	private String aerolinea;
	private Integer cantidadPasajeros;
	
		
	public Avion(String aerolinea, Integer cantidadPasajeros) {
		super();
		this.aerolinea = aerolinea;
		this.cantidadPasajeros = cantidadPasajeros;
	}


	public void aterizar() {
		// TODO Auto-generated method stub
		System.out.println();
	}


	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Integer getCantidadPasajeros() {
		return cantidadPasajeros;
	}

	public void setCantidadPasajeros(Integer cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}


}
