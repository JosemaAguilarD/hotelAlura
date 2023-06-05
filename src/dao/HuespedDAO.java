package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
