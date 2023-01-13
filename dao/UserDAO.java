package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DatabaseConnection {

	private int iduser;
	private String nom_prenom;

	public void readUser() {
		Connection con = this.BDDconnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM user");
			while (res.next()) {
				System.out.println(res.getInt(1) + "  " + res.getString(2));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void insertUser () {
		Connection con = this.BDDconnection();
		try {
			
			java.sql.Statement stmt =con.createStatement();
			
			int iduser=40;
		    String prenom="caroline";
			 stmt.executeUpdate("INSERT INTO user VALUES ("+iduser+",'"+prenom+"')");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		UserDAO user = new UserDAO();
		user.readUser();
		
		user.insertUser();
	}
}
