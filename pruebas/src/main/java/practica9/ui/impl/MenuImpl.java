package practica9.ui.impl;

import java.util.Scanner;

import practica9.ui.Menu;

public class MenuImpl implements Menu {
	
	public void mostrarMenu() {
		
		System.out.println(" :: BIENVENIDOS :: ");
		System.out.println();
		System.out.println("Seleccione la opcion que desea realizar:");
		
		Scanner sc = new Scanner(System.in);
		
		int exit = -1;
		do {
			
			System.out.println();
			System.out.println("1. Realizar inscripcion.");
			System.out.println("2. Eliminar inscripcion.");
			System.out.println("3. Buscar inscripcion.");
			System.out.println("0. Salir.");
			System.out.println();
			
			int response = sc.nextInt();
			
			switch (response) {
			case 0:
				exit = 0;
				break;
			case 1:
				inscripcion();
				break;
			case 2:
				eliminarInscripcion();
				break;
			case 3:
				buscarInscripcion();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (exit  != 0);
		
		
	}
	
	public void inscripcion() {
		System.out.println(" :: INSCRIPCION ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int exit = -1;
		do {
			System.out.println("1. Inscribir Almuno.");
			System.out.println("2. Inscribir Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			int response = sc.nextInt();
			
			switch (response) {
			case 1:
				inscribirAlumno();;
				break;
			case 2:
				inscribirMateria();;
				break;
			case 0:
				mostrarMenu();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (exit != 0);
	}
	
	public void eliminarInscripcion() {
		System.out.println(" :: ELIMINAR INSCRIPCION ::");
		System.out.println();

	}

	public void buscarInscripcion() {
		System.out.println(" :: BUSCAR INSCRIPCION ::");
		System.out.println();

	}

	public void inscribirAlumno() {

	}

	public void inscribirMateria() {
		
	}
}
