package ar.com.educacionit.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public CSVFileParser(Part filePart) {
		super(filePart);
	}

	public CSVFileParser(String path) {
		super(path);
	}

	public Collection<Articulos> parse() throws ParseException {

		InputStream is = null;
		BufferedReader br = null;
		FileReader fileReader = null;

		try {
			// detectar si tiene path como String o Part
			if (this.filePart != null) {
				is = filePart.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
			} else {
				File file = new File(super.getFilePath());

				if (!file.exists()) {
					throw new ParseException("No existe el archivo: " + super.getFilePath());
				}
				fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
			}

			return buildArchivos(br);

		} catch (Exception e) {
			throw new ParseException(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				throw new ParseException(e);
			}
		}

	}

	private Collection<Articulos> buildArchivos(BufferedReader br) throws IOException {

		Collection<Articulos> articulos = new ArrayList<>();
		
		// leer la primera linea y la descarto
		String lineaLeida = br.readLine();
		// vuelvo a leer para tomar los "registros"
		lineaLeida = br.readLine();
		
		Date fechaCreacion = new Date();
		while (lineaLeida != null) {
			// titulo;codigo;precio;stock;categoria;marca;
			String[] datos = lineaLeida.split(";");

			String titulo = datos[0];
			String codigo = datos[1];
			Double precio = Double.parseDouble(datos[2]);
			Long stock = Long.parseLong(datos[3]);
			Long categoriaId = Long.parseLong(datos[4]);
			Long marcaId = Long.parseLong(datos[5]);

			// creo constructor
			Articulos unArticulo = new Articulos(titulo, fechaCreacion, codigo, precio, stock, marcaId, categoriaId);

			articulos.add(unArticulo);

			lineaLeida = br.readLine();
		}

		return articulos;
	}

}
