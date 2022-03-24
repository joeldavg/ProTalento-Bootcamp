package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArticulosService articulosService = new ArticulosServiceImpl();
		
		List<Articulos> listado = new ArrayList<>();
		try {
			listado = articulosService.findAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("listado", listado);
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
	
}
