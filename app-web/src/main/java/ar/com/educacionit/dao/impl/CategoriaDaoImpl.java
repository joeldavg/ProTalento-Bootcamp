package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao {

	public CategoriaDaoImpl() {
		super("categorias");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSaveSQL() {
		
		//lo particular del sql
		String sql = "(descripcion,codigo,habilitada) VALUES (?,?,?)"; 
		
		return sql;
	}

	@Override
	public void save(PreparedStatement pst, Categorias entity) throws SQLException {
		
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL() {
		
		String sql = "descripcion = ?, habilitada = ?";
		
		return sql;
	}

	@Override
	public void update(PreparedStatement pst, Categorias entity) throws SQLException {
		// TODO Auto-generated method stub
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}

}
