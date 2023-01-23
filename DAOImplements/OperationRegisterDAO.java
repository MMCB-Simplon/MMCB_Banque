package DAOImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
/*
 * Page contenant les méthodes d'enregistrement et de récupération des opérations 
 */

public class OperationRegisterDAO extends DatabaseConnection {

	private Connection con;

	public void operationsInsert(int iduser, String typeop, double montant, int numComptesource, int numComptedes) {
		Connection con = this.BDDconnection();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime today = LocalDateTime.now();
		String dateOp = dateformat.format(today);

		String sql = "INSERT  INTO operations(iduser,date,typeoperation,montantoperation,numerocomptesource,numerocomptedestination) VALUES ("
				+ iduser + ",'" + dateOp + "','" + typeop + "'," + montant + "," + numComptesource + "," + numComptedes
				+ ")";
		try {

			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Vector<String> getOperations() {
		con = this.BDDconnection();

		List<String> listoperations = new Vector<String>();

		String listItem = "";
		listoperations.add("utilisateur" + "      " + "DateOperation" + "      " + "TypeOperation" + "      "
				+ "Montant" + "      " + "CompteSource" + "            " + "CompteDestination");
		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM operations");

			while (res.next()) {

				listItem = res.getInt(1) + "                " + res.getString(2) + "               " + res.getString(3)
						+ "                " + res.getDouble(4) + "               " + res.getInt(5)
						+ "                 " + res.getInt(6) + "\n";

				listoperations.add(listItem);

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return (Vector<String>) listoperations;

	}

}
