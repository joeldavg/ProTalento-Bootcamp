package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class Reduce {

	public static void main(String[] args) throws ServiceException {

		List<Articulos> articulos = new ArticulosServiceImpl().findAll();

		Double total = articulos.stream()
				.map(x -> x.getPrecio())
				.peek(x -> System.out.println(x))
				.reduce(0d, (x, y) -> x + y);
		
		System.out.println("valor total: " + total);

	}

}
