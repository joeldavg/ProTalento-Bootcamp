package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SociosDaoImpl extends JdbcDaoBase<Socios> implements SociosDao {

	public SociosDaoImpl() {
		super("socios");// es la tabla
	}

	@Override
	public String getSaveSQL(Socios entity) {
		
		//lo particular del sql
		
		String sql = " (nombre,apellido,email,direccion,pasises_id) VALUES ('"+entity.getNombre()+"','"
				+ entity.getApellido() + "','" + entity.getEmail() +"','"+entity.getDireccion()+"','"+entity.getPaisesId()+"')";

		return sql;
	}

	@Override
	public String getUpdateSQL(Socios entity) {
		
		String sql = " nombre='" + entity.getNombre() + "',";
		sql += " apellido='" + entity.getApellido() + "',";
		sql += " email='" + entity.getEmail() + "',";
		if (entity.getPaisesId() != null ) {
			sql += " paises_id='" + entity.getPaisesId() + "'";
		}
		
		return sql;
	}
	
	/*
	//Create
	public Socios save(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db
		//insertar datos
		
		String sql = "INSERT INTO socios(nombre, apellido, email, direccion) "
					+ "VALUES('joel', 'guzman', 'joel@hotmail.com', 'ave 13')";
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(10L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
	}
	// Read
	public Socios getOne(Long id) {
		
		String sql = "SELECT * FROM socios WHERE id = " + id;
		System.out.println("Ejecutando sql: " + sql);
		
		return new Socios(id, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		
	}
	
	// select *
	public Socios[] findAll() {
		
		String sql = "SELECT * FROM socios";
		System.out.println("Ejecutando sql: " + sql);
		
		Socios socio1 = new Socios(1L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		Socios socio2 = new Socios(2L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		Socios socio3 = new Socios(3L, "joel", "guzman", "joel@hotmail.com", "ave 13", 1L);
		
		
		return new Socios[] {socio1, socio2, socio3};
	}
	
	// Delete
	public void delete(Long id) {
		String sql = "DELETE FROM socios WHERE id = " + id;

		System.out.println(sql);
	}
	
	// Update
	public void update(Socios entity) {
		String sql = "UPDATE socios "
					+ "SET direccion = '" + entity.getDireccion() + "', apellido = '" + entity.getApellido() + "', "
					+ "paises_id = " + entity.getPaisesId() + " WHERE id = 1";
		
		System.out.println(sql);
	}
	*/

}
