package views;

import java.util.Scanner;

import javax.swing.JFrame;

import controllers.Operation;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DebiterView extends JFrame {
	private JTextField textField;
	public DebiterView() {
		getContentPane().setLayout(null);
		
		JLabel lblMontantDebit = new JLabel("Montant :");
		lblMontantDebit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantDebit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMontantDebit.setBounds(172, 160, 238, 55);
		getContentPane().add(lblMontantDebit);
		
		textField = new JTextField();
		textField.setBounds(170, 233, 240, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
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
