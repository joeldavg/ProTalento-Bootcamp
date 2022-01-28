package ar.com.educacionit.files;

import java.io.File;
import java.io.FileReader;

public class FileMain3 {

	public static void main(String[] args) {
		
		File aFile = new File("c:/carpeta/texto.txt"); //puntero
		
		if (aFile.exists()) {
			
			//lector
			try (FileReader fr = new FileReader(aFile)) {
				int dato;
				
				//leer mientras existan datos-...
				while ( (dato = fr.read()) != -1 ) {
					//valor ASCII
					System.out.print((char) dato);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
	
}
