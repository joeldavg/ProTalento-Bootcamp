package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

/**
 * Clase cliente!! Trabajar con la interface
 * @author Joel Guzman
 *
 */

public class SociosTest {

	public static void main(String[] args) throws ServiceException {
		//alguien cargo los datos desde teclado
		
		String nombre = "Joel";
		String apellido = "Guzman";
		String dni = "123456789";
		String email = "joel-guzman@hotmail.com";
		String direccion = "calle 13";
		Long pais = 1L;
		
		
		SociosService service = new SociosServiceImpl();
		Socios socio = new Socios(nombre, apellido, email, direccion, pais);
		service.save(socio); // Ctrl + T
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = new Categorias("Laptops", "abc123");
		cservice.save(categoria);
		
	}

}
