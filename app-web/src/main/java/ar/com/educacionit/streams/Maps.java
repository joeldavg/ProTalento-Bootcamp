package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<>();
		
		edades.add(10);
		edades.add(50);
		edades.add(40);
		edades.add(55);
		edades.add(5);
		edades.add(10);
		
		//funcion intermedia
		Set<String> edadesStrings = edades.stream()
				.map(x -> "valor: " + x.toString())
				.collect(Collectors.toSet());
		
		System.out.println(edadesStrings);
	}

}
