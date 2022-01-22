package practica11;

public class IdiomaMain {

	public static void main(String[] args) {
		
		IIdioma idioma = new Espanol();
		
		Personas joel = new Personas("joel", "guzman", idioma);
		
		try {
			joel.aprenderIdioma(new Frances());
			joel.aprenderIdioma(new Ingles());
		} catch (DominaIdiomaException e) {
			System.err.println(e);
		}
		
	}

}
