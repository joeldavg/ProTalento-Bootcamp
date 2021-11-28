package clase6.oop;

public class BuscadorMain {

	public static void main(String[] args) {
		
		// simila que estoy en www.mercadolibre.com.co
		
		Buscador buscador = new Buscador();
		
		String claveDeBusqueda = "Iron man";
		
		buscador.definirClaveBusqueda(claveDeBusqueda);
		
		buscador.buscar();
		
		buscador.mostrarResultados();	
		
	}

}
