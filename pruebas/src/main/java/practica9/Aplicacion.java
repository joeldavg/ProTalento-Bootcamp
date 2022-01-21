package practica9;

import practica9.ui.IMenu;
import practica9.ui.impl.MenuImpl;

public class Aplicacion {

	public static void main(String[] args) {
		
		IMenu iMenu = new MenuImpl();
		iMenu.mostrarMenu();
	}
}
