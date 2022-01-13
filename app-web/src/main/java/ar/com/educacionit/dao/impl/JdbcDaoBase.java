package ar.com.educacionit.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Entity;

/**
 * Las T son entidades que representan tablas, por ende van a deredar de Entity
 * @author Joel Guzman
 *
 * @param <T>
 */


public abstract class JdbcDaoBase<T extends Entity> implements GenericDao<T>{
	
	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tabladelHijo) {
		this.tabla = tabladelHijo;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//this.clazz = clazz;
		//this.tabla = this.clazz.getCanonicalName().toLowerCase();
	}

	public T getOne(Long id) throws GenericException {
		
		if (id == null) {
			throw new GenericException("Id no informado");
		}
		
		String sql = "SELECT * FROM " + this.tabla + " WHERE id = " + id;
		System.out.println("Ejecutando sql: " + sql);
		T entity; 
		
		try {
			//entity = this.clazz.newInstance();
			entity = this.clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
			
			// tomar los metodos de this.clazz > Method[]
			// para cada method > method.invoke(entity)
			
			
			// clase utilitaria que va a saber como tomar la instancia y como armar
			// los seteos de los atributos
			
		} catch (Exception e) {
			entity = null;
		}
		
		return entity;
	}

	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM " + this.tabla + "WHERE id = " + id;
		System.out.println(sql);
		//execute
		// error de conexion!!
	}
	
	/*public T save(T entity) throws DuplicatedException {
		
		StringBuffer namesSQL = new StringBuffer("INSERT INTO ").append(this.tabla).append(" (");
		StringBuffer valueSQLString = new StringBuffer("VALUES (");

		try {
			T instance = this.clazz.getConstructor().newInstance();
			
			//le pido los filds
			Field[] fields = instance.getClass().getDeclaredFields();
			
			for (Field field : fields) {
				field.setAccessible(true);
				//socio(id, nombre, apellido, pais_id)
				//socio(id, nombre, apellido, pais_id)
				//socio(id, nombre, apellido, paisId)
				
				String campoSql = field.getName();
				Object valueSql = field.get(entity);
				
				if (valueSql != null) {
					namesSQL.append(campoSql).append(",");
					valueSQLString.append("'").append(valueSql).append("'").append(",");
				}
			}
			
			namesSQL = new StringBuffer(namesSQL.substring(0, (namesSQL.length()-1) ));
			namesSQL.append(") ");
			
			valueSQLString = new StringBuffer(valueSQLString.substring(0, (valueSQLString.length()-1) ));
			valueSQLString.append(")");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sqlFinal = namesSQL.toString() + valueSQLString.toString();
		System.out.println(sqlFinal);
		
		return null;
	}*/
	
	public T save(T entity) throws DuplicatedException {
		
		String sql = "INSERT INTO " + this.tabla + this.getSaveSQL(entity);
		System.out.println(sql);
		entity.setId(12l);
		return null;
	}
	
	public abstract String getSaveSQL(T entity);

	public void update(T entity) {
		
		String sql = "UPDATE " + this.tabla + " SET" + getUpdateSQL(entity) + " WHERE id = " + entity.getId();
		System.out.println(sql);
	}
	
	public abstract String getUpdateSQL(T entity);

	public List<T> findAll() {
		
		String sql = "SELECT * FROM " + this.tabla;
		System.out.println(sql);
		//la info debe venir de la db
		
		//supongo que hay 2 registros
		List<T> instances = new ArrayList<T>();
		
		T instance;
		try {
			instance = this.clazz.getDeclaredConstructor().newInstance();
			instance.setId(1L);
			instances.add(instance);
			instances.add(instance);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return instances;
	}
	
}
