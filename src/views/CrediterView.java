package views;
import java.util.Scanner;

import javax.swing.JFrame;

import controllers.Operation;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class CrediterView extends JFrame {
	private JTextField MontantCredit;
	public CrediterView() {
		getContentPane().setLayout(null);
		
		JButton btnValiderCredit = new JButton("Valider");
		btnValiderCredit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnValiderCredit.setBounds(203, 289, 132, 35);
		getContentPane().add(btnValiderCredit);
		
		MontantCredit = new JTextField();
		MontantCredit.setHorizontalAlignment(SwingConstants.CENTER);
		MontantCredit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		MontantCredit.setBounds(155, 213, 232, 35);
		getContentPane().add(MontantCredit);
		MontantCredit.setColumns(10);
		
		JLabel lblMontantLabelC = new JLabel("Montant : ");
		lblMontantLabelC.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantLabelC.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMontantLabelC.setBounds(155, 167, 232, 35);
		getContentPane().add(lblMontantLabelC);
	}
	
	public static void main (String [] args) {
		
//		Scanner sc =new Scanner(System.in);
//		
//		int numerocompte=123456;
//		double ancienSolde=10000.0;
//		
//		System.out.println("saisir le montant: ");
//		
//		double montant=sc.nextDouble();
//		Operation op =new Operation ();
//		
//	System.out.println("anciensolde="+ancienSolde+"nouveausolde="+op.crediter(numerocompte, montant,ancienSolde));
//		

		
		
		
	}
}
