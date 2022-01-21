package practica9.validation;

public class ValidarFormato {

	public Long validarLong(String next) throws InvalidFormatExeption {
		
		Long line = null;
		
		if (next.matches("[0-9]+")) {
			line = Long.parseLong(next);
		} else {
			throw new InvalidFormatExeption("Formato invalido: se permite solo numeros enteros");
		}
		
		return line;
	}
	
	public String validarString(String next) throws InvalidFormatExeption {
		
		String line = null;
		
		if (next.matches("[a-zA-Z]+")) {
			line = next;
		} else {
			throw new InvalidFormatExeption("Formato invalido: se permite solo letras");
		}
	
		return line;
	}
	
}
