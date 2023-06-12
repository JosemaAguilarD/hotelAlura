package views;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import conexion.Conexion;
import dao.HuespedDAO;
import dao.ReservaDAO;

public class prueba {
	

	public static void main(String[] args) {
	    Conexion factory = new Conexion();

	    ReservaDAO reserva = new ReservaDAO(factory.getConnection());
	    HuespedDAO huesped = new HuespedDAO(factory.getConnection());
	    
	    List<Object[]> todosLosRegistros = reserva.listarReservas();

		System.out.println();
		for (Object[] valor : todosLosRegistros) {
	        System.out.println(valor[1]);
	    }

//	    try {
//			reserva.registrarReserva(LocalDate.of(2023,07,16),LocalDate.of(2023,07,18), "Efectivo");
//			System.out.println("Se registró correctamente");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Ocurrió un error");
//		}
	   
//	    try {
//	    	huesped.registrarHuesped("Josemaría", "Aguilar", LocalDate.of(1999,8,29), "peruana", "951094727", 4);
//	    	System.out.println("Se registró correctamente");
//	    } catch (SQLException e) {
//		e.printStackTrace();
//		System.out.println("Ocurrió un error");
//		}
//	    
//	    System.out.println(reserva.obtenerUltimoId());
	    
	}

}
