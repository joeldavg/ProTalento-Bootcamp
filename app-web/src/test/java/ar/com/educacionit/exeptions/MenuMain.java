package ar.com.educacionit.exeptions;

import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {
		
		//try {
			Integer op = MenuOption.getMenu();
			System.out.println("Ejecutando accion para el menu " + op);
		//} catch (InvalidMenuException e) {
		//	e.printStackTrace();
		//	System.exit(0);
		//}
		
	}

}
