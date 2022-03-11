package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.impl.SociosDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class LoginServiceImpl implements LoginService {
	
	private UserDao userDao;
	private SociosDao sociosDao;
	
	public LoginServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.sociosDao = new SociosDaoImpl();
	}

	@Override
	public Users getUserByUsername(String username) throws ServiceException {
		return null;
	}

}
