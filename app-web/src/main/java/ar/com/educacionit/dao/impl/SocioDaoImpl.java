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
	
	public Socios[] finaAll() {
		String sql = "select * from socios";
		System.out.println("Ejecutando sql: " + sql);
		
		Socios socio1 = new Socios(1L, "JOEL1", "GUZMAN", "JOEL@GMAIL.COM", "AVE 13", 1L);
		Socios socio2 = new Socios(2L, "JOEL2", "GUZMAN", "JOEL@GMAIL.COM", "AVE 13", 1L);
		Socios socio3 = new Socios(3L, "JOEL3", "GUZMAN", "JOEL@GMAIL.COM", "AVE 13", 1L);
		
		Socios[] res = new Socios[] {socio1, socio2, socio3};
		
		return res;
	}

}
