package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import conexion.Conexion;
import dao.HuespedDAO;
import dao.ReservaDAO;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	   public ReservaController() {
	        var factory = new Conexion(); 
	        this.reservaDAO = new ReservaDAO(factory.getConnection());
	    }
	   
	   public void registrarReserva(LocalDate fecEntrada, LocalDate fecSalida, int total,String formaPago) throws SQLException {
		   reservaDAO.registrarReserva(fecEntrada, fecSalida, total,formaPago);
	   }
}
