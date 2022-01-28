package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SociosDaoImpl extends JdbcDaoBase<Socios> implements SociosDao {

	public SociosDaoImpl() {
		super("socios");// es la tabla
	}

	@Override
	public String getSaveSQL() {
		
		//lo particular del sql
		
		String sql = "(nombre,apellido,email,direccion,paises_id,fecha_alta) VALUES (?,?,?,?,?,?)";

		return sql;
	}

	@Override
	public void save(PreparedStatement st, Socios entity) throws SQLException {
		// TODO Auto-generated method stub
		st.setString(1, entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setString(4, entity.getDireccion());
		st.setLong(5, entity.getPaisesId());
		st.setDate(6, new java.sql.Date(new Date().getTime()));
	}

	@Override
	public String getUpdateSQL() {
		
		String sql = "nombre = ?, apellido = ?, email = ?, paises_id = ?";
	
		return sql;
	}


	@Override
	public void update(PreparedStatement st, Socios entity) throws SQLException {
		// TODO Auto-generated method stub
		st.setString(1, entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setLong(4, entity.getPaisesId());
	}
	
	
}
