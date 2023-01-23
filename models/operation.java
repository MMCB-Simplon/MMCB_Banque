package models;

import java.sql.Date;
import java.time.LocalDateTime;

public class operation {

	private int iduser;
	private  Date date;
	private String typeOperation;
	private Double montantOperation;
	private int numeroCompteSource;
	
	@Override
	public String toString() {
		return "operation [iduser=" + iduser + ", date=" + date + ", typeOperation=" + typeOperation
				+ ", montantOperation=" + montantOperation + ", numeroCompteSource=" + numeroCompteSource
				+ ", numeroComptedestination=" + numeroComptedestination + "]";
	}
	private int numeroComptedestination;
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public Double getMontantOperation() {
		return montantOperation;
	}
	public void setMontantOperation(Double montantOperation) {
		this.montantOperation = montantOperation;
	}
	public int getNumeroCompteSource() {
		return numeroCompteSource;
	}
	public void setNumeroCompteSource(int numeroCompteSource) {
		this.numeroCompteSource = numeroCompteSource;
	}
	public int getNumeroComptedestination() {
		return numeroComptedestination;
	}
	public void setNumeroComptedestination(int numeroComptedestination) {
		this.numeroComptedestination = numeroComptedestination;
	}
	
}
