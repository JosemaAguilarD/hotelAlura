package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;


public class Conexion {
	
	  	private static final String url = "jdbc:mysql://localhost/alurahotel";
	    private static final String username = "root";
	    private static final String password = "12345";

	    public static Connection getConnection(){
	        try {
				System.out.println("Conexión exitosa");

				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Error en la conexión");
	            throw new RuntimeException(e);
			}
	    }

	   
		  
}




