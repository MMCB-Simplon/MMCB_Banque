package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import models.CompteCourantModel;
import models.CompteEpargneModel;
import models.CompteModel;

public class CompteDAO extends DatabaseConnection {

	Connection con;

	public List<CompteModel> readListeCompte() {

		List<CompteModel> listcomptes = new Vector<CompteModel>();
		 con = this.BDDconnection();
		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");

			while (res.next()) {
				CompteModel compte = new CompteModel();
				compte.setNumerocompte(res.getInt(1));
				compte.setPrenom(res.getString(2));
				compte.setNom(res.getString(3));
				compte.setSolde(res.getDouble(4));
				compte.setIdUser(res.getInt(5));
				compte.setTypeCompte(res.getString(6));

				listcomptes.add(compte);
				
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return listcomptes;
	}

	public void readCompte() {
		 con = this.BDDconnection();

		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");
			while (res.next()) {
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertCompte(int numerocompte, int iduser, String nom, String prenom, double solde, String typecompte) {

		 con = this.BDDconnection();

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

	public void deleteCompte(int numerocompte) {
		 con = this.BDDconnection();

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
		 con = this.BDDconnection();

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
		 con = this.BDDconnection();
		String soldeEtFrais = "";

		CompteModel compte = new CompteModel();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT solde FROM compte  WHERE numerocompte = " + numerocompte + "");
			while (res.next()) {


				compte.setSolde(res.getDouble(1));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return compte;
	}

	public int getIduser()

	{ con = this.BDDconnection();

		int iduser = 0;
		
		try {
			java.sql.Statement stmt = con.createStatement();
			String lastUser = "select MAX(iduser) from user";
			ResultSet rs = stmt.executeQuery(lastUser);
			rs = stmt.executeQuery(lastUser);
			while (rs.next()) {
				if (rs.getInt(1) != 0) {
					iduser = rs.getInt(1);
					
				}
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return iduser;

	}

	public String getLibelleCompte(int numerocompte) {
		 con = this.BDDconnection();
		String libelle = "";

		try {
			java.sql.Statement stmt = con.createStatement();

			String getLibelle = "select prenom, nom  from compte where numerocompte = " + numerocompte + "";
			ResultSet rs = stmt.executeQuery(getLibelle);
			rs = stmt.executeQuery(getLibelle);
			while (rs.next()) {
				libelle = rs.getString(1) + "_" + rs.getString(2);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return libelle;

	}

	public int getGeneratedNumCompte() {

		Connection con = this.BDDconnection();
		int numerocompte = 100000;
		
		  int range = (999999 - 100000) + 1;
		  numerocompte= (int)(Math.random()*range)+100000;
		 
		 
	
	String sqlrandom = "select (numerocompte) from compte";

		try {
			

			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlrandom);
			Boolean isfund=false;  
			
			do {
				
				
				while (rs.next()) {
					
					if (rs.getInt(1) == numerocompte) {
						 isfund=true;
						 numerocompte= (int)(Math.random()*range)+100000;  
					}
					
				} 
				
				
			}while(isfund);
			
			
		

		} catch (Exception e) {
			System.out.println(e);
		}
		return numerocompte;

	}

	public boolean crediter(int numerocompte, double montant, String typeCompte) {

		double nouveauSolde = 0;
		boolean isCredited = false;

		CompteModel compte = new CompteModel();
		compte = getSoldeFromDatabase(numerocompte);
		nouveauSolde = compte.getSolde() + montant;
		if (typeCompte.equals("courant") && nouveauSolde < 100000)

		{
			updateCompte(numerocompte, nouveauSolde);
			isCredited = true;

		} else if (CompteEpargneModel.getPlafond() > nouveauSolde && nouveauSolde < 100000) {
			updateCompte(numerocompte, nouveauSolde);
			isCredited = true;

		}

		return isCredited;
	}

	public Boolean debiter(int numerocompte, double montant) {

		 con = this.BDDconnection();
		double nouveauSolde = 0;
		boolean isDebited = false;

		CompteModel compte = new CompteModel();
		compte = getSoldeFromDatabase(numerocompte);
		nouveauSolde = compte.getSolde() - montant;
		if (nouveauSolde > 0)

		{
			updateCompte(numerocompte, nouveauSolde);
			isDebited = true;

		}

		return isDebited;

	}

	public boolean transfert(int numerocompte1, int numerocompte2, Double montant, String typecompte) {
		double nouveausolde1 = 0;
		double nouveausolde2 = 0.0;
		boolean istransfered = false;
		boolean soldeSupr = false;

		CompteModel compte1 = new CompteModel();
		CompteModel compte2 = new CompteModel();

		compte1 = getSoldeFromDatabase(numerocompte1);
		compte2 = getSoldeFromDatabase(numerocompte2);

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

			
		}

		else {
			istransfered = false;
		}
		return istransfered;
	}

	
}
