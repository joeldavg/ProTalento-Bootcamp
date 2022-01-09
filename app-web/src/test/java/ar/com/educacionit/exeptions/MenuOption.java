package ar.com.educacionit.exeptions;

import java.util.Scanner;

public class MenuOption {
	
	public static Integer getMenu() /*throws InvalidMenuException*/ {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese menu:");
		System.out.println("1. Alta"
				+ "2. Baja"
				+ "3. Modificacion");
			
		Integer op = teclado.nextInt();
		
		try {
			if (op != 1 && op != 2 && op != 3) {
				throw new InvalidMenuException(op + " No es valido");
			}
		} finally {
			teclado.close();
		}
		return op;
	}
	
}
