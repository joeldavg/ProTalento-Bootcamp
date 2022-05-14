package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.dao.ArticulosDao;
import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ArticulosDaoImpl;
import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.dao.impl.MarcasDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticulosServiceImpl extends AbstractBaseService<Articulos> implements ArticulosService {

	private CategoriaDao categoriaDao;
	
	private MarcasDao marcasDao;
	
	private ArticulosDao articulosDao;
	
	public ArticulosServiceImpl() {
		super(new ArticulosDaoImpl());
		this.articulosDao = (ArticulosDao) this.genericDao;
		this.categoriaDao = new CategoriaDaoImpl();
		this.marcasDao = new MarcasDaoImpl();
	}
	
	@Override
	public Articulos getOne(Long id) throws ServiceException {
		try {
			Articulos articulo = this.genericDao.getOne(id);
//			Marcas marca = marcasDao.getOne(articulo.getMarcasId());
//			Categorias categoria = categoriaDao.getOne(articulo.getCategoriasId());
//			articulo.setMarca(marca);
//			articulo.setCategorias(categoria);
			return articulo;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<Articulos> findByTitle(String criterio) throws ServiceException {
		try {
			return this.articulosDao.findByTitle(criterio);
		} catch (GenericException e) {
			throw new ServiceException("Error consultado entidad", e);
		}
	}

}
