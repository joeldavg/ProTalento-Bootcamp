package practica9.ui.impl;

import java.util.Scanner;

import practica9.domain.Alumnos;
import practica9.domain.Materias;
import practica9.ui.Menu;
import static practica9.db.DatosDBMemoria.*;

public class MenuImpl implements Menu {
	
	public void mostrarMenu() {
		
		System.out.println(" :: BIENVENIDOS :: ");
		System.out.println();
		System.out.println("Seleccione la opcion que desea realizar:");
		
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			
			System.out.println();
			System.out.println("1. Realizar inscripcion.");
			System.out.println("2. Eliminar inscripcion.");
			System.out.println("3. Buscar inscripcion.");
			System.out.println("0. Salir.");
			System.out.println();
			
			response = sc.nextInt();
			
			switch (response) {
			case 0:
				System.out.println("Gracias, vuelva pronto!");
				break;
			case 1:
				inscripcion();
				response = 0;
				break;
			case 2:
				eliminarInscripcion();
				response = 0;
				break;
			case 3:
				buscarInscripcion();
				response = 0;
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response  != 0);
	}
	
	public void inscripcion() {
		System.out.println(" :: INSCRIPCION :: ");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println("1. Inscribir Almuno.");
			System.out.println("2. Inscribir Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				inscribirAlumno();
				response = 0;
				break;
			case 2:
				inscribirMateria();
				response = 0;
				break;
			case 0:
				mostrarMenu();
				response = 0;
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}
	
	public void eliminarInscripcion() {
		System.out.println(" :: ELIMINAR INSCRIPCION :: ");
		System.out.println();

	}

	public void buscarInscripcion() {
		System.out.println(" :: BUSCAR INSCRIPCION :: ");
		System.out.println();
		
		System.out.println(alumnoCollections);
		System.out.println(materiaCollections);
		
	}

	public void inscribirAlumno() {
		
		System.out.println(" :: INSCRIPCION ALUMNO :: ");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese Matricula:");
		long matricula = sc.nextInt();
		System.out.println("Ingrese Nombre:");
		String nombre = sc.next();
		System.out.println("Ingrese Apellido:");
		String apellido = sc.next();
		
		Alumnos nuevoAlumno = new Alumnos(matricula, nombre, apellido);
		alumnoCollections.add(nuevoAlumno);
		
		System.out.println();
		System.out.println("Inscripcion exitosa!");
		System.out.println();
		
		int response = 0;
		do {
			System.out.println("1. Inscribir nuevo Alumno.");
			System.out.println("0. Regresar.");
			response = sc.nextInt();

			switch (response) {
			case 1:
				inscribirAlumno();
				response = 0;
				break;
			case 0:
				inscripcion();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}

	public void inscribirMateria() {
		System.out.println(" :: INSCRIPCION MATERIA :: ");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese Id:");
		long id = sc.nextInt();
		System.out.println("Ingrese Curso:");
		String curso = sc.next();
		System.out.println("Ingrese Turno:");
		String turno = sc.next();
		
		Materias nuevaMateria = new Materias(id, curso, turno);
		materiaCollections.add(nuevaMateria);
		
		System.out.println();
		System.out.println("Inscripcion exitosa!");
		System.out.println();
		
		int response = 0;
		do {
			System.out.println("1. Inscribir nueva Materia.");
			System.out.println("0. Regresar.");
			response = sc.nextInt();

			switch (response) {
			case 1:
				inscribirMateria();
				response = 0;
				break;
			case 0:
				inscripcion();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}
}
