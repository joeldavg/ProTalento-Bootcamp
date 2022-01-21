package practica11;

import java.util.Set;

public class Personas {

	private String nombre;
	private String apellido;
	private IIdioma idiomaNativo;
	private Set<IIdioma> otros;
	
	public Personas(String nombre, String apellido, IIdioma idiomaNativo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
	}
	
	
	
}
