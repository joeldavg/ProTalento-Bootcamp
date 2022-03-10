package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class TestXLSXParserAndInsert {
	
	public static void main(String[] args) {
		
		String path = "./src/main/java/ar/com/educacionit/generic/articulos.xlsx";
		
		IParser<Collection<Articulos>> xlsxParser = new XLSXFileParser(path);
		
		ArticulosService articulosService = new ArticulosServiceImpl();
		
		try {
			Collection<Articulos> articulos = xlsxParser.parse();
			for (Articulos articulo : articulos) {
				articulosService.save(articulo);
				System.out.println("Se registro con exito en la DB");
			}
		} catch (ParseException | ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
