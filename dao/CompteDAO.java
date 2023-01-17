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

	
	
	
	
	
	
	 public List <CompteModel>   readListeCompte () {
         
	     List  <CompteModel> listcompte= new Vector<CompteModel>();
	        Connection con = this.BDDconnection();
	        try {
	            

	            java.sql.Statement stmt = con.createStatement();
	            ResultSet res = stmt.executeQuery("SELECT * FROM compte");

	            while (res.next()) {
	                System.out.println("bien executé");
	                CompteModel compte=  new CompteModel();
	                compte.setNumerocompte(res.getInt(1));
	                compte.setPrenom(res.getString(2));
	                compte.setNom(res.getString(3));
	                compte.getSolde(res.getDouble(4));
	                compte.setIdUser(res.getInt(5));
	                compte.setTypeCompte(res.getString(6));
	                 
	         listcompte.add(compte);
	             //   System.out.println(res.getInt(1) + "  " + res.getString(2));

	            }
	            con.close();
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    return  listcompte;
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

	public void insertCompte() {
		Connection con = this.BDDconnection();
		int numerocompte = 100000;
		String nom = "Manmanu";
		String prenom = "Valivali";
		int solde = 30203;
		int iduser = 1;
		String sqlrandom = "select MAX(numerocompte) from compte";
		// select MAX(numerocompte) from comptecourant
		String typecompte = "courant";


		try {
/*
 * on recupere la valeur maximal des numero de compte
 *  
 *  
 *  */
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
				stmt.executeUpdate(sql);
				
				if (typecompte.equals("courant")) {
					CompteCourantModel compte = new CompteCourantModel();
					sql= "INSERT INTO comptecourant (numerocompte ,frais_transfert,solde_minimun) " + "VALUES ("
							+ numerocompte + "," + compte.getFraisTransfert() + "," + compte.getSoldeMinimum() + ")";

				} else if (typecompte.equals("epargne")) {
					CompteEpargneModel compte = new CompteEpargneModel();
					sql = "INSERT INTO compteepargne (numerocompte ,tauxInterert,plafond) " + "VALUES (" + numerocompte
							+ "," + compte.getTauxInteret() + "," + compte.getPlafond()+ ")";
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
//
//	public static void main(String[] args) {
//
//		ArrayList listeCompte = new ArrayList<CompteModel>();
//		
//		
//		CompteDAO compteBanque = new CompteDAO();
//		//compteBanque.readCompte();
//		//compteBanque.insertCompte();
//		// compteBanque.deleteCompte();
//		// compteBanque.updateCompte();
//		listeCompte = compteBanque.readListeCompte();
//		
//		System.out.println(listeCompte);
//		
//		
//	}

}
