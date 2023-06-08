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
	   
	   public int registrarReserva(LocalDate fecEntrada, LocalDate fecSalida, int total,String formaPago) throws SQLException {
		  int fkKey =  reservaDAO.registrarReserva(fecEntrada, fecSalida, total,formaPago);
		  return fkKey;
	   }
	   
	   
		public ReservaDAO getReservaDAO() {
			return this.reservaDAO;
		}

		public void setReservaDAO(ReservaDAO reservaDAO) {
			this.reservaDAO = reservaDAO;
		}
}
