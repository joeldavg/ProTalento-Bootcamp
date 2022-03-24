package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Users;

public class UserDaoImpl implements UserDao {

	@Override
	public Users getUserByUsername(String username) throws GenericException {
		
		String sql = "SELECT * FROM users WHERE username = '" + username +"'";
		
		Users entity = null;
		// connection
		try (Connection connection = AdministradorDeConexiones.obtenerConexion()) {

			try (Statement st = connection.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql)) {

					List<Users> list = DTOUtils.populateDTOs(Users.class, rs);

					if (!list.isEmpty()) {
						entity = list.get(0);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql, e);
		}

		return entity;
	}

}
