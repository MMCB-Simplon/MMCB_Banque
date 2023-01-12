package views;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UserView extends JFrame {
	private JTextField txtEntrerVotreNom;
	public UserView() {
		
		txtEntrerVotreNom = new JTextField();
		txtEntrerVotreNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntrerVotreNom.setText("Entrer votre Nom et Prénom");
		txtEntrerVotreNom.setBackground(new Color(128, 64, 64));
		getContentPane().add(txtEntrerVotreNom, BorderLayout.CENTER);
		txtEntrerVotreNom.setColumns(10);
	}

}
