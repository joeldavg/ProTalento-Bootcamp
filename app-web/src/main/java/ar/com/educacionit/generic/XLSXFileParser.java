package ar.com.educacionit.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;

public class XLSXFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSXFileParser(Part filePart) {
		super(filePart);
	}

	public XLSXFileParser(String path) {
		super(path);
	}

	//implementar el metodo generico, PERO, dandole un tipo concreto 
	public Collection<Articulos> parse() throws ParseException {
		
		Collection<Articulos> articulos = new ArrayList<>();
		//libreria poi de apache
		
		//leer un binario
		File xlsxFile = new File(super.getFilePath());
		
		try (
				InputStream xlsxInputStream = new FileInputStream(xlsxFile);
				Workbook workbook = new XSSFWorkbook(xlsxInputStream)
			) {
			// clases propia de la libreria
			
			Sheet hoja0 = workbook.getSheetAt(0);
			
			//collection
			Iterator<Row> filasDeLaHoja0 = hoja0.iterator();
			
			boolean primeraFila = true;
			// TITULO CODIGO PRECIO STOCK ...
			
			while (filasDeLaHoja0.hasNext()) {
				Row currentRow = filasDeLaHoja0.next();
				
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
			
		} catch (IOException e) {
			throw new ParseException("No se pudo parsear el archivo: " + getFilePath(), e);
		}
		
		return articulos;
	}
	
	/**
	 * Recorre las celdas de una fila y por cada celda mira que atributo corresponde 
	 * en articulo y setea dicho valor
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
			articulo.setMarcasId((long) celdaActual.getNumericCellValue());
			break;
		case 5:
			articulo.setCategoriasId((long) celdaActual.getNumericCellValue());
			break;
		default:
			break;
		}
		articulo.setFechaCreacion(new Date());
		
	}
	
}
