package clase5;

public class Matriz {

	public static void main(String[] args) {
		
		int cantFilas = 2;
		int cantCols = 2;
		Integer[][] matriz = new Integer[cantFilas][cantCols];
		
		// tamaño de la matriz
		
		//System.out.println(matriz.length);
		//System.out.println(matriz[0].length);
		
		// cargamos matriz
		
		for (int fila = 0; fila < cantFilas; fila++) {
			
			for (int columna = 0; columna < cantCols; columna++) {
				
				matriz[fila][columna] = fila + columna;
				
			}
			
		}
		
		
		for (int fila = 0; fila < cantFilas; fila++) {
			
			for (int columna = 0; columna < cantCols; columna++) {
				
				matriz[fila][columna] = fila + columna;
				
				System.out.println(fila + "+" + columna + "=" + matriz[fila][columna]);
				
			}
			
		}
		
		System.out.println("FIN");
	}

}
