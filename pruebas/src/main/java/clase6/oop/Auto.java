package clase6.oop;

public class Auto {
	
	//atributos
	String marca;
	String modelo;
	float velocidad;
	boolean encendido;
	float velocidadMaxima;
	
	// constructor parametrizado
	
	Auto(String marca, String modelo, float velocidadMaxima){
		// hace referencia a las variables y metodos propios de la clase
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
	}
	
	// metodos
	
	void encender() {
		if (encendido == false) {
			encendido = true;
			System.out.println("Se ha encendido el auto");			
		}
		else {
			System.out.println("Ya esta encendido el auto");
		}
	}
	
	void apagar() {
		if (encendido) {
			encendido = false;
			velocidad = 0;
			System.out.println("Se ha apagado el auto");	
		}
		else {
			System.out.println("Ya esta apagado el auto");
		}
	}
	
	void acelerar() {
		if (encendido) {
			if (velocidad < velocidadMaxima) {
				velocidad++;
			}
			else {
				System.out.println("Velocidad maxima, no es posible acelerar mas");
			}
		}
		else {
			System.out.println("Primero debe encender Auto!");
		}
	
	}
	
	void frenar() {
		if (encendido) {
			if (velocidad > 0) {
				velocidad --;
			}
			else {
				System.out.println("Velocidad es 0");
			}
		}
		else {
			System.out.println("Prime debe encender el auto, Auto esta parqueado");
		}
		
	}
	
	float ObtenerVelocidad() {
		return velocidad;
	}
	
	public void detalleAuto() {
		System.out.println("-------------------------------");
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Encendido: " + this.encendido);
		System.out.println("velocidad: " + this.velocidad);
		System.out.println("velocidad Maxima: " + this.velocidadMaxima);
		System.out.println("-------------------------------");
	}
	
}
