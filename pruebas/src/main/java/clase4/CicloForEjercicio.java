package clase4;

import java.util.Scanner;

public class CicloForEjercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// solicitar al usuario la cantidad de registros
		// cargar en un vector de enteros los datos ingresados por el usuario
		// contar la cantidad de numeros pares
		// contar la cantidad de numeros impares
		// sumar los numeros pares 
		// sumar los numeros impares
		// promedio de los valores ingresados
		
		int cantidadRegistros;
		int[] vector;
		int contadorPares = 0;
		int contadorImpares = 0;
		int sumaPares = 0;
		int sumaImpares = 0;
		double promedio;
		int cant0 = 0;
		
		// paso 1, definir tamaño de vector
		// Carga de datos
		
		
		Scanner teclado = new Scanner(System.in);
		
		
		do {
			
			System.out.println("Ingrese la cantidad de registros a procesar: > 0");
			cantidadRegistros = teclado.nextInt();
			
		} while (cantidadRegistros < 0);
		
		vector = new int[cantidadRegistros];
		
		for (int i = 0; i <= cantidadRegistros - 1; i++) {
			
			System.out.println("Ingrese dato:");
			int datoLeido = teclado.nextInt();
			
			vector[i] = datoLeido;
		}
		
		for (int dato : vector) {
			
			if (dato % 2 == 0) {
				contadorPares++;
				sumaPares += dato;
			}
			else if (dato == 0) {
				cant0 ++;
			}
			else {
				contadorImpares++;
				sumaImpares += dato;
			}
			
		}
		
		// promedio
		
		promedio = (double) (sumaPares + sumaImpares) / cantidadRegistros;
		
		// Mostrar los datos calculados
		
		System.out.println("--------------------------------------------");
		System.out.println(java.util.Arrays.toString(vector));
		System.out.println("Cantidad de registgros: " + cantidadRegistros);
		System.out.println("La cantidad de numero pares es: " + contadorPares);
		System.out.println("La cantidad de numero impares es: " + contadorImpares);
		System.out.println("La suma de pares es: " + sumaPares);
		System.out.println("La suma de impares es: " + sumaImpares);
		System.out.println("El promedio de los datos ingresados es: " + promedio);
		
		
		teclado.close();
	}

}
