package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosDaoTest {

	public static void main(String[] args) {
		
		SociosService service = new SociosServiceImpl();
		Socios socio = service.getOne(1l);
		System.out.println(socio);
		
		System.out.println();
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = cservice.getOne(2l);
		System.out.println(categoria);
		
	}

}
