package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CompteCourantDAO extends DatabaseConnection {
	
	public void readCourant () {

		try {
			Connection con = this.BDDconnection();

			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM comptecourant");

			while (res.next()) {

				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
