package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;

public class MarcasDaoImpl extends JdbcDaoBase<Marcas> implements MarcasDao {

	public MarcasDaoImpl() {
		super("marcas");
	}

	@Override
	public String getSaveSQL() {
		
		//lo particular del sql
		String sql = "(descripcion,codigo,habilitada) VALUES (?,?,?)"; 
		
		return sql;
	}

	@Override
	public void save(PreparedStatement st, Marcas entity) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setString(2, entity.getCodigo());
		st.setLong(3, entity.getHabilitada());
		
	}

	@Override
	public void update(PreparedStatement st, Marcas entity) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setLong(2, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL() {
		String sql = "descripcion = ?, habilitada = ?";
		
		return sql;
	}


}
