package collections.list;

public class MainIdiomas {

	public static void main(String[] args) {
		
		IIdioma idioma = new Espanol();
		
		Persona joel = new Persona(idioma, "joel", "guzman");
		idioma.decir();
		
		idioma = new Ingles();
		idioma.decir();
		
		joel.aprender(idioma);
		
		idioma = new Chino();
		idioma.decir();

		joel.aprender(idioma);
		
		
	}
	
}
