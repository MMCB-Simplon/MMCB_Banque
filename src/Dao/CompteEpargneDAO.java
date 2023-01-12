package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CompteEpargneDAO extends DatabaseConnection {
		Connection con = this.BDDconnection();
	
	public void readEpargne () {

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmcb", "root", "");

			java.sql.Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compteepargne");

			while (res.next()) {

				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
