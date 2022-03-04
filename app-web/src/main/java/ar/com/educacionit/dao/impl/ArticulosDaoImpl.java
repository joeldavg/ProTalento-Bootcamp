package ar.com.educacionit.dao.impl;

import java.sql.Date;
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
		st.setString(1, entity.getTitulo());
		st.setString(2, entity.getCodigo());
		st.setDate(3, new Date(entity.getFechaCreacion().getTime()));
		st.setDouble(4, entity.getPrecio());
		st.setLong(5, entity.getStock());
		st.setLong(6, entity.getMarcaId());
		st.setLong(7, entity.getCategoriaId());
	}

	@Override
	public String getSaveSQL() {
		String sql = "(titulo,codigo,fecha_creacion,precio,stock,marcas_id,categorias_id) VALUES (?,?,?,?,?,?,?)";
		return sql;
	}

	@Override
	public void update(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setDouble(2, entity.getPrecio());
		st.setLong(3, entity.getStock());
		st.setLong(4, entity.getMarcaId());
		st.setLong(5, entity.getCategoriaId());
	}

	@Override
	public String getUpdateSQL() {
		String sql = "titulo = ?, precio = ?, stock = ?, marcas_id = ?, categorias_id = ?";
		return null;
	}
}
