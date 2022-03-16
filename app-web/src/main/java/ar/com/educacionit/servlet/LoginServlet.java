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
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturo los parametros enviados por el html/jsp
		String username = req.getParameter(LoginViewEnum.USERNAME.getParam());
		String password = req.getParameter(LoginViewEnum.PASSWORD.getParam());

		// LOGIN SERVICE
		LoginService loginService = new LoginServiceImpl();
		
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		try {
			Users user = loginService.getUserByUsername(username);

			if (user != null) {
				// hash password que viene del html y compararlo con el que tiene el usuario
				Result result = BCrypt.verifyer()
						.verify(password.getBytes(), user.getPassword().getBytes());
				
				if (!result.verified) {
					//login.jsp con algun mensaje de error
					target = ViewEnums.LOGIN;
				}
			} else {
				//login.jsp con algun mensaje de error
				target = ViewEnums.LOGIN;
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			target = ViewEnums.ERROR_GENERAL;
		}
		// ir a target
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
		
	}

}
