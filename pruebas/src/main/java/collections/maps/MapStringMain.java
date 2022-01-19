package collections.maps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapStringMain {

	public static void main(String[] args) {
		
		
		Map<String, Integer> mapa = new HashMap<>();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println(mapa);
		
		String nombre = "";
		do {
			System.out.println("Ingrese nombre:");
			
			if (mapa.containsKey(nombre)) {
				Integer value = mapa.get(nombre);
				value++;
				mapa.put(nombre, value);
			} else {
				mapa.put(nombre, 1);
			}
			
		} while (!nombre.equalsIgnoreCase(""));
		
		
	}

}
