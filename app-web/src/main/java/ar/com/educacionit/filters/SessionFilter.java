package ar.com.educacionit.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.web.enums.ViewKeysEnums;

@WebFilter(filterName = "SessionFilter", urlPatterns = "/controllers/*")
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 1- obterner usuario de la sesion

		// 2- url - "donde vamos" (/controller/servlet)
		HttpServletRequest req = (HttpServletRequest) request;

		String url = req.getRequestURI(); // http//localhost:8080/app-web/...

		String contextPath = req.getContextPath();
		// 3- definir rutas o urls a las cuales no se aplica este filtro

		List<String> validPaths = Arrays.asList(contextPath + "/controllers/");

		// 4- logica - redireccion
		HttpSession session = req.getSession(false);

		if (session == null) {
			req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(), "Debe Loguearse");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			Users loggedUser = (Users) req.getSession().getAttribute(ViewKeysEnums.USER.getParam());

			if (loggedUser != null) {
				// dejo que acceda al /controller/servlet...
				chain.doFilter(request, response);
			} else {
				req.setAttribute(ViewKeysEnums.ERROR_GENERAL.getParam(), "Debe Loguearse");
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
