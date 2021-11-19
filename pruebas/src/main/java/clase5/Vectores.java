package clase5;

import java.util.Arrays;
import java.util.Iterator;

public class Vectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* crear vectores
			tipoDatos[] nombre = new tipoDatos[] {valor1, valor2, ..., valorn};
			tipoDato[] nombre = new tipoDato[tama�o];
		*/
		
		String[] nombres = new String[] {"Luz", "Jose", "Edwin", "Carlos", "Herana", "Samir", "Elsa"};
		
		// determinar la cantidad de nombres que inician con E
		// creamos el vector con dicho tama�o
		
		int cantidad = 0;
		for (String nombre : nombres) {
			if (nombre.startsWith("E")) {
				cantidad ++;
			}
		}
		
		// crear el vector nuevo con el tama�o correcto
		
		String[] nombresConE = new String[cantidad];
		
		int pos = 0;
		
		for (String nombre : nombres) {
			if (nombre.startsWith("E")) {
				nombresConE[pos] = nombre;
				pos ++;
			}
		}
		
		System.out.println(Arrays.toString(nombresConE));
		
	}

}
