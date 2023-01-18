package models;

public class CompteEpargneModel extends CompteModel {
	private final double tauxInteret = 1.2;
	private final static double plafond = 1000;

	public double getTauxInteret() {
		return tauxInteret;
	}

	public static  double getPlafond() {
		return plafond;
	}

}
