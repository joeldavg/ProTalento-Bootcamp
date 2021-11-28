package clase6.oop;

public class DB {
	
	// no tiene atributos
	// no tiene constructor
	
	// solo tien un metodo
	
	Articulo[] consultar(String claveConsultada) {
		
		//simular datos
		
		Articulo res1 = new Articulo("Figura de marvel", 35940, "http://imagen.jpg", true, 10, true);
		Articulo res2 = new Articulo("Figura de Accion", 34930, "http://otraimagen.jpg", true, 2, false);
		
		
		Articulo[] resultados = new Articulo[] {res1, res2};  // length 2, pos 0 y 1
		
		return resultados;
		
	}
	
}
