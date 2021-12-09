package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.ICrud;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl implements ICrud {

	public Socios create(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db
		//insertar datos
		
		String sql = "INSERT INTO SOCIOS(nombre, apellido, email, direccion) VALUES('JOEL', 'GUZMAN', 'JOEL@GMAIL.COM', 'AVE 13')";
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(10L, "JOEL", "GUZMAN", "JOEL@GMAIL.COM", "AVE 13", 1L);
	}

	public Socios findById(Long id) {
		
		String sql = "SELECT * FROM SOCIOS WHERE ID = " + id;
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(id, "JOEL", "GUZMAN", "JOEL@GMAIL.COM", "AVE 13", 1L);
		
	}
	
	

}
