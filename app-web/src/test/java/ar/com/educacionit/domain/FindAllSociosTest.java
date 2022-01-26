package ar.com.educacionit.domain;

import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SociosDaoImpl;

public class FindAllSociosTest {

	public static void main(String[] args) {
		
		//creo la implementacion que me permite acceder a la db (ICrud)
		
		SociosDaoImpl socioImpl = new SociosDaoImpl();
		
		List<Socios> vectorSocios = null;
		try {
			vectorSocios = socioImpl.findAll();
		} catch (GenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Socios socio : vectorSocios) {
			System.out.println(socio);
		}
		
		
	}

}
