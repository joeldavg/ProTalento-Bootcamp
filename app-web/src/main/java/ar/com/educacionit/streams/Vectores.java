package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vectores {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<>();
		
		edades.add(10);
		edades.add(50);
		edades.add(40);
		edades.add(55);
		edades.add(5);
		edades.add(10);
		
		
		// filtrar los elementos >= 30
		List<Integer> filtrados = new ArrayList<Integer>();
		for (Integer edad : edades) {
			if (edad >= 30) {
				filtrados.add(edad);
			}
		}
		
		if (!filtrados.isEmpty()) {
			System.out.println(filtrados);
		} else {
			System.out.println("No hay elementos");
		}
		
		
	}

}
