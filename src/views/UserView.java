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
		Nom_Prenom.setBounds(198, 344, 402, 42);
		getContentPane().add(Nom_Prenom);
		Nom_Prenom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entrez votre Nom et votre Prénom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(208, 294, 378, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MMCB BANQUE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1.setBounds(198, 142, 378, 137);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(338, 418, 148, 42);
		getContentPane().add(btnNewButton);
		
		}
	}

