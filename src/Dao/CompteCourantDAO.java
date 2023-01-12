package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CompteCourantDAO extends DatabaseConnection {
		Connection con = this.BDDconnection();
	
	public void readCourant () {

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmcb", "root", "");

			java.sql.Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM comptecourant");

			while (res.next()) {

				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
