package clase5;

import java.util.Arrays;

public class Cuentas {

	public static void main(String[] args) {
		
		String[] archivo = new String[]{
				"1000;juan lopez;1500;ca",
				"2000;joel guzman;115000;ca",
				"3000;juan martinez;-1000;cc",
				"4000;matias perez;10000;cc",
				"5000;elsa moyano;21000;cc"};
		
		// obtener las cuentas con saldo negativo con apyn
		// obtener las cuentas con saldo > 10000 con apyn
		
		
		Object[][] saldoNegativo = new Object[archivo.length][4];
		Object[][] saldoMayor100 = new Object[archivo.length][4];
		
		
		//separar por ;
		for (int i = 0; i < archivo.length; i++) {
			
			String registro = archivo[i];
			
			String[] cuenta = registro.split(";");
			
			Integer numCuenta = Integer.parseInt(cuenta[0]);
			String apyn = cuenta[1];
			Double saldo = Double.parseDouble(cuenta[2]);
			String tipo = cuenta[3];
			
			System.out.println("Registro: " + Arrays.toString(cuenta));
			System.out.println("Numero: " + numCuenta);
			System.out.println("Apellido y Nombre: " + apyn);
			System.out.println("Saldo: " + saldo);
			System.out.println("Tipo de Cuenta: " + tipo);
			System.out.println("------------------------------------------");
			
			if (saldo < 0) {
				saldoNegativo[i][0] = saldo;
				saldoNegativo[i][1] = apyn;
				saldoNegativo[i][2] = numCuenta;
				saldoNegativo[i][3] = tipo;
			}
			if (saldo >= 100000) {
				saldoMayor100[i][0] = saldo;
				saldoMayor100[i][1] = apyn;				
				saldoMayor100[i][2] = numCuenta;
				saldoMayor100[i][3] = tipo;
			}
					
		}
		
		for (int f = 0; f < saldoNegativo.length; f++) {
			
			for (int c = 0; c < saldoNegativo[f].length; c++) {
				
				if (saldoNegativo[f][c] != null) {
					
					System.out.println(saldoNegativo[f][c] );
				}
			}
			System.out.println("-----------------------");
		}
		
		System.out.println("**************************************");
		
		for (int f = 0; f < saldoMayor100.length; f++) {
			
			for (int c = 0; c < saldoMayor100[f].length; c++) {
				
				if (saldoMayor100[f][c] != null) {
					
					System.out.println(saldoMayor100[f][c] );
				}
			}
			System.out.println("-----------------------");
		}
		
	}

}
