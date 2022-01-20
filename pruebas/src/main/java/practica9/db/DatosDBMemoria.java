package practica9.db;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import practica9.domain.Entity;


public class DatosDBMemoria<T extends Entity> {

	private Set<T> entityCollections;
	
	public DatosDBMemoria() {
		this.entityCollections = new HashSet<>();
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

}
