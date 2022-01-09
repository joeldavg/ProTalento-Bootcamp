package ar.com.educacionit.exeptions;

public class ConexionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion c = new Conexion();
		
		try {
			c.open();
			
			c.close();
			
			c.commit();
		} catch (ConnectionIsAlreadyOpenExeption | ConnectionIsNotOpenException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (ConnectionIsNotOpenException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
