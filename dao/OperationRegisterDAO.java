package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

import models.CompteModel;
import models.operation;

public class OperationRegisterDAO  extends DatabaseConnection{

	
	private Connection con;

	public void operationsInsert(int iduser, LocalDateTime dateOp, String typeop, double montant, int numComptesource,
			int numComptedes) {

		Connection con = this.BDDconnection();

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
	
	public List<operation>  getOperations() {
		 con = this.BDDconnection();
		
		List<operation> listcomptes = new Vector<operation>();
		
		try {

			java.sql.Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM compte");

			while (res.next()) {
				System.out.println("bien executé");
				operation operation = new operation();
				operation.setIduser (res.getInt(1));
				
				operation.setDate(res.getDate(2));
				operation.setTypeOperation(res.getString(3));
				operation.setMontantOperation(res.getDouble(4));
				operation.setNumeroComptedestination(5);
				operation.setNumeroComptedestination(res.getInt(6));

				listcomptes.add(operation);
				// System.out.println(res.getInt(1) + " " + res.getString(2));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return listcomptes;

		
		
	}

}
