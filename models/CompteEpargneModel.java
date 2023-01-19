package models;

public class CompteEpargneModel extends CompteModel {
	private final static double tauxInteret = 1.2;
	private final static double plafond = 10000;

	public static double getTauxInteret() {
		return tauxInteret;
	}

	public static  double getPlafond() {
		return plafond;
	}

}
