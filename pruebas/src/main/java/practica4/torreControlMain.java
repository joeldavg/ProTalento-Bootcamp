package practica4;

public class torreControlMain {

	public static void main(String[] args) {
		
		Avion avion = new Avion("AV01", "Avianca", 50);
		Helicoptero helicoptero = new Helicoptero("HCT01", "AA2021", "BLACK");
		Ovni ovni = new Ovni("Ov01", "Circular", "GREEN");
		Superman superman = new Superman("Clark Kent");
		
		Volador[] voladores = new Volador[] {avion, helicoptero, ovni, superman };
		
		//verificar interfaz aterrizable
		
		for (Volador volador : voladores) {
			
			volador.solicitudAterrizar();
			
			if (volador instanceof Aterrizable) {
				Aterrizable atr = (Aterrizable) volador;
				atr.aterrizar();
			} else {
				System.out.println(volador.getNombre() + " , no cumple contrato para aterrizar.");
			}
			System.out.println();
		}
		
		
	}

}
