package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Entity;

/**
 * Las T son entidades que representan tablas, por ende van a deredar de Entity
 * @author Joel Guzman
 *
 * @param <T>
 */


public class JdbcDaoBase<T extends Entity> implements GenericDao<T>{
	
	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tabladelHijo) {
		this.tabla = tabladelHijo;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//this.clazz = clazz;
		//this.tabla = this.clazz.getCanonicalName().toLowerCase();
	}

	public T getOne(Long id) {
		String sql = "SELECT * FROM " + this.tabla + " WHERE id = " + id;
		System.out.println("Ejecutando sql: " + sql);
		T entity; 
		
		try {
			//entity = this.clazz.newInstance();
			entity = this.clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
			// clase utilitaria que va a saber como tomar la instancia y como armar
			// los seteos de los atributos
			
		} catch (Exception e) {
			entity = null;
		}
		
		return entity;
	}

	public void delete(Long id) {
		
	}

	public T save(T entity) {
		return null;
	}

	public void update(T entity) {
		
	}

	public T[] findAll() {
		return null;
	}
	
}
