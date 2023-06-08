package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaDAO {
	  private Connection con;
	  

	    public ReservaDAO(Connection con) {
	        this.con = con;
	    }
	    
	    public int registrarReserva(LocalDate fecEntrada, LocalDate fecSalida, int total,
	    		String formaPago) throws SQLException {
	    	
	    	PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO reservas (fechaEntrada, "
	    			+ "fechaSalida, valor, formaDePago) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
   	    
	    	preparedStatement.setObject(1, fecEntrada);
	    	preparedStatement.setObject(2, fecSalida);
	    	preparedStatement.setInt(3, total);
	    	preparedStatement.setString(4, formaPago);
	    	
	    	preparedStatement.executeUpdate();
	    	
	    	ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	    	int primaryKeyValue = -1;
	    	
	    	if (generatedKeys.next()) {
    	        primaryKeyValue = generatedKeys.getInt(1);
    	        return primaryKeyValue;

    	    }
	        return primaryKeyValue;


	    }
	    
	    public int obtenerUltimoId() {
            try {

	    	Statement statement = con.createStatement();
	    	String sql = "SELECT MAX(id) FROM reservas";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
            	
                int ultimoID = resultSet.getInt(1);
                return ultimoID+1;
            }
            else {
	            System.out.println("Error al obtener el último dato");
            }

				resultSet.close();
	            statement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;

	    }

		public Connection getCon() {
			return this.con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}
	    
}
