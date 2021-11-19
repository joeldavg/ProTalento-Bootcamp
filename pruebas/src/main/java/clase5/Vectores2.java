package clase5;

import java.util.Arrays;
import java.util.Iterator;

public class Vectores2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* crear vectores
			tipoDatos[] nombre = new tipoDatos[] {valor1, valor2, ..., valorn};
			tipoDato[] nombre = new tipoDato[tamaño];
		*/
		
		String[] nombres = new String[] {"Luz", "Jose", "Edwin", "Carlos", "Herana", "Samir", "Elsa"};
									//     0	   1		2		 3		   4		5
		String[] nombresConE = new String[nombres.length];
		
		//int size = nombres.length; // 6 --> sabemos el tamaño del vector
		
		// buscar los nombres que inicien con e
		
		
		int j = 0;
		for (int i = 0; i < nombres.length; i++) {
			
			String nombre = nombres[i];
			
			/*
			if (dato.substring(0, 1) == "E") {
				
			}
			if (dato.charAt(0) == 'E') {
				
			}
			if (dato.indexOf("E") == 0) {
				
			}
			*/
			
			if (nombre.startsWith("E")) {
				nombresConE[j] = nombre;
				j++;
			}
			
		}
		
		System.out.println(Arrays.toString(nombresConE));
		
		for (String nombre : nombresConE) {
			if (nombre != null) {
				System.out.println(nombre);
			}
		}
		
	}

}
