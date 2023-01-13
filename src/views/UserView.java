package views;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class UserView extends JFrame {
	
	private JTextField Nom_Prenom;
	
	public UserView() {
		
		getContentPane().setLayout(null);
		
		Nom_Prenom = new JTextField();
		Nom_Prenom.setBounds(96, 218, 191, 20);
		getContentPane().add(Nom_Prenom);
		Nom_Prenom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entrez votre Nom et votre Prénom:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 196, 191, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MMCB BANQUE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(49, 71, 278, 79);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(147, 249, 89, 23);
		getContentPane().add(btnNewButton);
		
		}
	}

