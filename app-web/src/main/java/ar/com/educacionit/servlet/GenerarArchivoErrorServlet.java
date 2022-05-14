package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnums;

@WebServlet("/controllers/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends HttpServlet {

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);

		Collection<Articulos> articulosPreview = (Collection<Articulos>) req.getSession()
				.getAttribute(ViewKeysEnums.ARTICULOS_FAILS.getParam());

		// validaciones

		if (articulosPreview != null && !articulosPreview.isEmpty()) {

			String fileName = "listado-productos-error";

			String format = req.getParameter(ViewKeysEnums.FORMATO.getParam());

			// c:/desarrollo/educacionit/bootcamp
			String path = File.separator + "desarrollo" + File.separator + fileName + "." + format;

			File outputFile = new File(path);

			if (!outputFile.exists()) {
				Files.createFile(outputFile.toPath());
			}

			FileWriter fr = new FileWriter(outputFile);

			for (Articulos articulo : articulosPreview) {
				String lineFromArticulo = this.lineFromArticulo(articulo);
				fr.write(lineFromArticulo);
			}

			fr.close();

			// logica para descargar el archivo
			// y que el navegar entienda que es un file
			descargar(fileName, format, outputFile, resp);
		} else {

			req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(), "Sin datos ....");
			getServletContext().getRequestDispatcher(ViewEnums.RESULTADO_PREVIEW.getParam()).forward(req, resp);
			// resp.getWriter().print("No se ha podido generar el archivo: ");
		}

	}

	private void descargar(String fileName, String format, File outputFile, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/csv");

		String finalName = fileName + "." + format;

		resp.setHeader("Content-Disposition", "attachment; filename=\"" + finalName + "\"");

		try {
			OutputStream out = resp.getOutputStream();
			byte[] bytes = Files.readAllBytes(outputFile.toPath());
			out.write(bytes);
			out.flush();
			out.close();
		} catch (Exception e) {
			resp.getWriter().print("No se ha podido generar el archivo: " + finalName);
		}

	}

	private String lineFromArticulo(Articulos articulo) {
		StringBuffer linea = new StringBuffer();
		linea.append(articulo.getCodigo()).append(";");
		linea.append(articulo.getTitulo()).append(";");
		linea.append(articulo.getPrecio()).append(";");
		linea.append("\n");
		return linea.toString();
	}

}
