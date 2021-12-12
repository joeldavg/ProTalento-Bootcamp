package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class FindAllSociosTest {

	public static void main(String[] args) {
		
		//creo la implementacion que me permite acceder a la db (ICrud)
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		Socios[] vectorSocios = socioImpl.findAll();
		
		for (Socios socio : vectorSocios) {
			System.out.println(socio);
		}
		
		
	}

}
