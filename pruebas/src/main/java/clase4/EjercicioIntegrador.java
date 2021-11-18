package clase4;

import java.util.Scanner;

public class EjercicioIntegrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * ingrese 10 datos
		 * maximo
		 * minimo
		 * posMax
		 * posMin
		 * sumaTotal
		*/
		
		float[] datos = new float[10];
		float max;
		float min;
		int posMax = 0;
		int posMin = 0;
		float sumaTotal = 0;
		int cantRepMax = 0;
		int cantRepMin = 0;
		
		
		Scanner teclado = new Scanner(System.in);
		
		for (int i = 0; i < datos.length; i++) {
			
			System.out.println("Ingrese un valor");
			datos[i] = teclado.nextFloat();
			
		}
		
		teclado.close();
		
		max = datos[0];
		min = datos[0];
		
		sumaTotal = datos[0];
		
		for (int i = 1; i < datos.length; i++) {
			
			if (datos[i] >= max) {
				
				if (datos[i] == max) {
						cantRepMax ++;			
				}
				else {
					cantRepMax = 0;
				}
				
				max = datos[i];
				posMax = (byte) i;
				
			}
			if (datos[i] <= min) {
				
				if (datos[i] == min) {
					cantRepMin ++;			
				}
				else {
					cantRepMin = 0;
				}
				
				min = datos[i];
				posMin = (byte) i;
			}
			
			sumaTotal += datos[i];
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println(java.util.Arrays.toString(datos));
		System.out.println();
		System.out.println("Max: " + max);
		System.out.println("posMax: " + posMax);
		System.out.println("Rep. Max: " + cantRepMax);
		System.out.println();
		System.out.println("Min: " + min);
		System.out.println("posMin: " + posMin);
		System.out.println("Rep. Min: " + cantRepMin);
		System.out.println();
		System.out.println("Suma Toal: " + sumaTotal);
		
	}

}
