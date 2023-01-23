package DAOInterfaces;

import java.util.List;

import models.CompteModel;

public interface CompteDAOInterface {

	public boolean crediter(int iduser, int numerocompte, double montant, String typeCompte) ;
	public Boolean debiter(int iduser, int numerocompte, double montant);
	
	public void insertCompte(int numerocompte, int iduser, String nom, String prenom, double solde, String typecompte);
	
	public void deleteCompte(int numerocompte);
	public CompteModel getSoldeFromDatabase(int numerocompte);
	
	public int getIduser();
	
	public String getLibelleCompte(int numerocompte);
	
	public int getGeneratedNumCompte();
	public void updateCompte(int iduser, int numerocompte, double solde);

	public boolean transfert(int iduser, int numerocompte1, int numerocompte2, Double montant, String typecompte);
	public List<CompteModel> readListeCompte();
}
