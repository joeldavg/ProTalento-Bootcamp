package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		
		String url = "jdbc:postgresql://ec2-3-222-204-187.compute-1.amazonaws.com:5432/d7p086p6n6ck5a?serverTimezone=UTC&userSSL=false";
		String user = "uuwihzidjulogs";
		String password = "dc814724ac7c56adb05df64561878a998d5fcf64e1f2e8c85ad126cb9a2ce972";
		//String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			//Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			throw new GenericException("Error obteniendo conexion: " + e.getMessage(), e);
		}
		
	}
	
	public static void main(String[] args) {
		try (Connection connection = AdministradorDeConexiones.obtenerConexion()) {
			System.out.println("Conexion obtenida");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
