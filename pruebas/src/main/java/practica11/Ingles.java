package practica11;

public class Ingles implements IIdioma {

	@Override
	public void decirNombre(String name) {
		System.out.println("Hello! My name is " + name + ".");
	}

	@Override
	public String dominaIdioma() {
		return "You already speak English";		
	}


}
