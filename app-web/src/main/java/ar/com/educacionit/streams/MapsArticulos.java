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

public class MapsArticulos {

	public static void main(String[] args) throws ServiceException {
		
		List<Articulos> articulos = new ArticulosServiceImpl().findAll();
		
		long count = articulos.stream()
				.map(articulo -> articulo.getPrecio())
				.peek(x -> System.out.println(x))
				.filter(precio -> precio > 100)
//				.peek(x -> System.out.println(x))
				.count();
		
		System.out.println(count);
		
	}

}
