package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.services.GenericService;

public class AbstractBaseService<T> implements GenericService<T> {
	
	protected GenericDao<T> genericDao;
	
	
	public AbstractBaseService(GenericDao<T> genericDao) {
		super();
		this.genericDao = genericDao;
	}

	public T getOne(Long id) {
		return this.genericDao.getOne(id);
	}

	public void delete(Long id) {
		this.genericDao.delete(id);
	}

	public T save(T entity) {
		return this.genericDao.save(entity);
	}

	public void update(T entity) {
		this.genericDao.update(entity);
	}

	public T[] findAll() {
		return this.genericDao.findAll();
	}

}
