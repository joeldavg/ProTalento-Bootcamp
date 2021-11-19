package clase5;

public class Ejercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad = 10; // primitivo
		int edad1 = 10;
		
		if (edad == edad1) {
			System.out.println("son iguales");
		}
		else {
			System.out.println("son distintos");
		}
		
		System.out.println("---- String");
		
		String edadS = "10";
		String edadS1 = "10";
		
		if (edadS == edadS1) {
			System.out.println("son iguales");
		}
		else {
			System.out.println("son distintos");
		}
		
		System.out.println("----------- equals()");
		
		String edadSE = new String("10");
		String edadSE1 = new String("10");
		
		if (edadSE.equals(edadSE1)) {
			System.out.println("son iguales");
		}
		else {
			System.out.println("son distintos");
		}
		

	}

}
