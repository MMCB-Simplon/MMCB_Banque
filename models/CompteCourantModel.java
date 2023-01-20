package models;

public class CompteCourantModel extends CompteModel{
	 private static final double fraisTransfert=2.0;
	 private  static final double soldeMinimum=10.00;

	
	public static  double getFraisTransfert() {
		return fraisTransfert;
	}
	
	public  static  double getSoldeMinimum() {
		return soldeMinimum;
	}
	
	public  static void main(String [] args) {
		CompteCourantModel cpc= new CompteCourantModel();
		cpc.setPrenom("mamadou");
		
		cpc.setSolde(35000);
		cpc.setTypeCompte("courant");
		System.out.println(cpc.getPrenom()+" "+cpc.getSolde()+" "+cpc.getTypeCompte());
		
	}

	
	
}
