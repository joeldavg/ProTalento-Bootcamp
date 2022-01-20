package practica9.ui.impl;

import java.util.Scanner;

import practica9.db.AlumnosDB;
import practica9.db.MateriasDB;
import practica9.domain.Alumnos;
import practica9.domain.Materias;
import practica9.ui.Menu;

public class MenuImpl implements Menu {
	
	AlumnosDB alumnos = new AlumnosDB();
	MateriasDB materias = new MateriasDB();
	
	public void mostrarMenu() {
		
		System.out.println(" :: BIENVENIDOS :: ");
		System.out.println();
		System.out.println("Seleccione la opcion que desea realizar:");
		
		Scanner sc = new Scanner(System.in);
		int response = 0;
		do {
			
			System.out.println();
			System.out.println("1. Crear.");
			System.out.println("2. Listar.");
			System.out.println("3. Actualizar.");
			System.out.println("4. Eliminar.");
			System.out.println("0. Salir.");
			System.out.println();
			
			response = sc.nextInt();
			
			switch (response) {
			case 1:
				crear();
				response = 0;
				break;
			case 2:
				listar();
				response = 0;
				break;
			case 3:
				actualizar();
				response = 0;
				break;
			case 4:
				eliminar();
				response = 0;
				break;
			case 0:
				System.out.println("Gracias, vuelva pronto!");
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response  != 0);
	}
	
	private void actualizar() {
		// TODO Auto-generated method stub
		
	}

	private void listar() {
		System.out.println(" :: LISTAR ::");
		
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println();
			System.out.println("1. Listar Almunos.");
			System.out.println("2. Listar Materias.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				listarAlumno();
				break;
			case 2:
				listarMateria();
				break;
			case 0:
				mostrarMenu();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}

	private void listarAlumno() {
		System.out.println(" :: LISTA DE ALUMNOS ::");
		alumnos.listarEntidad();
	}

	private void listarMateria() {
		System.out.println(" :: LISTA DE MATERIAS ::");
		materias.listarEntidad();
		
	}

	private void crear() {
		System.out.println(" :: CREAR ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println("1. Crear Almuno.");
			System.out.println("2. Crear Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				crearAlumno();
				response = 0;
				break;
			case 2:
				crearMateria();
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

	private void crearAlumno() {
		System.out.println(" :: CREAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id:");
		long id = sc.nextInt();
		System.out.println("Ingrese Matricula:");
		long matricula = sc.nextInt();
		System.out.println("Ingrese Nombre:");
		String nombre = sc.next();
		System.out.println("Ingrese Apellido:");
		String apellido = sc.next();
		
		Alumnos nuevoAlumno = new Alumnos(id, matricula, nombre, apellido);
		alumnos.agregarEntidad(nuevoAlumno);
		
		System.out.println();
		System.out.println("Inscripcion exitosa!");
		
		int response = 0;
		do {
			System.out.println();
			System.out.println("1. Inscribir nuevo Alumno.");
			System.out.println("0. Regresar.");
			response = sc.nextInt();

			switch (response) {
			case 1:
				crearAlumno();
				response = 0;
				break;
			case 0:
				crear();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}

	private void crearMateria() {
		System.out.println(" :: CREAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese Id:");
		long id = sc.nextInt();
		System.out.println("Ingrese Curso:");
		String curso = sc.next();
		System.out.println("Ingrese Turno:");
		String turno = sc.next();
		
		Materias nuevaMateria = new Materias(id, curso, turno);
		materias.agregarEntidad(nuevaMateria);
		
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
				crearMateria();
				response = 0;
				break;
			case 0:
				crear();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}
	
	private void eliminar() {
		System.out.println(" :: ELIMINAR ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println("1. Eliminar Almuno.");
			System.out.println("2. Eliminar Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				eliminarAlumno();
				response = 0;
				break;
			case 2:
				eliminarMateria();
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

	private void eliminarAlumno() {
		System.out.println(" :: ELIMINAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id de Alumno a eliminar:");
		long id = sc.nextInt();
		
		alumnos.eliminarEntidad(id);
		System.out.println();
		System.out.println("Alumno con id=" + id + " fue eliminado correctamente!");
		
		int response = 0;
		do {
			System.out.println();
			System.out.println("1. Eliminar otro Alumno.");
			System.out.println("0. Regresar.");
			response = sc.nextInt();

			switch (response) {
			case 1:
				eliminarAlumno();
				response = 0;
				break;
			case 0:
				eliminar();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
		
	}

	private void eliminarMateria() {
		System.out.println(" :: ELIMINAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id de Materia a eliminar:");
		long id = sc.nextInt();
		
		materias.eliminarEntidad(id);
		System.out.println();
		System.out.println("Materia con id=" + id + " fue eliminado correctamente!");
		
		int response = 0;
		do {
			System.out.println();
			System.out.println("1. Eliminar otra Materia.");
			System.out.println("0. Regresar.");
			response = sc.nextInt();

			switch (response) {
			case 1:
				eliminarMateria();
				response = 0;
				break;
			case 0:
				eliminar();
				break;
			default:
				System.out.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}

}
