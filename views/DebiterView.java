package views;

import java.util.Scanner;

import javax.swing.JFrame;

import controllers.Operation;

public class DebiterView extends JFrame {
	public static void main (String [] args) {
	
	Scanner sc =new Scanner(System.in);
	
	int numerocompte=123456;
	double ancienSolde=10000.0;
	
	System.out.println("saisir le montant: ");
	
	double montant =sc.nextDouble();
	Operation op =new Operation ();
	
System.out.println("anciensolde="+ ancienSolde + "nouveausolde :" + op.debiter(numerocompte, montant,ancienSolde));
	

}
}