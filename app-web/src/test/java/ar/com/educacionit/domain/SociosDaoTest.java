package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosDaoTest {

	public static void main(String[] args) {
		
		SociosService service = new SociosServiceImpl();
		Socios socio = null;
		try {
			socio = service.getOne(null);
		} catch (ServiceException se) {
			String msjDeService = se.getMessage();
			System.err.println(msjDeService);
			// quiero la causa que origino es
			Throwable cause = se.getCause();
			String msjCause = cause.getMessage();
			System.err.println(msjCause);
		}
		System.out.println(socio);
		
		//**************************************//
		System.out.println();
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = null;
		try {
			categoria = cservice.getOne(2l);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(categoria);
		
	}

}
