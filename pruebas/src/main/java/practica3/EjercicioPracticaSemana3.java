package practica3;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ProgressMonitor;

import org.w3c.dom.Notation;

public class EjercicioPracticaSemana3 {

	public static void main(String[] args) {
		/*
			"Crear un branch con el nombre practica-adicional-semana3:
			 La idea es practicar ciclos, dobles con vectores, máximo, mínimo, promedio.
			 realizar el siguiente ejercicios:
			 La escuela primaria xyz solicita el desarrollo de una aplicación para poder llevar el control de notas para cada alumno.
			 El programa solicitará el ingreso la cantidad de alumnos a procesar.
			 Para cada alumno se deberá ingresar los siguientes datos:
			 - nombre (string)
			 - apellido (string)
			 - número de examen
			 - nota que obtubo el alumno (númerico >=0 <=10)
			 Al finalizar la carga de datos, se procederá a listar la siguiente información:
			 1- alumno/s con la calificación mas alta
			 2- alumno/s con la calificación mas baja
			 3- alumnos que promocionan, aquellos que obtubieron un promerdio >= 7
			 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"
		 
		 */

		Integer cantidadAlumno;
		Integer numeroDeExamen;
		String[] nombre;
		String[] apellido;
		Float[][] notaAlumno;
		//Object[][] alumno;
		
		Object[][] alumnoNotaMasAlta;
		Object[][] alumnoNotaMasBaja;
		Object[][] alumnoPromocionan;
		Object[][] alumnoRecursan;
		
		// carga de datos
		
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("Bienvenidos a La escuela primaria xyz");
		System.out.println();
		
		// Ingresar cantidad alumno
		
		do {
			
			System.out.println("Ingrese cantidad de alumnos a procesar > 0:");
			cantidadAlumno = teclado.nextInt();
			
			System.out.println("Ingrese cantidad de notas > 0:");
			numeroDeExamen = teclado.nextInt();
			
		} while (cantidadAlumno <= 0 && numeroDeExamen <=0);
		
		// definir tamaño 
		
		nombre = new String[cantidadAlumno];
		apellido = new String[cantidadAlumno];
		notaAlumno = new Float[cantidadAlumno][numeroDeExamen];
		
		
		// ingresando valores
		
		for (int i = 0; i < cantidadAlumno; i++) {
			
			System.out.println();
			System.out.println("Alumno #" + (i+1) + ", ingresar nombre:");
			nombre[i] = teclado.next();
			
			System.out.println();
			System.out.println("Alumno #" + (i+1) + ", ingresar apellido:");
			apellido[i] = teclado.next();
			
			for (int j = 0; j < numeroDeExamen; j++) {
				
				do {
					System.out.println();
					System.out.println("Alumno #" + (i+1) + ", ingresar nota #" + (j+1) + " (númerico >=0 <=10):");
					notaAlumno[i][j] = teclado.nextFloat();
					
				} while (notaAlumno[i][j] < 0 || notaAlumno[i][j] > 10);
			
			}
						
			
		}
		
		teclado.close();
		
		// procesamiento de datos
		
		//calcular promedio de notas
		
		Float[] promNotaAlumno = new Float[notaAlumno.length];
		
		for (int i = 0; i < notaAlumno.length; i++) {
			
			Float sumaNota = 0F;
			
			for (int j = 0; j < notaAlumno[i].length; j++) {
				sumaNota += notaAlumno[i][j];
			}
			
			promNotaAlumno[i] = sumaNota / notaAlumno[i].length;
		}
		
		//alumno = new Object[][] { {nombre}, {apellido}, {notaAlumno}, {promNotaAlumno} };
		
		//buscar promedio mas alto y mas bajo
		
		Float auxPromMasAlto = promNotaAlumno[0];
		Float auxPromMasBajo = promNotaAlumno[0];
		
		int contadorPromNotaMasAlta = 1;
		int contadorPromNotaMasBaja = 1;
		
		for (int i = 1; i < promNotaAlumno.length; i++) {
			
			
			if ( auxPromMasAlto <= promNotaAlumno[i] ) {
				
				if ( auxPromMasAlto.equals(promNotaAlumno[i]) ) {
					contadorPromNotaMasAlta++;
				} else {
					contadorPromNotaMasAlta = 1;
				}
				auxPromMasAlto = promNotaAlumno[i];
			}
			
			if (auxPromMasBajo >= promNotaAlumno[i]) {
				
				if ( auxPromMasBajo.equals(promNotaAlumno[i])) {
					contadorPromNotaMasBaja++;
				} else {
					contadorPromNotaMasBaja = 1;
				}
				auxPromMasBajo = promNotaAlumno[i];
			}
			
		}
		
		int contadorPromocionan = 0;
		int contadorRecursan = 0;
		
		for (int i = 0; i < promNotaAlumno.length; i++) {
			if ( promNotaAlumno[i] >= 7) {
				contadorPromocionan++;
			} else {
				contadorRecursan++;
			}
		}
		
		alumnoNotaMasAlta = new Object[contadorPromNotaMasAlta][4];
		alumnoNotaMasBaja = new Object[contadorPromNotaMasBaja][4];
		alumnoPromocionan = new Object[contadorPromocionan][4];
		alumnoRecursan = new Object[contadorRecursan][4];
		
		int posNotaMasAlta = 0;
		int posNotaMasBaja = 0;
		int posPromocionan = 0;
		int posRecursan = 0;
		

		//carga de matrices, sabemos que auxNotaMasAlta & alumnoNotaMasBaja son notas mas alta y baja respectivamente
		
		for (int i = 0; i < promNotaAlumno.length; i++) {
			
			if ( auxPromMasAlto.equals(promNotaAlumno[i]) ) {
				
				alumnoNotaMasAlta[posNotaMasAlta][0] = nombre[i];
				alumnoNotaMasAlta[posNotaMasAlta][1] = apellido[i];
				alumnoNotaMasAlta[posNotaMasAlta][2] = notaAlumno[i];
				alumnoNotaMasAlta[posNotaMasAlta][3] = promNotaAlumno[i];
				
				posNotaMasAlta++;

			}
			
			if ( auxPromMasBajo.equals(promNotaAlumno[i]) ) {
				
				alumnoNotaMasBaja[posNotaMasBaja][0] = nombre[i];
				alumnoNotaMasBaja[posNotaMasBaja][1] = apellido[i];
				alumnoNotaMasBaja[posNotaMasBaja][2] = notaAlumno[i];
				alumnoNotaMasBaja[posNotaMasBaja][3] = promNotaAlumno[i];
				
				posNotaMasBaja++;
			}
			
			if ( promNotaAlumno[i] >= 7) {
				
				alumnoPromocionan[posPromocionan][0] = nombre[i];
				alumnoPromocionan[posPromocionan][1] = apellido[i];
				alumnoPromocionan[posPromocionan][2] = notaAlumno[i];
				alumnoPromocionan[posPromocionan][3] = promNotaAlumno[i];

				posPromocionan++;
				
			} else {
				alumnoRecursan[posRecursan][0] = nombre[i];
				alumnoRecursan[posRecursan][1] = apellido[i];
				alumnoRecursan[posRecursan][2] = notaAlumno[i];
				alumnoRecursan[posRecursan][3] = promNotaAlumno[i];

				posRecursan++;
			}
		}
		
		
		// Mostrar datos
		
		
		System.out.println("****************************");
		System.out.println("Resultados:");
		
		System.out.println();
		System.out.println("1- alumno/s con la calificación mas alta");
		for (int i = 0; i < alumnoNotaMasAlta.length; i++) {
			
			System.out.println("Nombre: " + alumnoNotaMasAlta[i][0]);
			System.out.println("Apellido: " + alumnoNotaMasAlta[i][1]);
			System.out.println("Notas: " + Arrays.toString((Float[]) alumnoNotaMasAlta[i][2]));
			System.out.println("Promedio: " + alumnoNotaMasAlta[i][3]);
			
			System.out.println("------------------------------");
		}
		
		System.out.println();
		System.out.println("****************************");
		System.out.println("2- alumno/s con la calificación mas baja");
		for (int i = 0; i < alumnoNotaMasBaja.length; i++) {
			
			System.out.println("Nombre: " + alumnoNotaMasBaja[i][0]);
			System.out.println("Apellido: " + alumnoNotaMasBaja[i][1]);
			System.out.println("Notas: " + Arrays.toString((Float[]) alumnoNotaMasBaja[i][2]));
			System.out.println("Promedio: " + alumnoNotaMasBaja[i][3]);
			System.out.println("------------------------------");
		}
		
		System.out.println();
		System.out.println("****************************");
		System.out.println("3- alumnos que promocionan, aquellos que obtubieron un promerdio >= 7");
		for (int i = 0; i < alumnoPromocionan.length; i++) {
			
			System.out.println("Nombre: " + alumnoPromocionan[i][0]);
			System.out.println("Apellido: " + alumnoPromocionan[i][1]);
			System.out.println("Notas: " + Arrays.toString((Float[]) alumnoPromocionan[i][2]));
			System.out.println("Promedio: " + alumnoPromocionan[i][3]);
			System.out.println("------------------------------");
		}
		
		System.out.println();
		System.out.println("****************************");
		System.out.println("4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7");
		for (int i = 0; i < alumnoRecursan.length; i++) {
			
			System.out.println("Nombre: " + alumnoRecursan[i][0]);
			System.out.println("Apellido: " + alumnoRecursan[i][1]);
			System.out.println("Notas: " + Arrays.toString((Float[]) alumnoRecursan[i][2]));
			System.out.println("Promedio: " + alumnoRecursan[i][3]);
			
			System.out.println("------------------------------");
		}
		
	}

}
