package clase8.oop.herencia;

public class Empleado extends Persona {
	
	//private
	
	private Integer id;
	
	
	public Empleado(String nombre, String apellido, String colorPelo, Integer id) {
		//antes de nacer el empleado, nace la pesona
		super(nombre, apellido, colorPelo);
		
		this.id = id;
		
		//cantidadOrejas = 3 ; // no se puede modificar valor -> final
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public void detalle() {
		// al padre hace!
		super.detalle();
		
		//muestra la propio
		System.out.println("Id: " + this.getId());
		
	}
	
	
}
