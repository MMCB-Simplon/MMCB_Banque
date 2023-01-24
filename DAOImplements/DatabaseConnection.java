package DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe à part nous permettant de nous connecter à la base de donnée
 */

public class DatabaseConnection {
	
	private String url = "jdbc:mysql://localhost/mmcb" ;
	private String user ="root";
	private String mot="root";
	
	
	public  Connection BDDconnection() {
		
		try {
			Connection conn = DriverManager.getConnection(url,user,mot);
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}

}
