package practica11;

public class Frances implements IIdioma {

	@Override
	public void decirNombre(String name) {
		System.out.println("Salut! Je m'appelle " + name + ".");
	}

	@Override
	public String dominaIdioma() {
		return "tu parles déjà français";		
	}

}
