package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SociosDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewKeysEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

public class LoginServiceImpl implements LoginService {

	private UserDao userDao;
	private SociosDao sociosDao;

	public LoginServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.sociosDao = new SociosDaoImpl();
	}

	@Override
	public Users getUserByUsernameAndPassword(String username, String password) throws ServiceException {
		try {
			Users user = userDao.getUserByUsername(username);

			if (user != null) {
				// valido password
				Result result = BCrypt.verifyer().verify(password.getBytes(), user.getPassword().getBytes());
				if (!result.verified) {
					throw new ServiceException(ViewKeysEnums.USUARIO_PASSWORD_INVALIDO.getParam());
				}

				Socios socio = sociosDao.getSociosByUserId(user.getId());
				user.setSocio(socio);
			}
			return user;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
