package clase6.oop;

public class Buscador {
	
	//atributos 
	//modificadores
	
	private String claveBusqueda;
	private Articulo[] resultados;
	private Integer cantidadResultados;
	
	// public Integer unAtributo;   // NO SE HACE!!!
	
	//constructor no recibe parametros
	public Buscador(){
		System.out.println("Creando buscador...");
	}
	
	public void buscar() {
		
		// simular que esta buscando
		System.out.println("Buscando... " + this.claveBusqueda);
		
		// como mi buscador necesita usar un objeto de la clase DB
		// debe instanciar un objeto de dicha clase
		
		DB db = new DB();
		
		this.resultados = db.consultar(claveBusqueda);
		
		//invocamos a un metodo  interno (privado) pasando el tamaño del vector como parametro
		
		this.setCantidadResultados(this.resultados.length);
		
	}
	
	private void setCantidadResultados(Integer cantidadResultados) {
		if (cantidadResultados < 0) {
			this.cantidadResultados = 0;
		}else {

			this.cantidadResultados = cantidadResultados;
		}
	}
	
	public Integer getCantidadResultados() {
		if (this.cantidadResultados == null) {
			this.setCantidadResultados(0);
		}
		
		return cantidadResultados;
	}
	
	/*
	void definirClaveBusqueda(String clave) {
		this.claveBusqueda = clave;
	}
	*/
	
	
	

	public void mostrarResultados() {
		if (this.resultados.length > 0) {
			for (Articulo aux : this.resultados) {
				aux.detalleArticulo();
			}
		}
		else {
			System.out.println("NO hay resultados para: " + this.claveBusqueda);
		}
	}

	

	public String getClaveBusqueda() {
		return this.claveBusqueda;
	}

	public void setClaveBusqueda(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}

	public Articulo[] getResultados() {
		return this.resultados;
	}
	
}
