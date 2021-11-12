package clase3;

import java.util.Scanner;

public class If2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		// ingrese contraseña y usuario
		// si contraseña = "1234" y usuario = admin --> OK
		// de lo contrario "fail"
		
		String user;
		String password;
		
		user = "admin";
		password = "1234";
		
		if (user == "admin" && password == "1234") {
			System.out.println("ok");
		}
		else {
			System.err.println("fail");
		}
		
		teclado.close();
	}

}
