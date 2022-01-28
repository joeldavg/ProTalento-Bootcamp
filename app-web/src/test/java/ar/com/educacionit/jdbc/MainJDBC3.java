package ar.com.educacionit.jdbc;

import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;

public class MainJDBC3 {

	public static void main(String[] args) throws GenericException, SQLException, ServiceException {
		//Connection : conexion a la db con user y pass
		//Statement  // PrepareStatement: sql
		//ResultSet: datos (columnas / filas)
		/*
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sql = "delete * FROM categorias where id = ?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setLong(1, 101);
		
		pst.executeUpdate();
		
		connection.close();
		*/
		
		CategoriaService cs = new CategoriaServiceImpl();
		cs.delete(2l);
		
		System.out.println("FIN");
		
	}
	
}
