package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CategoriaDao;
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
	public void save(PreparedStatement st, Categorias entity) throws SQLException {
		
		st.setString(1, entity.getDescripcion());
		st.setString(2, entity.getCodigo());
		st.setLong(3, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL() {
		
		String sql = "descripcion = ?, habilitada = ?";
		
		return sql;
	}

	@Override
	public void update(PreparedStatement st, Categorias entity) throws SQLException {
		// TODO Auto-generated method stub
		st.setString(1, entity.getDescripcion());
		st.setLong(2, entity.getHabilitada());
	}

}
