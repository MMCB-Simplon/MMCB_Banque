package Dao;

import java.sql.*;

public class CompteDAO extends DatabaseConnection {
	
	Connection con;
	
	public void readCompte() {
		Connection con = this.BDDconnection();

		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");
			while (res.next()) {
				System.out.println(res.getInt(1)+ " " +res.getString(2)+ " "+res.getString(3)+" "+res.getDouble(4)+" "+res.getInt(5)+" "+res.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insertCompte() {
		Connection con = this.BDDconnection();
		int idcompte = 00007;
		String nom = "Manmanu";
		String prenom = "Valivali";
		int solde = 30203;
		int idbanque = 1;
		String typecompte = "courant";
		
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "INSERT INTO compte (idcompte, nom, prenom, solde,idbanque, typecompte) "
					+ "VALUES ("+idcompte+", '"+nom+"', '"+prenom+"', "+solde+", "+idbanque+", '"+typecompte+"')";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteCompte() {
		Connection con = this.BDDconnection();
		int idCompte = 903874;
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "DELETE FROM compte WHERE idcompte="+idCompte+"";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateCompte() {
		Connection con = this.BDDconnection();
		int idCompte = 847463;
		double solde = 5;
	
		try {	
			java.sql.Statement stmt = con.createStatement();
			String sql = "UPDATE compte SET solde = "+solde+" WHERE idcompte = "+idCompte+"";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {

		CompteDAO compteBanque = new CompteDAO();
		//compteBanque.readCompte();
		//compteBanque.insertCompte();
		//compteBanque.deleteCompte();
		//compteBanque.updateCompte();
	}

}
