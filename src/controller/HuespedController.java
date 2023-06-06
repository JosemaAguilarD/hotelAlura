package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import dao.HuespedDAO;

public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	   public HuespedController() {
	        var factory = new Conexion();
	        this.huespedDao = new HuespedDAO(factory.getConnection());
	    }
	  
	   public Boolean login(String usuario, String contrasena) throws SQLException {
		   
		   return huespedDao.login(usuario, contrasena);
	   }
	   
	
}
