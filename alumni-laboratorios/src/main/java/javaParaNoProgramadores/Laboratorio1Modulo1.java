package javaParaNoProgramadores;

public class Laboratorio1Modulo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cantidadHorasTotes;
		int cantidadSemanas;
		int cantidadDias;
		int cantidadHoras;
		
		cantidadHorasTotes = 1500;
		System.out.println("Cantidad Horas Totales: " + cantidadHorasTotes);
		
		cantidadSemanas = cantidadHorasTotes / (7*24) ;
		System.out.println("Semanas: " + cantidadSemanas);
		
		cantidadDias = ( cantidadHorasTotes % (7*24) ) / 24;
		System.out.println("Dias: " + cantidadDias);
		
		cantidadHoras =  ( cantidadHorasTotes % (7*24) ) % 24;
		System.out.println("Horas: " + cantidadHoras);
		
	}

}
