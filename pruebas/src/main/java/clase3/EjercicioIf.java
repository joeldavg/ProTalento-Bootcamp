package clase3;

import java.util.Scanner;

public class EjercicioIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// determinar dado 3 numero, cual es el mayor 
		
		Scanner teclado = new Scanner(System.in);
		
		// necesito 3 variables
		// if
		// mostrar el mayor
		
		double n1,n2,n3;
		
		System.out.println("Este codigo determinar el numero mayor de 3 numeros");
		
		System.out.println("Ingrese primer numero:");
		n1 = teclado.nextDouble();
		
		System.out.println("Ingrese segundo numero:");
		n2 = teclado.nextDouble();
		
		System.out.println("Ingrese tercer numero:");
		n3 = teclado.nextDouble();
		
		//
		if (n1 >= n2 && n1 >= n3) {
			System.out.println("El numero mayor ingresado es: " + n1);
		}
		else if (n2 >= n1 && n2 >= n3) {
			System.out.println("El numero mayor ingresado es: " + n2);
		}
		else if (n3 >= n1 && n3 >= n2) {
			System.out.println("El numero mayor ingresado es: " + n3);
		}
		else {
			System.out.println("Los numeros ingresados son iguales: " + n1);
		}
		
		teclado.close();

	}

}
