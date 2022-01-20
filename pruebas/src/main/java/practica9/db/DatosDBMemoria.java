package practica9.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import practica9.domain.Entity;


public class DatosDBMemoria<T extends Entity> {

	private List<T> entityCollections;
	
	public DatosDBMemoria() {
		this.entityCollections = new ArrayList<>();
	}
	
	public void agregarEntidad(T entity) {
		entityCollections.add(entity);
	}
	
	public void eliminarEntidad(Long id) {
		
		Iterator<T> iEntity = entityCollections.iterator();
		while (iEntity.hasNext()) {
			T entity = (T) iEntity.next();
			if (entity.getId().equals(id)) {
				entityCollections.remove(entity);
				break;
			}
		}
		
	}
	
	public void listarEntidad() {
		for (T entity : entityCollections) {
			System.out.println(entity);
		}
	}
	
	public void buscarPorId(Long id) {
		Iterator<T> iEntity = entityCollections.iterator();
		while (iEntity.hasNext()) {
			T entity = (T) iEntity.next();
			if (entity.getId().equals(id)) {
				System.out.println(entity);
				break;
			}
			
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
