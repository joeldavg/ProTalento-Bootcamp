package ar.com.educacionit.crud;

public class Alta implements Ejecutable {

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando Alta...");
	}

	public void crear() {
		System.out.println("Metodo crear clase Alta");
	}

	@Override
	public void ejecutar(Data data) {
		System.out.println("Ejecutando Alta...");
		
	}
	
}
