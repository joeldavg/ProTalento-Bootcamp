package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnums;

@WebServlet("/controllers/CargarProductosServlet")
public class CargarProductosServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1 - tomo los datos del session (que esta dentro del request)
		Collection<Articulos> articulosPreview = (Collection<Articulos>) req.getSession()
				.getAttribute(ViewKeysEnums.UPLOAD_PREVIEW_KEY.getParam());

		// validaciones
		if (articulosPreview == null || articulosPreview.isEmpty()) {
			req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(), "No hay datos a procesar");
			super.redirect(ViewEnums.UPLOAD_PREVIEW, req, resp);
		}

		ArticulosService articulosService = new ArticulosServiceImpl();

		List<Articulos> oks = new ArrayList<>();
		List<Articulos> fails = new ArrayList<>();

		// Persistir los datos en la db por medio del servicio Articulos
		for (Articulos articulo : articulosPreview) {
			try {
				articulosService.save(articulo);
				oks.add(articulo);
			} catch (ServiceException e) {
				fails.add(articulo);
			}
		}
		// una vez procesado todos los articulos, limpio la session
		req.getSession().removeAttribute(ViewKeysEnums.UPLOAD_PREVIEW_KEY.getParam());
		
		//Guardo las listas en request/session
		addAttribute(req, ViewKeysEnums.ARTICULOS_OKS, oks);
		addAttribute(req.getSession(), ViewKeysEnums.ARTICULOS_FAILS, fails);

		// redirect
		super.redirect(ViewEnums.RESULTADO_PREVIEW, req, resp);
	}

}
