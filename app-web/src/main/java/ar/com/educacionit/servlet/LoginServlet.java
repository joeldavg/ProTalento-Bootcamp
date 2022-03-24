package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.LoginViewEnum;
import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturo los parametros enviados por el html/jsp
		String usernameFromHtml = req.getParameter(LoginViewEnum.USERNAME.getParam());
		String passwordFromHtml = req.getParameter(LoginViewEnum.PASSWORD.getParam());

		// LOGIN SERVICE
		LoginService loginService = new LoginServiceImpl();

		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		Users user;
		try {
			user = loginService.getUserByUsernameAndPassword(usernameFromHtml, passwordFromHtml);

			if (user == null) {
				target = ViewEnums.LOGIN;
			} else {
				//request
				//req.setAttribute("usuario", user);
				//seccion
				req.getSession().setAttribute("usuario", user);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			target = ViewEnums.ERROR_GENERAL;
		}
		// ir a target
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}
}
