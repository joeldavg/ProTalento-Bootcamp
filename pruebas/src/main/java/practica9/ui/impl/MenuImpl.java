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
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println();
			System.out.println(" :: ACTUALIZAR ::");
			System.out.println();
			System.out.println("1. Actualizar Almunos.");
			System.out.println("2. Actualizar Materias.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			switch (response) {
			case 1:
				actualizarAlumno();
				break;
			case 2:
				actualizarMateria();
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

	private void actualizarAlumno() {
		System.out.println(" :: ACTUALIZAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id de Alumno a actualizar:");
		Long id = sc.nextLong();
		
		alumnos.buscarPorId(id);
		
		System.out.println();
		System.out.println("Ingresar matricula actualizada");
		Long matricula = sc.nextLong();
		System.out.println("Ingresar nombre actualizado");
		String nombre = sc.next();
		System.out.println("Ingresar apellido actualizado");
		String apellido = sc.next();
		
		Alumnos alumnoActualizado = new Alumnos(id, matricula, nombre, apellido);
		
		alumnos.actualizarEntidad(alumnoActualizado);
		
		System.out.println();
		System.out.println("Alumno con id=" + id + " fue actualizado correctamente!");
	}

	private void actualizarMateria() {
		System.out.println(" :: ACTUALIZAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id de la Materia a actualizar:");
		Long id = sc.nextLong();
		
		materias.buscarPorId(id);
		
		System.out.println();
		System.out.println("Ingresar curso actualizado");
		String curso = sc.next();
		System.out.println("Ingresar turno actualizado");
		String turno = sc.next();
		
		Materias materiaActualizada = new Materias(id, curso, turno);
		
		materias.actualizarEntidad(materiaActualizada);
		
		System.out.println();
		System.out.println("Materia con id=" + id + " fue actualizada correctamente!");
	}

	private void listar() {
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println();
			System.out.println(" :: LISTAR ::");
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
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println();
			System.out.println(" :: CREAR ::");
			System.out.println();
			System.out.println("1. Crear Almuno.");
			System.out.println("2. Crear Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				crearAlumno();
				break;
			case 2:
				crearMateria();
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
	}
	
	private void eliminar() {
		Scanner sc = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println();
			System.out.println(" :: ELIMINAR ::");
			System.out.println();
			System.out.println("1. Eliminar Almuno.");
			System.out.println("2. Eliminar Materia.");
			System.out.println("0. Regresar.");
			System.out.println();

			response = sc.nextInt();
			
			switch (response) {
			case 1:
				eliminarAlumno();
				break;
			case 2:
				eliminarMateria();
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

	private void eliminarAlumno() {
		System.out.println(" :: ELIMINAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese id de Alumno a eliminar:");
		long id = sc.nextInt();
		
		alumnos.eliminarEntidad(id);
		System.out.println();
		System.out.println("Alumno con id=" + id + " fue eliminado correctamente!");
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
	}
}