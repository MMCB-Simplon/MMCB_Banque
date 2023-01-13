package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private String url = "jdbc:mysql://localhost/mmcb" ;
	private String user ="root";
	private String mot="root";
	
	
	public  Connection BDDconnection() {
		
		try {
			Connection conn = DriverManager.getConnection(url,user,mot);
			System.out.println("connecté");
			return conn;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" pas connecté");
			e.printStackTrace();
			
			return null;
		}
		
	}

}
