package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.ICrud;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl implements ICrud {

	public Socios create(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db
		//insertar datos
		
		String sql = "INSERT INTO socios(nombre, apellido, email, direccion) VALUES('joel', 'guzman', 'joel@hotmail.com', 'ave 13')";
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(10L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
	}

	public Socios findById(Long id) {
		
		String sql = "SELECT * FROM socios WHERE id = " + id;
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(id, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		
	}
	
	public Socios[] findAll() {
		
		String sql = "SELECT * FROM socios";
		System.out.println("Ejecutando sql: " + sql);
		
		Socios socio1 = new Socios(1L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		Socios socio2 = new Socios(2L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		Socios socio3 = new Socios(3L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		
		
		return new Socios[] {socio1, socio2, socio3};
	}

}
