package practica13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.BaseFile;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.ParseException;

public class XLSXFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSXFileParser(String path) {
		super(path);
	}

	// implementar el metodo generico, PERO, dandole un tipo concreto
	public Collection<Articulos> parse() throws ParseException {

		Collection<Articulos> articulos = new ArrayList<>();
		// libreria poi de apache

		// leer un binario
		File xlsxFile = new File(super.getPath());

		try (InputStream xlsxInputStream = new FileInputStream(xlsxFile);
				
				Workbook workbook = new XSSFWorkbook(xlsxInputStream)) {
				// clases propia de la libreria

				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					Sheet hoja = workbook.getSheetAt(i);
	
					// collection
					Iterator<Row> filasDeLaHoja = hoja.iterator();
	
					boolean primeraFila = true;
					// TITULO CODIGO PRECIO STOCK ...
	
					while (filasDeLaHoja.hasNext()) {
						Row currentRow = filasDeLaHoja.next();
	
						if (primeraFila) {
							primeraFila = false;
							continue;
						}
	
						Iterator<Cell> celdas = currentRow.iterator();
	
						// Articulos
						Articulos articulo = new Articulos();
	
						while (celdas.hasNext()) {
	
							fromCellToArticulos(celdas, articulo);
						}
	
						articulos.add(articulo);
					}
	
				}
			
		} catch (IOException e) {
			throw new ParseException("No se pudo parsear el archivo: " + getPath(), e);
		}

		return articulos;
	}

	/**
	 * Recorre las celdas de una fila y por cada celda mira que atributo corresponde
	 * en articulo y setea dicho valor
	 * 
	 * @param celdas
	 * @param articulo
	 */
	private void fromCellToArticulos(Iterator<Cell> celdas, Articulos articulo) {
		Cell celdaActual = celdas.next();

		switch (celdaActual.getColumnIndex()) {
		case 0:
			articulo.setTitulo(celdaActual.getStringCellValue());
			break;
		case 1:
			articulo.setCodigo(celdaActual.getStringCellValue());
			break;
		case 2:
			articulo.setPrecio(celdaActual.getNumericCellValue());
			break;
		case 3:
			articulo.setStock((long) celdaActual.getNumericCellValue());
			break;
		case 4:
			articulo.setMarcaId((long) celdaActual.getNumericCellValue());
			break;
		case 5:
			articulo.setCategoriaId((long) celdaActual.getNumericCellValue());
			break;
		default:
			break;
		}
		articulo.setFechaCreacion(new Date());

	}

}
