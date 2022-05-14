package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.services.GenericService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class AbstractBaseService<T> implements GenericService<T> {
	
	protected GenericDao<T> genericDao;
	
	//constructor
	public AbstractBaseService(GenericDao<T> daoDelHijo) {
		this.genericDao = daoDelHijo;
	}
	
	public T getOne(Long id) throws ServiceException {
		
		T entity;
		try {
			entity = this.genericDao.getOne(id);
		} catch (GenericException e) {
			throw new ServiceException("Error de DB al intentar obtener entity id = " + id , e);
		}
		
		return entity;
	}

	public void delete(Long id) throws ServiceException {
		
		try {
			this.genericDao.delete(id);
		} catch (GenericException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("Error guardar dato", e);
		}
	}

	public T save(T entity) throws ServiceException {
	
		try {
			return this.genericDao.save(entity);
		} catch (DuplicatedException | GenericException de) {
			de.printStackTrace();
			//relanzo la exception como una ServiceException que contiene
			//la exception original
			throw new ServiceException("No se ha podido grabar la entidad", de);
		}
	}

	public void update(T entity) throws ServiceException {
		try {
			this.genericDao.update(entity);
		} catch (GenericException | DuplicatedException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("No se ha podido actualizar la entidad", e);
		}
	}

	public List<T> findAll() throws ServiceException {
		try {
			return this.genericDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error consultado entidad", e);
		}
	}
	
	public List<T> findAllByTitle(String criterio) throws ServiceException {
		try {
			return this.genericDao.findByTitle(criterio);
		} catch (GenericException e) {
			throw new ServiceException("Error consultado entidad", e);
		}
	}

}
