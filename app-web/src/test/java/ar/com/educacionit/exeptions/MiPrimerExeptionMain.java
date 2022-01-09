package ar.com.educacionit.exeptions;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;

public class MiPrimerExeptionMain {
	
	public static void main(String[] args) throws Exception {
		
		// jvm > errores unchecked: el programador no debe preocuparse
		
		int a = 10;
		int b = 1;								 // java.lang.ArithmeticException
		int c = a/b;
		
		System.out.println(c);
		
		//ejemplo con objetos
		//Socios s = null;
		Socios s = new Socios();
		Long id = s.getId(); 					//java.lang.NullPointerException
		System.out.println(id);
		
		//herencia / interfaces
		Object socio = new Socios();	
		Categorias cat = (Categorias) socio;	 //java.lang.ClassCastException
		
		System.out.println(cat.getCodigo());
		
		/***************************************************/
		// jvm > obliga al programador a controlar las "checked exeption"
		
		//try {
			metodoConExeption(10);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}
	
	public static void metodoConExeption(int valor) throws Exception {
		
		if (valor == 0) {
			// lanzo una nueva exeption
			throw new Exception("el valor es erroneo");
		}
		
	}
	
}
