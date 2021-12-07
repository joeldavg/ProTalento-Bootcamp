package clase8.oop.herencia;

public class CineMain2 {

	public static void main(String[] args) {
		
		//Persona persona = new Persona("persona1", "apellido1", "negro");
		Persona empleado = new Empleado("empleado1", "apellidoemp1", "rojo", 1);
		Persona efectivo = new Efectivo("nombre efectivo", "apellido efectivo", "rubio", 1);
		Persona contratado = new Contratado("nombre contratado1", "apellido contratado1", "azul", 1, 6);
		
		Director director = new Director("nombre director", "apellido director", "negro", 10);
		
		//todas las personas pueden ir al cine
		
		Persona[] personas = new Persona[4];
		
		System.out.println(empleado.cantidadNariz);
		System.out.println(efectivo.cantidadNariz);
		
		//logica...
		//Persona.cantidadNariz = 5;
		
		System.out.println(contratado.cantidadNariz);
		System.out.println(director.cantidadNariz);
		
		
		
	}

}
