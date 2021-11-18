package clase4;

public class CicloWhile {

	public static void main(String[] args) {

		// ciclo while
		
		short[] edades = new short[] {10, 5, 25};
		
		// definir i por fuera
		
		int i = 0;
		
		// 0 < 3 ? SI
		// 1 < 3 ? SI
		// 2 < 3 ? SI
		// 3 < 3 ? NO
		while (i < edades.length) {
			System.out.println("pos: " + i + ", val: " + edades[i]);
			i++;
		}
		
		
		System.out.println("-------------------------------");
		
		i = edades.length -1;
		while (i >= 0) {
			System.out.println("pos: " + i + ", val: " + edades[i]);
			i--;
		}

	}

}
