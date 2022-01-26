package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;

public class MainJDBC {

	public static void main(String[] args) throws GenericException, SQLException {
		//Connection : conexion a la db con user y pass
		//Statement  // PrepareStatement: sql
		//ResultSet: datos (columnas / filas)
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM categorias;");
		
		/*if (rs.next()) {
			Long id = rs.getLong(1);
			String descripcion = rs.getString(2);
			String codigo = rs.getString(3);
			Long habilitada = rs.getLong(4);
			
			Categorias categoria = new Categorias(id, descripcion, codigo);

			System.out.println(categoria);
		}*/
		
		Collection<Categorias> categorias = new ArrayList<>();
		
		while (rs.next()) {
			Long id = rs.getLong("id");
			String descripcion = rs.getString("descripcion");
			String codigo = rs.getString("codigo");
			Long habilitada = rs.getLong("habilitada");
			
			Categorias categoria = new Categorias(id, descripcion, codigo);
			categorias.add(categoria);
		}
		
		System.out.println(categorias);
		
		//socios
		rs = st.executeQuery("SELECT * FROM socios;");
		
		if (rs.next()) {
			Long id = rs.getLong("id");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String email = rs.getString("email");
			Date fechaAlta = rs.getDate("fecha_alta");
			String codigo = rs.getString(3);
			String direccion = rs.getString("direccion");
			Long paisId = rs.getLong("paises_id");
			
			Socios socios = new Socios(id, nombre, apellido, email, direccion, paisId);
			System.out.println(socios);

		}
		
		connection.close();
	}
	
}
