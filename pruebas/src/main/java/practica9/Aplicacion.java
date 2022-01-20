package practica9;

import practica9.ui.Menu;
import practica9.ui.impl.MenuImpl;

public class Aplicacion {

	public static void main(String[] args) {
		
		Menu menu = new MenuImpl();
		menu.mostrarMenu();
	}
}
