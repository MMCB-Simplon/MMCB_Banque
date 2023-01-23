package DAOImplements;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAOInterfaces.UserDAOInterface;
import models.UserModel;

/*
 * Méthode permettant de générer et de gérer un User
 */

public class UserDAO extends DatabaseConnection implements UserDAOInterface {

	private int iduser;
	private String nom_prenom;
	Connection con;

	public void readUser() {
		 con = this.BDDconnection();
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
		 con = this.BDDconnection();
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
	
	
	public boolean getNomPrenomUser(String nomPrenom) {
		 con = this.BDDconnection();
		 String name = "";
		 Boolean verifName = false;
		try {
			java.sql.Statement stmt = con.createStatement();
			String getLibelle = "select nom_prenom from user where nom_prenom = '" + nomPrenom + "'";
			ResultSet rs = stmt.executeQuery(getLibelle);
			rs = stmt.executeQuery(getLibelle);
			while (rs.next()) {
				name = rs.getString(1);
				if(name != "") {
					verifName = true;
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return verifName;
	}


	public int  getIduser(String nomPrenom) {
		 con = this.BDDconnection();
		 int iduser =0;
		 Boolean verifName = false;
		try {
			java.sql.Statement stmt = con.createStatement();

			String getLibelle = "select iduser from user where nom_prenom = '" + nomPrenom + "'";
			ResultSet rs = stmt.executeQuery(getLibelle);
			rs = stmt.executeQuery(getLibelle);
			while (rs.next()) {
				iduser = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return  iduser;
		
	}

	
}
