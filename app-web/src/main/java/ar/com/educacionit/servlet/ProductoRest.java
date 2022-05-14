package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

@WebServlet("/rest/ProductoRest")
public class ProductoRest extends HttpServlet {

	private ArticulosService articulosService = new ArticulosServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
}
