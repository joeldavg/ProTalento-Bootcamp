package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService extends GenericService<Articulos>{
	
	List<Articulos> findByTitle(String sql) throws ServiceException;
	
}
