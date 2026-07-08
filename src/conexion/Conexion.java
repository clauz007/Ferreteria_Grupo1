package conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Conexion {
	
	private static Connection con;
	public static Connection getConexion() {
		try { 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BASEDATOS_FERRETERIA",
					"root", "4231");
			System.out.println("Conexión exitosa");
		}catch (Exception ex) {
			System.out.print("Error de conexíon: " + ex.getMessage());
		}
		return con;
		
	}
	
}
