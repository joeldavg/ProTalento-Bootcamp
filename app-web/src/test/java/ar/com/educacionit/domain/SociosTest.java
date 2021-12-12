package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class SociosTest {

	public static void main(String[] args) {
		//alguien cargo los datos desde teclado
		
		String nombre = "Joel";
		String apellido = "Guzman";
		String dni = "123456789";
		String email = "joel-guzman@hotmail.com";
		String direccion = "calle 13";
		Long pais = 1L;
		
		//uso el constructor de socios
		//Socios nuevoSocio = new Socios(nombre, apellido, email, direccion, pais);
				
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		//socioImpl.create(nuevoSocio);
		
		Socios socio = socioImpl.create(new Socios(nombre, apellido, email, direccion, pais));
		
		System.out.println("se ha creado el socios id: " + socio.getId());
		
		Socios otroSocio = socioImpl.findById(5L);
		
		if (otroSocio != null) {
			System.out.println("se ha creado el socios id: " + otroSocio.getId());
		} else {
			System.out.println("se ha encontrado al socios: " + otroSocio);
		}
		
		//usar el findAll()
		
		
		
	}

}
