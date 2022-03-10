package practica13;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.ParseException;


public class XLSXParserAndPDFGeneratorTest {

	public static void main(String[] args) {
		
		String path = "./src/main/java/practica13";
		String pathXLSX = path + "/articulos.xlsx";
		
		
		IParser<Collection<Articulos>> xlsxParser = new XLSXFileParser(pathXLSX);
		
		Collection<Articulos> articulos = new ArrayList<>();
		
		try {
			articulos = xlsxParser.parse();
			for (Articulos articulo : articulos) {
				System.out.println(articulo);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PDFGenerator toPDF = new PDFGenerator(path);
		toPDF.createPDF(articulos);
		
	}

}
