package models;

public class CompteEpargne extends Compte {
	private final double tauxInteret = 1.2;
	private final double plafond = 100000;

	public double getTauxInteret() {
		return tauxInteret;
	}

	public double getPlafond() {
		return plafond;
	}

}
