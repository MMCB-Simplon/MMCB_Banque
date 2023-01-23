package DAOInterfaces;

public interface UserDAOInterface {
	
	public void readUser();
	
	public void insertUser ( String nom_prenom);
	
	public boolean getNomPrenomUser(String nomPrenom);
	public int  getIduser(String nomPrenom);

}
