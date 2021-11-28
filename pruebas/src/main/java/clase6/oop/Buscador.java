package clase6.oop;

public class Buscador {
	
	String claveBusqueda;
	Articulo[] resultados;
	
	//constructor no recibe parametros
	Buscador(){
		
	}
	
	void buscar() {
		
		// simular que esta buscando
		System.out.println("Buscando... " + this.claveBusqueda);
		
		// como mi buscador necesita usar un objeto de la clase DB
		// debe instanciar un objeto de dicha clase
		
		DB db = new DB();
		
		this.resultados = db.consultar(claveBusqueda);
	}
	
	void definirClaveBusqueda(String clave) {
		this.claveBusqueda = clave;
	}
	
	void mostrarResultados() {
		if (this.resultados.length > 0) {
			for (Articulo aux : this.resultados) {
				aux.detalleArticulo();
			}
		}
		else {
			System.out.println("NO hay resultados para: " + this.claveBusqueda);
		}
	}
	
}
