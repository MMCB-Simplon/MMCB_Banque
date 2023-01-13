package dao;

import java.sql.*;

public class CompteDAO extends DatabaseConnection {

	Connection con;

	public void readCompte() {
		Connection con = this.BDDconnection();

		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");
			while (res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " "
						+ res.getDouble(4) + " " + res.getInt(5) + " " + res.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertCompte() {
		Connection con = this.BDDconnection();
		int numerocompte = 100000;
		String nom = "Manmanu";
		String prenom = "Valivali";
		int solde = 30203;
		int iduser = 1;
		String sqlrandom = "select MAX(numerocompte) from compte";
		// select MAX(numerocompte) from comptecourant
		String typecompte = "epargne";

		double frais_transfert = 20.00;
		double solde_minimum = 10000.00;
		double tauxInterert = 20.00;
		double plafond = 10000.0;

		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlrandom);
			while (rs.next()) {
				if (rs.getInt(1) != 0)
					numerocompte = rs.getInt(1) + 1;
				System.out.println(numerocompte);

			}
			if (numerocompte < 999999) {

				String sql = "INSERT INTO compte (numerocompte, nom, prenom, solde,iduser, typecompte) " + "VALUES ("
						+ numerocompte + ", '" + nom + "', '" + prenom + "', " + solde + ", " + iduser + ", '"
						+ typecompte + "')";

				String sql2 = "";
				if (typecompte.equals("courant")) {
					sql2 = "INSERT INTO comptecourant (numerocompte ,frais_transfert,solde_minimun) " + "VALUES ("
							+ numerocompte + "," + frais_transfert + "," + solde_minimum + ")";

				} else if (typecompte.equals("epargne")) {
					sql2 = "INSERT INTO compteepargne (numerocompte ,tauxInterert,plafond) " + "VALUES (" + numerocompte
							+ "," + tauxInterert + "," + plafond + ")";
				}

				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCompte() {
		Connection con = this.BDDconnection();
		int numerocompte = 134526;
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "DELETE FROM compte WHERE numerocompte=" + numerocompte + "";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateCompte() {
		Connection con = this.BDDconnection();
		int numerocompte = 847463;
		double solde = 5;

		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "UPDATE compte SET solde = " + solde + " WHERE numerocompte = " + numerocompte + "";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		CompteDAO compteBanque = new CompteDAO();
		// compteBanque.readCompte();
		compteBanque.insertCompte();
		// compteBanque.deleteCompte();
		// compteBanque.updateCompte();
	}

}
