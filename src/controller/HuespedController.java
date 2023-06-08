package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import conexion.Conexion;
import dao.HuespedDAO;

public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	   public HuespedController() {
	        var factory = new Conexion();
	        this.huespedDao = new HuespedDAO(factory.getConnection());
	    }
	   
	   public HuespedController(Connection conexion) {
	        this.huespedDao = new HuespedDAO(conexion);
	    }
	  
	   public Boolean login(String usuario, String contrasena) throws SQLException {
		   
		   return huespedDao.login(usuario, contrasena);
	   }
	   
	   public void registrarHuesped(String nombre, String apellido, LocalDate fecNacimiento, String Nacionalidad
			   , String telefono, int idReserva) throws SQLException {
		   huespedDao.registrarHuesped(nombre, apellido, fecNacimiento, Nacionalidad, telefono, idReserva);
	   }
	   
	
}
