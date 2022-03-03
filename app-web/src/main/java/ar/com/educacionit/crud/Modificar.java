package ar.com.educacionit.crud;

public class Modificar implements Ejecutable {

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando Modificar...");
	}

	@Override
	public void ejecutar(Data data) {
		System.out.println("Ejecutando modificar...");		
	}

}
