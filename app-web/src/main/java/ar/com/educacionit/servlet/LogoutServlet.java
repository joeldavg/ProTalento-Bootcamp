package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewKeysEnums;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//limpiar
		req.getSession().removeAttribute(ViewKeysEnums.USER.getParam());
		req.getSession().invalidate();
		
		//redirect a /
		resp.sendRedirect(getServletContext().getContextPath());
		
	}

}
