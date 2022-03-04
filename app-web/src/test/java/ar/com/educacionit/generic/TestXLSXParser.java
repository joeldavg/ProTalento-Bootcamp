package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class TestXLSXParser {
	
	public static void main(String[] args) {
		
		String path = "./src/main/java/ar/com/educacionit/generic/articulos.xlsx";
		
		IParser<Collection<Articulos>> xlsxParser = new XLSXFileParser(path);
		
		try {
			Collection<Articulos> articulos = xlsxParser.parse();
			for (Articulos articulo : articulos) {
				System.out.println(articulo);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
