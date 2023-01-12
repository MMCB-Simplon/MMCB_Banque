package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UserDAO extends DatabaseConnection {

	// DatabaseConnection connect =new DatabaseConnection();
	Connection con = this.BDDconnection();

	private int iduser;
	private String nom_prenom;

	public void readUser() {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmcb", "root", "");
			java.sql.Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM user");
			while (res.next()) {
				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		UserDAO user = new UserDAO();
		user.readUser();
	}
}
