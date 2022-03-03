package ar.com.educacionit.crud;

import java.util.Scanner;

public class Repaso {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int continuar;
		do {
			int opcion;
			do {
				Menu.mostrar();
				opcion = sc.nextInt();
			} while (opcion < 1 || opcion > 4);
			
			
			try {
				Ejecutable ej = EjecutableBuilder.getEjecutable(opcion);
				
				Data data = new Data(1L, "titulo data");
				
				ej.ejecutar();
				
			} catch (Exception e) {
				System.err.println(e);
			}
			
			Menu.mostrarContinuar();
			continuar = sc.nextInt();
		} while (continuar == 1);
		
		sc.close();
		System.out.println("FIN");
	}
	
}
