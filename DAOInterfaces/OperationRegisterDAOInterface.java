package DAOInterfaces;

import java.util.Vector;

public interface OperationRegisterDAOInterface {
	public void operationsInsert(int iduser, String typeop, double montant, int numComptesource, int numComptedes);
	public Vector<String> getOperations();

}
