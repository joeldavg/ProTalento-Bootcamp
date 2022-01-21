package practica9.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import practica9.domain.Entity;
import practica9.validation.DBVaciaException;
import practica9.validation.RegistroNoExisteException;


public class DatosDBMemoria<T extends Entity> {

	private List<T> entityCollections;
	
	public DatosDBMemoria() {
		this.entityCollections = new ArrayList<>();
	}
	
	public void agregarEntidad(T entity) {
		entityCollections.add(entity);
	}
	
	public void eliminarEntidad(Long id) throws RegistroNoExisteException {
		
		Iterator<T> iEntity = entityCollections.iterator();
		Boolean isListed = false;
		while (iEntity.hasNext()) {
			T entity = (T) iEntity.next();
			if (entity.getId().equals(id)) {
				entityCollections.remove(entity);
				isListed = true;
				break;
			}
		}
		if (!isListed) {
			throw new RegistroNoExisteException("No existe registro con id=" + id);
		}
		
	}
	
	public void listarEntidad() throws DBVaciaException {
		if (entityCollections.isEmpty()) {
			throw new DBVaciaException("No hay registros en DB");
		} else {
			for (T entity : entityCollections) {
				System.out.println(entity);
			}
		}
	}
	
	public void buscarPorId(Long id) throws RegistroNoExisteException {
		Boolean isListed = false;
		Iterator<T> iEntity = entityCollections.iterator();
		while (iEntity.hasNext()) {
			T entity = (T) iEntity.next();
			if (entity.getId().equals(id)) {
				isListed = true;
				break;
			}
		}
		if (!isListed) {
			throw new RegistroNoExisteException("No existe registro con id=" + id + ", crear registro o ingresar id correcto.");
		}
	}
	
	public void actualizarEntidad(T entity) {
		ListIterator<T> iEntity = entityCollections.listIterator();
		while (iEntity.hasNext()) {
			T entityAux = (T) iEntity.next();
			if (entityAux.getId().equals(entity.getId())) {
				int index = entityCollections.indexOf(entityAux);
				entityCollections.set(index, entity);
				break;
			}
		}
	}

}
