package ar.com.educacionit.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.ArticulosDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Socios;

public class ArticulosDaoImpl extends JdbcDaoBase<Articulos> implements ArticulosDao {

	public ArticulosDaoImpl() {
		super("articulos");
	}

	@Override
	public void save(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1, entity.getTitulo());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new Date(entity.getFechaCreacion().getTime()));
		pst.setDouble(4, entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6, entity.getMarcasId());
		pst.setLong(7, entity.getCategoriasId());
	}

	@Override
	public String getSaveSQL() {
		String sql = "(titulo,codigo,fecha_creacion,precio,stock,marcas_id,categorias_id) VALUES (?,?,?,?,?,?,?)";
		return sql;
	}

	@Override
	public void update(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1, entity.getTitulo());
		pst.setDouble(2, entity.getPrecio());
		pst.setLong(3, entity.getStock());
		pst.setLong(4, entity.getMarcasId());
		pst.setLong(5, entity.getCategoriasId());
	}

	@Override
	public String getUpdateSQL() {
		String sql = "titulo = ?, precio = ?, stock = ?, marcas_id = ?, categorias_id = ?";
		return sql;
	}

	public List<Articulos> findByTitle(String sql) throws GenericException {
		
		String where = "SELECT * FROM articulos WHERE titulo like '%" + sql + "%'";
		
		return super.findBySQL(where);
	}

}
