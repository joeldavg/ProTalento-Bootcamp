package clase6;

public class EjemploProcedimiento {

	public static void main(String[] args) {
		
		// invocar procedimiento
		
		saludar("¿cómo estás?");
		
		responder("bien, gracias");
		
		// calcular la suma de dos variable
		
		int a = 10;
		int b = 20;
		
		// asignar el valor de retorno de la funcion a una variable tipo int
		
		int c = sumar(a, b);
		
		System.out.println("Suma: " + a + " + " + b + " = " + c);
		
	}
	
	
	static int sumar(int a, int b) {
		/*
		 * int res = a + b;
		 * return res;
		 */
		
		return a +b;
	}
	
	
	//un procedimiento 

	static void responder(String saludo) {
		System.out.println("Hola: " + saludo);
	}
	
	static void saludar(String saludo) {
		System.out.println("Hola: " + saludo);
	}
	

}
