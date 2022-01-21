package practica9.ui.impl;

import java.util.Scanner;

import practica9.db.AlumnosDB;
import practica9.db.MateriasDB;
import practica9.domain.Alumnos;
import practica9.domain.Materias;
import practica9.ui.Menu;
import practica9.validation.ValidarFormato;
import practica9.validation.DBVaciaException;
import practica9.validation.InvalidFormatExeption;
import practica9.validation.RegistroNoExisteException;

public class MenuImpl implements Menu {
	
	AlumnosDB alumnos = new AlumnosDB();
	MateriasDB materias = new MateriasDB();
	ValidarFormato formato = new ValidarFormato();
	
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
				System.err.println("Ingrese opcion correcta:");
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
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response != 0);
	}

	private void actualizarAlumno() {
		System.out.println(" :: ACTUALIZAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id = null;
		Long matricula = null;
		String nombre = null;
		String apellido = null;
		Long cursoId = null;
		try {
			System.out.println("Ingrese id de Alumno a actualizar:");
			id = formato.validarLong(sc.next());
			alumnos.buscarPorId(id);
			System.out.println();
			System.out.println("Ingresar matricula actualizada");
			matricula = formato.validarLong(sc.next());
			System.out.println("Ingresar nombre actualizado");
			nombre = formato.validarString(sc.next());
			System.out.println("Ingresar apellido actualizado");
			apellido = formato.validarString(sc.next());
			System.out.println("Ingresar id curso actualizado");
			cursoId = formato.validarLong(sc.next());
			
			Alumnos alumnoActualizado = new Alumnos(id, matricula, nombre, apellido, cursoId);
			
			alumnos.actualizarEntidad(alumnoActualizado);
			
			System.out.println();
			System.out.println("Alumno con id=" + id + " fue actualizado correctamente!");
		} catch (InvalidFormatExeption | RegistroNoExisteException e) {
			System.err.println(e);
		}
	}

	private void actualizarMateria() {
		System.out.println(" :: ACTUALIZAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id;
		try {
			System.out.println("Ingrese id de la Materia a actualizar:");
			id = formato.validarLong(sc.next());
			materias.buscarPorId(id);
			System.out.println();
			System.out.println("Ingresar curso actualizado");
			String curso = formato.validarString(sc.next());
			System.out.println("Ingresar turno actualizado");
			String turno = formato.validarString(sc.next());
			
			Materias materiaActualizada = new Materias(id, curso, turno);
			
			materias.actualizarEntidad(materiaActualizada);
			
			System.out.println();
			System.out.println("Materia con id=" + id + " fue actualizada correctamente!");
		} catch (RegistroNoExisteException | InvalidFormatExeption e) {
			System.err.println(e);
		}
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
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response != 0);
	}

	private void listarAlumno() {
		System.out.println(" :: LISTA DE ALUMNOS ::");
		try {
			alumnos.listarEntidad();
		} catch (DBVaciaException e) {
			System.err.println(e);
		}
	}

	private void listarMateria() {
		System.out.println(" :: LISTA DE MATERIAS ::");
		try {
			materias.listarEntidad();
		} catch (DBVaciaException e) {
			System.err.println(e);
		}
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
				System.err.println("Ingrese opcion correcta:");
				break;
			}
			
		} while (response != 0);
	}

	private void crearAlumno() {
		System.out.println(" :: CREAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id = null;
		Long matricula = null;
		String nombre= null;
		String apellido = null;
		Long cursoId = null;
		try {
			System.out.println("Ingrese id:");
			id = formato.validarLong(sc.next());
			System.out.println("Ingrese Matricula:");
			matricula = formato.validarLong(sc.next());
			System.out.println("Ingrese Nombre:");
			nombre = formato.validarString(sc.next());
			System.out.println("Ingrese Apellido:");
			apellido = formato.validarString(sc.next());
			System.out.println("Ingrese curso id:");
			cursoId = formato.validarLong(sc.next());
			materias.buscarPorId(cursoId);

			Alumnos nuevoAlumno = new Alumnos(id, matricula, nombre, apellido, cursoId);
			alumnos.agregarEntidad(nuevoAlumno);
			
			System.out.println();
			System.out.println("Inscripcion exitosa!");
		} catch (InvalidFormatExeption | RegistroNoExisteException e) {
			System.err.println(e);
		}
	}

	private void crearMateria() {
		System.out.println(" :: CREAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id = null;
		String curso = null;
		String turno = null;
		try {
			System.out.println("Ingrese Id:");
			id = formato.validarLong(sc.next());
			System.out.println("Ingrese Curso:");
			curso = formato.validarString(sc.next());
			System.out.println("Ingrese Turno:");
			turno = formato.validarString(sc.next());
			
			Materias nuevaMateria = new Materias(id, curso, turno);
			materias.agregarEntidad(nuevaMateria);
			
			System.out.println();
			System.out.println("Inscripcion exitosa!");
		} catch (InvalidFormatExeption e) {
			System.err.println(e);
		}
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
				System.err.println("Ingrese opcion correcta:");
				break;
			}
		} while (response != 0);
	}

	private void eliminarAlumno() {
		System.out.println(" :: ELIMINAR ALUMNO ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id = null;
		try {
			System.out.println("Ingrese id de Alumno a eliminar:");
			id = formato.validarLong(sc.next());
			alumnos.eliminarEntidad(id);
			System.out.println();
			System.out.println("Alumno con id=" + id + " fue eliminado correctamente!");
		} catch (InvalidFormatExeption | RegistroNoExisteException e) {
			System.err.println(e);
		}
	}

	private void eliminarMateria() {
		System.out.println(" :: ELIMINAR MATERIA ::");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		Long id = null;
		try {
			System.out.println("Ingrese id de Materia a eliminar:");
			id = formato.validarLong(sc.next());
			materias.eliminarEntidad(id);
			System.out.println();
			System.out.println("Materia con id=" + id + " fue eliminado correctamente!");
		} catch (InvalidFormatExeption | RegistroNoExisteException e) {
			System.err.println(e);
		}
	}
	
}