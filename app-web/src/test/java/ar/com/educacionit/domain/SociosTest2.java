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

public class SociosTest2 {

	public static void main(String[] args) throws ServiceException {
		
		SociosService service = new SociosServiceImpl();		
		Socios socio = service.getOne(6L);//ctrl+t
		
		socio.setApellido("nuevo apellido");
		socio.setNombre("nuevo nombre");
		socio.setEmail("nuevoem@mail.com");
		
		service.update(socio);
	}

}
