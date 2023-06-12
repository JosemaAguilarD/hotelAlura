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
	    
	    public List<Object[]> listarReservas()  {
            String query = "SELECT * FROM reservas";
            List<Object[]> reservas = new ArrayList<>();

			try {
	              Statement statement = con.createStatement();

				  ResultSet resultSet = statement.executeQuery(query);

		            while (resultSet.next()) {
		                // Obtener los valores de cada columna por su nombre o índice
		                int id = resultSet.getInt("id");
		                Date fechaEntrada = resultSet.getDate("fechaEntrada");
		                Date fechaSalida = resultSet.getDate("fechaSalida");
		                int valor = resultSet.getInt("valor");
		                String formaDePago = resultSet.getString("formaDePago");

		                // Obtener otros valores aquí...

		                // Hacer algo con los valores obtenidos
		                    Object[] arreglo = new Object[5];
		                    arreglo[0] = id;
		                    arreglo[1] = fechaEntrada;
		                    arreglo[2] = fechaSalida;
		                    arreglo[3] = valor;
		                    arreglo[4] = formaDePago;

		                    reservas.add(arreglo);

		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reservas;
          
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
