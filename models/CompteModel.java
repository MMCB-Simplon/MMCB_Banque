package models;

public class CompteModel {

	private int numerocompte;
	private String nom;
	private String prenom;
	private double solde;
	private String libelle;
	private String typeCompte;
	private int idUser; 

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getSolde() {
		return solde;
	}
	@Override
	public String toString() {
		return "Compte [numerocompte=" + numerocompte + ", nom=" + nom + ", prenom=" + prenom + ", solde=" + solde
				+ ", libelle=" + libelle + ", typeCompte=" + typeCompte + "]";
	}
	public void createLibelle() {
		libelle=nom+"_"+ prenom;
	}   
	public int getNumerocompte() {
		return numerocompte;
	}

	public void setNumerocompte(int numerocompte) {
		this.numerocompte = numerocompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
