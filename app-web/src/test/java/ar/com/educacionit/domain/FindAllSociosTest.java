package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SociosDaoImpl;

public class FindAllSociosTest {

	public static void main(String[] args) {
		
		//creo la implementacion que me permite acceder a la db (ICrud)
		
		SociosDaoImpl socioImpl = new SociosDaoImpl();
		
		Socios[] vectorSocios = socioImpl.findAll();
		
		for (Socios socio : vectorSocios) {
			System.out.println(socio);
		}
		
		
	}

}
