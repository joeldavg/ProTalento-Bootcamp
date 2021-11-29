package practica3;

import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.Notation;

public class Ejercicio {

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
		String[] nombre;
		String[] apellido;
		Integer[] numeroDeExamen;
		Float[] notaAlumno;
		Object[][] alumno;
		
		Object[][] alumnoNotaMasAlta;
		Object[][] alumnoNotaMasBaja;
		Object[][] alumnoPromocionan;
		Object[][] alumnoRecursan;
		
		// carga de datos
		
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("Bienvenidos a La escuela primaria xyz");
		
		// Ingresar cantidad alumno
		
		do {
			
			System.out.println("Ingrese cantidad de alumnos a procesar > 0:");
			cantidadAlumno = teclado.nextInt();
			
		} while (cantidadAlumno <= 0);
		
		// definir tamaño 
		
		nombre = new String[cantidadAlumno];
		apellido = new String[cantidadAlumno];
		numeroDeExamen = new Integer[cantidadAlumno];
		notaAlumno = new Float[cantidadAlumno];
		
		
		alumno = new Object[cantidadAlumno][4];
		
		// ingresando valores
		
		for (int i = 0; i < cantidadAlumno; i++) {
			
			System.out.println("Alumno #" + (i+1) + ", ingresar nombre:");
			nombre[i] = teclado.next();
			
			System.out.println("Alumno #" + (i+1) + ", ingresar apellido:");
			apellido[i] = teclado.next();

			System.out.println("Alumno #" + (i+1) + ", ingresar numero de examen:");
			numeroDeExamen[i] = teclado.nextInt();
						
			do {
				System.out.println("Alumno #" + (i+1) + ", ingresar nota (númerico >=0 <=10):");
				notaAlumno[i] = teclado.nextFloat();
				
			} while (notaAlumno[i] < 0 || notaAlumno[i] > 10);
			
		}
		
		// procesamiento de datos
		
		Float auxNotaMasAlta = notaAlumno[0];
		Float auxNotaMasBaja = notaAlumno[0];
		
		int contadorNotaMasAlta = 1;
		int contadorNotaMasBaja = 1;
		
		for (int i = 1; i < notaAlumno.length; i++) {
			
			if ( auxNotaMasAlta <= notaAlumno[i] ) {
				
				if ( auxNotaMasAlta.equals(notaAlumno[i]) ) {
					contadorNotaMasAlta++;
				}
				else {
					contadorNotaMasAlta = 1;
				}
				auxNotaMasAlta = notaAlumno[i];
			}
			
			if (auxNotaMasBaja >= notaAlumno[i]) {
				
				if ( auxNotaMasBaja.equals(notaAlumno[i])) {
					contadorNotaMasBaja++;
				}
				else {
					contadorNotaMasBaja = 1;
				}
				auxNotaMasBaja = notaAlumno[i];
			}
			
		}
		
		int contadorPromocionan = 0;
		int contadorRecursan = 0;
		
		for (int i = 0; i < notaAlumno.length; i++) {
			if ( notaAlumno[i] >= 7) {
				contadorPromocionan++;
			}
			else {
				contadorRecursan++;
			}
		}
		
		alumnoNotaMasAlta = new Object[contadorNotaMasAlta][4];
		alumnoNotaMasBaja = new Object[contadorNotaMasBaja][4];
		alumnoPromocionan = new Object[contadorPromocionan][4];
		alumnoRecursan = new Object[contadorRecursan][4];
		
		int posNotaMasAlta = 0;
		int posNotaMasBaja = 0;

		//carga de matrices, sabemos que auxNotaMasAlta & alumnoNotaMasBaja son notas mas alta y baja respectivamente
		
		for (int i = 0; i < notaAlumno.length; i++) {
			
			if ( auxNotaMasAlta.equals(notaAlumno[i]) ) {
				
				alumnoNotaMasAlta[posNotaMasAlta][0] = nombre[i];
				alumnoNotaMasAlta[posNotaMasAlta][1] = apellido[i];
				alumnoNotaMasAlta[posNotaMasAlta][2] = numeroDeExamen[i];
				alumnoNotaMasAlta[posNotaMasAlta][3] = notaAlumno[i];
				
				posNotaMasAlta++;

			}
			
			if ( auxNotaMasBaja.equals(notaAlumno[i]) ) {
				
				alumnoNotaMasBaja[posNotaMasBaja][0] = nombre[i];
				alumnoNotaMasBaja[posNotaMasBaja][1] = apellido[i];
				alumnoNotaMasBaja[posNotaMasBaja][2] = numeroDeExamen[i];
				alumnoNotaMasBaja[posNotaMasBaja][3] = notaAlumno[i];
				
				posNotaMasBaja++;
			}
		}
		
		int posPromocionan = 0;
		int posRecursan = 0;
		
		for (int i = 0; i < notaAlumno.length; i++) {
			if ( notaAlumno[i] >= 7) {
				
				alumnoPromocionan[posPromocionan][0] = nombre[i];
				alumnoPromocionan[posPromocionan][1] = apellido[i];
				alumnoPromocionan[posPromocionan][2] = numeroDeExamen[i];
				alumnoPromocionan[posPromocionan][3] = notaAlumno[i];
				posPromocionan++;
			}
			else {
				alumnoRecursan[posRecursan][0] = nombre[i];
				alumnoRecursan[posRecursan][1] = apellido[i];
				alumnoRecursan[posRecursan][2] = numeroDeExamen[i];
				alumnoRecursan[posRecursan][3] = notaAlumno[i];
				contadorRecursan++;
			}
		}
		
		// Mostrar datos
		
		
		System.out.println("****************************");
		System.out.println("Resultados:");
		
		System.out.println("1- alumno/s con la calificación mas alta");
		for (int i = 0; i < alumnoNotaMasAlta.length; i++) {
			
			for (int j = 0; j < alumnoNotaMasAlta[i].length; j++) {
				System.out.println(alumnoNotaMasAlta[i][j]);
			}
			System.out.println("------------------------------");
		}
		
		System.out.println("****************************");
		System.out.println("2- alumno/s con la calificación mas baja");
		for (int i = 0; i < alumnoNotaMasBaja.length; i++) {
			for (int j = 0; j < alumnoNotaMasBaja[i].length; j++) {
				System.out.println(alumnoNotaMasBaja[i][j]);
			}
			System.out.println("------------------------------");
		}
		
		System.out.println("****************************");
		System.out.println("3- alumnos que promocionan, aquellos que obtubieron un promerdio >= 7");
		for (int i = 0; i < alumnoPromocionan.length; i++) {
			for (int j = 0; j < alumnoPromocionan[i].length; j++) {
				System.out.println(alumnoPromocionan[i][j]);
			}
			System.out.println("------------------------------");
		}
		
		System.out.println("****************************");
		System.out.println("4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7");
		for (int i = 0; i < alumnoRecursan.length; i++) {
			for (int j = 0; j < alumnoRecursan[i].length; j++) {
				System.out.println(alumnoRecursan[i][j]);
			}
			System.out.println("------------------------------");
		}
		
	}

}
