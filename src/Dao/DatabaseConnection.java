package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseConnection {
	
	private String url = "jdbc:mysql://localhost:3306/mmcb" ;
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
	
	
//
//    try
//    {
//      //étape 1: charger la classe de driver
//    //  Class.forName("com.mysql.jdbc.Driver");
//      //étape 2: créer l'objet de connexion
//      Connection conn = DriverManager.getConnection(
//      "jdbc:mysql://localhost:3306/mmcb", "root", "root");
//      //étape 3: créer l'objet statement 
//      java.sql.Statement stmt = conn.createStatement();
//      ResultSet res = stmt.executeQuery("SELECT * FROM compte where icompte=`"id"`");
//      //étape 4: exécuter la requête
//      while(res.next()) {
//    	  
//    	  
//        System.out.println(res.getInt(1)+"  "+res.getString(2)
//        +"  "+res.getString(3));
//      //étape 5: fermez l'objet de connexion
//      
//    }
//      conn.close();
//    }
//    catch(Exception e){ 
//      System.out.println(e);
//    }

	


}
