package practica11;

public class Espanol implements IIdioma {

	@Override
	public void decirNombre(String name) {
		System.out.println("Hola! Mi nombres es " + name + ".");
	}

	@Override
	public String dominaIdioma() {
		return "Ya hablas Español";
	}

	
	
}
