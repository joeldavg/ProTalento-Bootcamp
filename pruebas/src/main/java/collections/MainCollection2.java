package collections;

import java.util.ArrayList;
import java.util.List;

public class MainCollection2 {
	
	public static void main(String[] args) {
		
		List<String> nombres = new ArrayList<>();
		
		nombres.add(new String("Joel"));
		nombres.add(new String("Carlos"));
		nombres.add(new String("Juan"));
		nombres.add(new String("Juan"));
		
		List<String> apellidos = new ArrayList<>();
		apellidos.add("Guzman");
		apellidos.add("Lopez");
		apellidos.add("Perez");

		// Lista de lista
		List<List<String>> nombreList = new ArrayList<>();
		nombreList.add(nombres);
		nombreList.add(apellidos);
		
		System.out.println(nombreList);
		
		for (List<String> list : nombreList) {
			for (String dato : list) {
				System.out.println(dato);
			}
		}
		
	}
}
