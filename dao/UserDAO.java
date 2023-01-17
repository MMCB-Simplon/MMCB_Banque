package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.UserModel;

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
	
	public void insertUser ( String nom_prenom) {
		Connection con = this.BDDconnection();
		try {
			
			java.sql.Statement stmt =con.createStatement();
			
		UserModel user = new  UserModel();
		user.setRaison_sociale(nom_prenom);
		    String prenom="caroline";
			 stmt.executeUpdate("INSERT INTO user (nom_prenom) VALUES ('"+user.getRaison_sociale()+"')");
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		UserDAO user = new UserDAO();
		user.readUser();
		
		//user.insertUser();
	}
}
