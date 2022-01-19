package collections.list;

import java.util.List;

public class buscadorListMain {
	
	public static void main(String[] args) {
		
		String clave = "iron man";
		
		Buscador b = new Buscador(clave);
		
		b.buscar();

		List<String> resultados = b.getResultados();
		
		for (String articulo : resultados) {
			System.out.println(articulo);
		}
		
	}

}
