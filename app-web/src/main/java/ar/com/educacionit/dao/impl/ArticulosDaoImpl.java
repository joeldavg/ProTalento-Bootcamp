package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.ArticulosDao;
import ar.com.educacionit.domain.Articulos;

public class ArticulosDaoImpl extends JdbcDaoBase<Articulos> implements ArticulosDao {

	public ArticulosDaoImpl() {
		super("articulos");
	}

	@Override
	public void save(PreparedStatement st, Articulos entity) throws SQLException {
		
	}

	@Override
	public String getSaveSQL() {
		return null;
	}

	@Override
	public void update(PreparedStatement st, Articulos entity) throws SQLException {
		
	}

	@Override
	public String getUpdateSQL() {
		return null;
	}
}
