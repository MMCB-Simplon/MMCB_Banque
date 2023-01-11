package models;

import java.util.List;

public class Banque {
	private String raison_sociale;
	private List<Compte> listecompte;


	public String getRaison_sociale() {
		return raison_sociale;
	}

	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}

	public List<Compte> getListecompte() {
		return listecompte;
	}

	public void setListecompte(List<Compte> listecompte) {
		this.listecompte = listecompte;
	}

}
