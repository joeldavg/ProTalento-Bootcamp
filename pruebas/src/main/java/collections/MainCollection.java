package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainCollection {
	
	public static void main(String[] args) {
		
		Collection<String> nombres = new ArrayList<>();
		
		nombres.add("Joel");
		nombres.add("Carlos");
		nombres.add("Juan");
		
		System.out.println(nombres);
		
		//obtener
		Iterator<String> itNombres = nombres.iterator();
		while (itNombres.hasNext()) {
			String dato = itNombres.next();
			System.out.println("Dato: " + dato);
		}
		
		nombres.remove("Carlos");
		System.out.println(nombres);

		//eliminar con Iterator
		itNombres = nombres.iterator();
		while (itNombres.hasNext()) {
			itNombres.next();
			itNombres.remove();
		}
		
	}
}
