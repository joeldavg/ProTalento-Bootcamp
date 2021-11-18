package clase4;

public class Arrays {

	public static void main(String[] args) {
		
		// crear vector 
		
		int [] edades = new int[3]; // un vector de 3 posiciones 0,1
		
		//[0,0,0]
		
		// carga
		edades[0] = 5;
		edades[1] = 10;
		edades[2] = 15;
		
		int tamano = edades.length; // tamaño del vector
				
		// acceder ultimo elemento
		
		int edad = edades[tamano - 1];
		
		//edades[0];
				
		
	}

}
