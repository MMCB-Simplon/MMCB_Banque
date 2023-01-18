package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import models.CompteCourantModel;
import models.CompteEpargneModel;
import models.CompteModel;

public class CompteDAO extends DatabaseConnection {

	Connection con;

	public List<CompteModel> readListeCompte() {

		List<CompteModel> listcompte = new Vector<CompteModel>();
		Connection con = this.BDDconnection();
		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");

			while (res.next()) {
				System.out.println("bien executé");
				CompteModel compte = new CompteModel();
				compte.setNumerocompte(res.getInt(1));
				compte.setPrenom(res.getString(2));
				compte.setNom(res.getString(3));
				compte.setSolde(res.getDouble(4));
				compte.setIdUser(res.getInt(5));
				compte.setTypeCompte(res.getString(6));

				listcompte.add(compte);
				// System.out.println(res.getInt(1) + " " + res.getString(2));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return listcompte;
	}

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

	public void insertCompte(int numerocompte, int iduser, String nom, String prenom, double solde, String typecompte) {

		Connection con = this.BDDconnection();

		try {
			java.sql.Statement stmt = con.createStatement();

			if (numerocompte < 999999) {

				String sql = "INSERT INTO compte (numerocompte, nom, prenom, solde,iduser, typecompte) " + "VALUES ("
						+ numerocompte + ", '" + nom + "', '" + prenom + "', " + solde + ", " + iduser + ", '"
						+ typecompte + "')";
				stmt.executeUpdate(sql);

				if (typecompte.equals("courant")) {
					CompteCourantModel compte = new CompteCourantModel();
					sql = "INSERT INTO comptecourant (numerocompte ,frais_transfert,solde_minimun) " + "VALUES ("
							+ numerocompte + "," + compte.getFraisTransfert() + "," + compte.getSoldeMinimum() + ")";

				} else if (typecompte.equals("epargne")) {
					CompteEpargneModel compte = new CompteEpargneModel();
					sql = "INSERT INTO compteepargne (numerocompte ,tauxInterert,plafond) " + "VALUES (" + numerocompte
							+ "," + compte.getTauxInteret() + "," + compte.getPlafond() + ")";
				}

				stmt.executeUpdate(sql);

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

	public void updateCompte(int numerocompte, double solde) {
		Connection con = this.BDDconnection();

		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "UPDATE compte SET solde = " + solde + " WHERE numerocompte = " + numerocompte + "";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public CompteModel getSoldeFromDatabase(int numerocompte) {
		Connection con = this.BDDconnection();
		String soldeEtFrais = "";

		CompteModel compte = new CompteModel();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT solde FROM compte  WHERE numerocompte = " + numerocompte + "");
			while (res.next()) {

				System.out.println(res.getDouble(1));

				compte.setSolde(res.getDouble(1));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return compte;
	}

	public int getIduser()

	{

		int iduser = 0;
		Connection con = this.BDDconnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			String lastUser = "select MAX(iduser) from user";
			ResultSet rs = stmt.executeQuery(lastUser);
			rs = stmt.executeQuery(lastUser);
			while (rs.next()) {
				if (rs.getInt(1) != 0) {
					iduser = rs.getInt(1);
					System.out.println(iduser);
				}
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return iduser;

	}

	public int getGeneratedNumCompte() {

		Connection con = this.BDDconnection();
		int numerocompte = 100000;
		String sqlrandom = "select MAX(numerocompte) from compte";

		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlrandom);
			while (rs.next()) {
				if (rs.getInt(1) != 0)
					numerocompte = rs.getInt(1) + 1;
				System.out.println(numerocompte);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return numerocompte;

	}

	public boolean crediter(int numerocompte, double montant, double solde, String typeCompte) {
		Connection con = this.BDDconnection();
		double nouveauSolde = 0;
		boolean isCredited = false;
		
		CompteModel compte = new CompteModel();
		compte = getSoldeFromDatabase(numerocompte);
		nouveauSolde = compte.getSolde() + montant;
		
		if (typeCompte.equals("courant"))
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "UPDATE compte SET solde = " + nouveauSolde + " WHERE numerocompte = " + numerocompte + "";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return true;
	}

	public double debiter(int numerocompte, double montant, double solde) {
		return solde - montant;
	}

	public boolean transfert(int numerocompte1, int numerocompte2, Double montant, String typecompte) {
		double nouveausolde1 = 0;
		double nouveausolde2 = 0.0;
		boolean istransfered = false;
		boolean soldeSupr = false;

		CompteModel compte1 = new CompteModel();
		CompteModel compte2 = new CompteModel();

		compte1 = getSoldeFromDatabase(numerocompte1);
		compte2=getSoldeFromDatabase(numerocompte2);

		nouveausolde1 = compte1.getSolde() - CompteCourantModel.getFraisTransfert() - montant;
		if (nouveausolde1 > 0) {
			nouveausolde2 = compte2.getSolde() + montant;
			

			if (typecompte.equals("epargne") && nouveausolde2 < CompteEpargneModel.getPlafond()) {
				updateCompte(numerocompte2, nouveausolde2);
				updateCompte(numerocompte1, nouveausolde1);
				istransfered = true;
			} else if (typecompte.equals("courant")) {
				updateCompte(numerocompte2, nouveausolde2);
				updateCompte(numerocompte1, nouveausolde1);
				istransfered = true;
			} else
				istransfered = false;

			// updateCompte(compte2, nouveausolde2);
		}

		else {
			System.out.println("Montant saisi superieur au solde");
			istransfered = false;
		}
		return istransfered;
	}

	public double modifier(int numerocompte, double montant, double solde) {

		return solde = montant;
	}

	public static void main(String[] args) {

		ArrayList listeCompte = new ArrayList<CompteModel>();

		CompteDAO compteBanque = new CompteDAO();
		// compteBanque.readCompte();
		// compteBanque.insertCompte(); // String nom, String prenom,double solde,String
		// typecompte
		// compteBanque.deleteCompte();
		// compteBanque.updateCompte();
		// listeCompte = compteBanque.readListeCompte();

		System.out.println(listeCompte);

	}

}
