package models;

import java.util.List;

public class UserModel {
	private String raison_sociale;
	private List<CompteModel> listecompte;


	public String getRaison_sociale() {
		return raison_sociale;
	}

	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}

	public List<CompteModel> getListecompte() {
		return listecompte;
	}

	public void setListecompte(List<CompteModel> listecompte) {
		this.listecompte = listecompte;
	}

}
