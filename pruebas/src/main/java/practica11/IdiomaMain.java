package practica11;

public class IdiomaMain {

	public static void main(String[] args) {
		
		IIdioma idioma1 = new Espanol();
		IIdioma idioma2 = new Frances();
		IIdioma idioma3 = new Ingles();
		
		Personas joel = new Personas("joel", "guzman", idioma1);
		
		try {
			joel.aprenderIdioma(idioma2);
			//joel.aprenderIdioma(idioma3);
		} catch (DominaIdiomaException e) {
			System.err.println(e);
		}
		
		joel.hablar(idioma1);
		System.out.println();
		joel.hablar(idioma2);
		System.out.println();
		joel.hablar(idioma3);
		
	}

}
