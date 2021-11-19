package clase5;

import java.util.Arrays;

public class VectorOject {

	public static void main(String[] args) {
		
		// la base de todos los tipos de datos en java
		
		Object edad = 10;
		Object nombre = "Joel";
		Object flag = true;
		Object letra = 'a';
		
		Object[] datos = new Object[] {edad, nombre, flag, letra};
		
		System.out.println(Arrays.toString(datos));
		
		// determinar que datos son de tipo boolean ???
		
		for (Object dato : datos) {
			if (dato instanceof Boolean) {
				
				/* tipos de datos primitivos
				 * byte < short < int < long < float < double
				 * 
				 *  wrapper
				 *  Byte, Short, Integer, Long, Float, Double
				*/
				
				boolean aux = (Boolean)dato;
				System.out.println("Encontre !!! = " + aux);

			}
		}
		
	}

}
