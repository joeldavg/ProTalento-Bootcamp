package clase6;

public class CalculadoraMain {

	public static void main(String[] args) {
		
		//¿cómo uso la calculadora?
		//crear (new) una calculadora
		//usar alguna de sus funciones
		
		// variable primitivas
		int a = 10;
		int b = 30;
		boolean flag = true;
		float altura = 185;
		
		// crear objeto, de la clase calculadora
		Calculadora miCalculadora = new Calculadora();
		
		// ahora puedo ejecutar de sus funciones
		
		double suma = miCalculadora.sumar(a, b);
		
		System.out.println("La suma de " + a + " y " + b +  " es " + suma);
		
		double resta = miCalculadora.restar(a, b);
		
		System.out.println("La resta de " + a + " y " + b + " es " + resta);
		
		
	}

}
