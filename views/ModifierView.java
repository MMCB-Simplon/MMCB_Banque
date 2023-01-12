package views;

import java.util.Scanner;

import javax.swing.JFrame;

import controllers.Operation;


public class ModifierView {
	
	public static void main (String [] args) {
		Scanner sc =new Scanner(System.in);
		int numerocompte=123456;
		double solde=10000.0;
		System.out.println("saisir le nouveau montant :");
		double montant=sc.nextDouble();
		Operation op =new Operation ();
	System.out.println("anciensolde= "+solde+"nouveausolde= "+op.modifier(numerocompte, montant,solde));
	
	}

}
