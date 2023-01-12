package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CompteEpargneDAO extends DatabaseConnection {
		
	
	public void readEpargne () {

		try {
			Connection con = this.BDDconnection();
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compteepargne");

			while (res.next()) {

				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
