package collections.list;

import java.util.HashSet;
import java.util.Set;

public class Persona {
	
	private IIdioma idiomaNativo;
	private Set<IIdioma> otros;
	private String nombre;
	private String apellido;
	
	public Persona(IIdioma idiomaNativo, String nombre, String apellido) {
		this.idiomaNativo = idiomaNativo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.otros = new HashSet<IIdioma>();
	}
	
	public void aprender(IIdioma nuevoIdioma) {
		//nulo
		if (nuevoIdioma == null) {
			throw new RuntimeException("Idioma invalido o nulo");
		}
		
		if (otros.contains(nuevoIdioma)) {
			throw new RuntimeException("Idioma ya aprendido");
		}
		
		this.aprenderIdioma(nuevoIdioma);
		
	}
	
	private void aprenderIdioma(IIdioma nuevoIdioma) {
		//logica adicional
		this.otros.add(nuevoIdioma);
	}
	
}
