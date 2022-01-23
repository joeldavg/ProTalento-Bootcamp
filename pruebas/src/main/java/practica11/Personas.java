package practica11;

import java.util.HashSet;
import java.util.Set;

public class Personas {

	private String nombre;
	private String apellido;
	private IIdioma idiomaNativo;
	private Set<IIdioma> idiomas;
	
	public Personas(String nombre, String apellido, IIdioma idiomaNativo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
		this.idiomas = new HashSet<>();
		this.idiomas.add(idiomaNativo);
	}

	public Set<IIdioma> getIdiomas() {
		return idiomas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public IIdioma getIdiomaNativo() {
		return idiomaNativo;
	}
	
	public void aprenderIdioma(IIdioma idioma) throws DominaIdiomaException {
		if (contieneIdioma(idioma)) {
			throw new DominaIdiomaException(idioma.dominaIdioma());
		} else {
			agregarIdioma(idioma);
		}
	}
	
	private void agregarIdioma(IIdioma idioma) {
		idiomas.add(idioma);
	}
	
	private boolean contieneIdioma(IIdioma idioma) {
		for (IIdioma idiomaAux : idiomas) {
			if (idioma.getClass().getSimpleName().equals(idiomaAux.getClass().getSimpleName())) {
				return true;
			}
		}
		return false;
	}
	
	public void hablar(IIdioma idioma) {
		if (contieneIdioma(idioma)) {
			idioma.decirNombre(getNombre());
		} else {
			System.out.println("No he aprendido este idioma: " + idioma.getClass().getSimpleName());
		}
	}

}
