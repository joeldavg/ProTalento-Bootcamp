package clase6.oop;

public class AutoMain {
	
	public static void main(String[] args) {
		
		// instanciar un objeto de la clase Auto
		
		Auto miClio = null;
		
		// ctrl+shift+i
		miClio = new Auto("Renault", "Clio", 178);
		miClio.detalleAuto();
		
		miClio.encender();//f5
		miClio.detalleAuto();
		
		miClio.acelerar();
		miClio.detalleAuto();
		
		miClio.apagar();
		miClio.detalleAuto();
		
		miClio = null;
	}
	

}
