package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {

//		String host = "ec2-44-194-69-15.compute-1.amazonaws.com";
//		String database = "d86dco3s4cbn67";
//		String user = "uihlfzqssvuuli";
//		String password = "5f870cbebd326229243453631cdb2d28c0c8dbee2f3a883d0bdf3845fd7ab2ae";
//		
//		String url = "jdbc:postgresql://" + host + ":5432/" + database;
//		String driverName = "org.postgresql.Driver";
//		// String driverName = "com.mysql.cj.jdbc.Driver";
		
		String url = System.getenv("DATABASE_URL");;
		String user = System.getenv("SPRING_DATASOURCE_USERNAME"); 
		String password = System.getenv("SPRING_DATASOURCE_PASSWORD"); 
		String driverName = System.getenv("SPRING_DATASOURCE_DRIVER");
		

		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
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
