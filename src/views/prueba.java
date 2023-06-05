package views;

import java.sql.SQLException;

import conexion.Conexion;

public class prueba {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		var nuevaConexion =	conexion.getConnection();
		
			try {
				nuevaConexion.close();
				System.out.println("Conexión cerrada");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};

	}

}
