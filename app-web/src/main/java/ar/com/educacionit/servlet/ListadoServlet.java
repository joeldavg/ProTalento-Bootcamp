package ar.com.educacionit.servlet;

import java.io.IOException;
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

/**
 * LOS SERVLET NO TIENEN EL METODO main, PORQUE NO SON DE TIPO CONSOLA, SINO WEB
 * @author Joel Guzman
 *
 */

@WebServlet("/ListadoServlet")
public class ListadoServlet extends HttpServlet {
	
	ArticulosService articulosService = new ArticulosServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Llegue al servlet /listado que escucha y atiendo por POST");
		resp.getWriter().print("Hola FrontEnd, soy el BackEnd y atendi tu solicitud por POST");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Articulos> articulos = articulosService.findAll();
			
			// guardar el listado en un lugar llamado "request"
			
			request.setAttribute("LISTADO", articulos);
			
			// ahora anda a la otra pagina y pasale la lista de articulos
			
			getServletContext().getRequestDispatcher("/listado.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
