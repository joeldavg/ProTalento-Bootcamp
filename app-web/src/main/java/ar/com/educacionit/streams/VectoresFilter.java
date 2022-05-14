package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VectoresFilter {

	public static void main(String[] args) {

		Collection<Integer> edades = new ArrayList<>();

		edades.add(10);
		edades.add(50);
		edades.add(40);
		edades.add(55);
		edades.add(5);
		edades.add(10);

		// streams filter
		List<Integer> filtradoPares = edades.stream()
				.filter(x -> x >= 30)
				.filter(x -> x % 2 == 0)
				.collect(Collectors.toList());
		
		System.out.println(filtradoPares);

	}

}
