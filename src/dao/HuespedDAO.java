package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HuespedDAO {
	
    private Connection con;
    
    public HuespedDAO(Connection con) {
        this.con = con;
    }
    
    public Boolean login(String nombreUsuario,String contrasena) throws SQLException{
    	String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
    	PreparedStatement declaracion = con.prepareStatement(consulta);
    	
    	declaracion.setString(1, nombreUsuario);
    	declaracion.setString(2, contrasena);
    	
    	ResultSet resultado = declaracion.executeQuery();
    	boolean loginExitoso = resultado.next();

    	    resultado.close();
    	    declaracion.close();
    	    con.close();

    	    return loginExitoso;
				
    }
    
    public void registrarHuesped(String nombre, String apellido, LocalDate fecNacimiento, 
    		String nacionalidad, String telefono, int idReserva) throws SQLException {
    	PreparedStatement preparedStatement = con.
    			prepareStatement("INSERT INTO huespedes (nombre, apellido, fechaNac, nacionalidad,"
    					+ " telefono, idReserva ) "
    					+ "VALUES (?, ?, ?, ?, ?, ?)");
    	  
                      
    	preparedStatement.setString(1, nombre);
    	preparedStatement.setString(2, apellido);
    	preparedStatement.setObject(3, fecNacimiento);
    	preparedStatement.setString(4, nacionalidad);
    	preparedStatement.setString(5, telefono);
    	preparedStatement.setInt(6, idReserva);
    
    	preparedStatement.executeUpdate();
    	
    	
    }
    
    
    
    
	
}
