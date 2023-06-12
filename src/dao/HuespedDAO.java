package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    public List<Object[]> listarHuespedes()  {
        String query = "SELECT * FROM huespedes";
        List<Object[]> huespedes = new ArrayList<>();

		try {
              Statement statement = con.createStatement();

			  ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	                // Obtener los valores de cada columna por su nombre o índice
	                int id = resultSet.getInt("id");
	                String nombre = resultSet.getString("nombre");
	                String apellido = resultSet.getString("apellido");
	                Date fechaNacimiento = resultSet.getDate("fechaNac");
	                String nacionalidad = resultSet.getString("nacionalidad");
	                String telefono = resultSet.getString("telefono");
	                int numeroReserva = resultSet.getInt("idReserva");

	                // Obtener otros valores aquí...

	                // Hacer algo con los valores obtenidos
	                    Object[] arreglo = new Object[7];
	                    arreglo[0] = id;
	                    arreglo[1] = nombre;
	                    arreglo[2] = apellido;
	                    arreglo[3] = fechaNacimiento;
	                    arreglo[4] = nacionalidad;
	                    arreglo[5] = telefono;
	                    arreglo[6] = numeroReserva;

	                    huespedes.add(arreglo);

	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return huespedes;
      
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
