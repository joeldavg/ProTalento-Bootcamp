package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.dto.LoginDTO;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.ViewKeysEnums;
import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//viene el JSON desde la jsp
		String data = req.getParameter("data");
		
		LoginDTO loginDTO = objectMapper.readValue(data, LoginDTO.class);
		
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;

		// VALIDACIONES
		if (isValid(loginDTO.getUsername(), loginDTO.getPassword())) {

			// LOGIN SERVICE
			LoginService loginService = new LoginServiceImpl();

			Users user;
			try {
				user = loginService.getUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

				if (user != null) {
					// seccion
					req.getSession().setAttribute(ViewKeysEnums.USER.getParam(), user);
				} else {
					req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(),
							ViewKeysEnums.USUARIO_PASSWORD_INVALIDO.getParam());
					target = ViewEnums.LOGIN;
				}
			} catch (ServiceException e) {
				req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(), e.getMessage());
				target = ViewEnums.LOGIN;
			}
		} else {
			// crear una tabla de mapeo de errores clave - valor
			req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(),
					ViewKeysEnums.USUARIO_PASSWORD_INVALIDO.getParam());
			target = ViewEnums.LOGIN;
		}

		// ir a target
		getServletContext().getRequestDispatcher(target.getParam()).forward(req, resp);
	}

	private boolean isValid(String usernameFromHtml, String passwordFromHtml) {
		return (usernameFromHtml != null && !usernameFromHtml.isBlank())
				&& (passwordFromHtml != null && !passwordFromHtml.isBlank());
	}
}
