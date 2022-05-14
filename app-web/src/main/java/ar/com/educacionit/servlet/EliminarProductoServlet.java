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

@WebServlet("/controllers/EliminarProductoServlet")
public class EliminarProductoServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter(ViewKeysEnums.ID_ARTICULO_ELIMINAR.getParam());

		Collection<Articulos> listado = (Collection<Articulos>) req.getSession()
				.getAttribute(ViewKeysEnums.LISTADO.getParam());

		ViewEnums target = ViewEnums.LISTADO_GENERAL;

		if (id != null) {

			ArticulosService articulosService = new ArticulosServiceImpl();

			Long idLong = Long.parseLong(id);
			try {
				articulosService.delete(idLong);

				addAttribute(req, ViewKeysEnums.EXITO, "Se ha eliminado el articulo id = " + id);

				listado = listado.stream()
						.filter(articulo -> !articulo.getId().equals(idLong))
						.collect(Collectors.toList());
				
			} catch (ServiceException e) {
				addAttribute(req, ViewKeysEnums.ERROR_GENERAL, e.getMessage());
			} finally {
				// volver a cargar los articulos
				// eliminar de la sesscion el articulo puntual dado su id
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
