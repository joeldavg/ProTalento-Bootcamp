package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnums;

@WebServlet("/controllers/EditarProductoServlet")
public class EditarProductoServlet extends BaseServlet {

	private ArticulosService articulosService = new ArticulosServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter(ViewKeysEnums.ID_ARTICULO_ACTUALIZAR.getParam());

		// datos a actualizar
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");

		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		Collection<Articulos> listado = (Collection<Articulos>) req.getSession()
				.getAttribute(ViewKeysEnums.LISTADO.getParam());

		if (id != null) {

			try {
				Articulos articulo = articulosService.getOne(Long.parseLong(id));
				articulo.setTitulo(titulo);
				articulo.setPrecio(Double.parseDouble(precio));

				articulosService.update(articulo);

				addAttribute(req, ViewKeysEnums.EXITO, "Se ha actualizado el articulo id = " + id);

				listado = listado.stream()
						.map(art -> art.getId().equals(articulo.getId()) ? articulo : art)
						.collect(Collectors.toList());

			} catch (NumberFormatException | ServiceException e) {
				addAttribute(req, ViewKeysEnums.ERROR_GENERAL, e.getMessage());
			} finally {
				addAttribute(req.getSession(), ViewKeysEnums.LISTADO, listado);

				Double total = listado.stream()
						.map(x -> x.getPrecio())
						.reduce(0d, (x, y) -> x + y);

				addAttribute(req.getSession(), ViewKeysEnums.TOTAL, total);
			}

		}

		// redirect target
		redirect(target, req, resp);

	}

}
