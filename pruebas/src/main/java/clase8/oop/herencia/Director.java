package clase8.oop.herencia;

public final class Director extends Persona {
	
	private Integer empACargo;

	public Director(String nombre, String apellido, String colorPelo, Integer empACargo) {
		super(nombre, apellido, colorPelo);
		this.empACargo = empACargo;
	}

	public Integer getEmpACargo() {
		return empACargo;
	}

	public void setEmpACargo(Integer empACargo) {
		this.empACargo = empACargo;
	}
	
	@Override
	public void detalle() {
		// TODO Auto-generated method stub
		super.detalle();
		System.out.println("Empleados a cargo: " + this.getEmpACargo());
	}
	
	public static void delegar(Empleado empleado, String tarea) {
		empleado.detalle();
		System.out.println("Ejecutando tarea delegada: " + tarea);
	}
	
}
