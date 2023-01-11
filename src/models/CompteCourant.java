package models;

public class CompteCourant extends Compte{
	private final double fraisTransfert=2.0;
	private final double soldeMinimum=0.00;

	
	public double getFraisTransfert() {
		return fraisTransfert;
	}
	
	public double getSoldeMinimum() {
		return soldeMinimum;
	}
	
	public  static void main(String [] args) {
		CompteCourant cpc= new CompteCourant();
		cpc.setPrenom("mamadou");
		
		cpc.setSolde(35000);
		cpc.setTypeCompte("courant");
		System.out.println(cpc.getPrenom()+" "+cpc.getSolde()+" "+cpc.getTypeCompte());
		
	}

	
	
}
