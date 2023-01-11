package controllers;
import models.Compte;
import models.CompteCourant;
import models.CompteEpargne;
import views.*;
public class Operation {
	private Compte compte;
	
	public double crediter( int numerocompte,double montant,double solde) {
		
		return solde+montant;
		
		
	}
	
	public void transfertCourant(CompteCourant compte1,Compte compte2,double montant) {
		double nouveausolde1=0;
		double nouveausolde2=0.0;

		nouveausolde1 = compte1.getSolde()-compte1.getFraisTransfert()-montant;
		compte1.setSolde(nouveausolde1);
		
		nouveausolde2=compte2.getSolde()+ montant;
		compte2.setSolde(nouveausolde2);
		
				
		
		
	}
	
		
	

}
