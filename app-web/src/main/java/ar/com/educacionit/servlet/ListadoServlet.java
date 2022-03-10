package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LOS SERVLET NO TIENEN EL METODO main, PORQUE NO SON DE TIPO CONSOLA, SINO WEB
 * @author Joel Guzman
 *
 */

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Llegue al servlet /listado que escucha y atiendo por POST");
		resp.getWriter().print("Hola FrontEnd, soy el BackEnd y atendi tu solicitud por POST");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Llegue al servlet /listado que escucha y atiendo por GET");
		resp.getWriter().print("Hola FrontEnd, soy el BackEnd y atendi tu solicitud GET");
	}
	
}
