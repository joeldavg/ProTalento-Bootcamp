package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String claveBusqueda = req.getParameter(ViewKeysEnums.CLAVE_BUSQUEDA.getParam());
		
		ArticulosService articulosService = new ArticulosServiceImpl();
		
		List<Articulos> listado = new ArrayList<>();
		try {
//			listado = articulosService.findAll();
//			//pero, debo filtrar por la clave
//			listado.stream().filter(articulo -> articulo.getTitulo().contains(claveBusqueda));
			
			listado = articulosService.findByTitle(claveBusqueda);
			
			Double total = listado.stream()
				.map(x -> x.getPrecio())
				.reduce(0d, (x, y) -> x + y);
			
			req.getSession().setAttribute(ViewKeysEnums.TOTAL.getParam(), total);
			req.getSession().setAttribute(ViewKeysEnums.LISTADO.getParam(), listado);
			getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getParam()).forward(req, resp);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
//		req.setAttribute("listado", listado);
//		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
	
}
