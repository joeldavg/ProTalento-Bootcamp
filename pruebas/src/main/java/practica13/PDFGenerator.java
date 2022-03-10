package practica13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ar.com.educacionit.domain.Articulos;

public class PDFGenerator {
	
	private String path;
	
	public PDFGenerator(String path) {
		this.path = path;
	}

	public void createPDF(Collection<Articulos> articulos) {
		
		Document pdf = new Document();
		
		try {
			PdfWriter.getInstance(pdf, new FileOutputStream(path + "/reporteArticulos.pdf"));
			pdf.open();
			
			PdfPTable table = new PdfPTable(6);
			table.addCell("titulo");
			table.addCell("codigo");
			table.addCell("precio");
			table.addCell("stock");
			table.addCell("marcasId");
			table.addCell("categoriasId");
			
			// cargar lista articulos
			for (Articulos articulo : articulos) {
				table.addCell(articulo.getTitulo());
				table.addCell(articulo.getCodigo());
				table.addCell(articulo.getPrecio().toString());
				table.addCell(articulo.getStock().toString());
				table.addCell(articulo.getMarcaId().toString());
				table.addCell(articulo.getCategoriaId().toString());
			}
			
			pdf.add(table);
			
			pdf.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
