package controllers;
import models.CompteModel;
import models.CompteCourantModel;
import models.CompteEpargneModel;
import views.*;
public class Operation {
	private CompteModel compte;
	
	public double crediter( int numerocompte,double montant,double solde) {
		return solde+montant;
		}
	
	public double debiter( int numerocompte,double montant,double solde) {
		return solde-montant;
		}
	
	public void transfertCourant(CompteCourantModel compte1,CompteModel compte2,double montant) {
		double nouveausolde1=0;
		double nouveausolde2=0.0;

		nouveausolde1 = compte1.getSolde()-compte1.getFraisTransfert()-montant;
		compte1.setSolde(nouveausolde1);
		
		nouveausolde2=compte2.getSolde()+ montant;
		compte2.setSolde(nouveausolde2);
		
				
		
		
	}
	
	public double modifier (int numerocompte, double montant, double solde) {
		
		return solde = montant;
	}
	
		
	

}
