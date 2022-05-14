package ar.com.educacionit.dao;

import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;

public interface ArticulosDao extends GenericDao<Articulos> {

	List<Articulos> findByTitle(String sql) throws GenericException;
	
}
