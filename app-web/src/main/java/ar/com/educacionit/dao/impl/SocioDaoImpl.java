package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl implements SociosDao {

	public Socios save(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db
		//insertar datos
		
		String sql = "INSERT INTO socios(nombre, apellido, email, direccion) VALUES('joel', 'guzman', 'joel@hotmail.com', 'ave 13')";
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(10L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
	}

	public Socios getOne(Long id) {
		
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

	public void delete(Long id) {
		String sql = "DELETE FROM socios WHERE id = " + id;

		System.out.println(sql);
	}

	public void update(Socios entity) {
		String sql = "UPDATE socios "
				+ "SET direccion = '" + entity.getDireccion() + "', apellido = '" + entity.getApellido() + 
				"', paises_id = " + entity.getPaisesId() + " WHERE  id = 1";
		
		System.out.println(sql);
	}

}
