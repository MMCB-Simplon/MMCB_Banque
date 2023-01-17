package views;

import javax.swing.JFrame;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class UserView extends JFrame {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		UserView userView = new UserView();
		userView.setVisible(true);
	}

	public UserView() {
		super("Gestion bancaire");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout (null);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnNewButton.setBounds(500, 400, 200, 50);
		getContentPane().add(btnNewButton);
		
		Nom_Prenom = new JTextField();
		Nom_Prenom.setBounds(450, 300, 300, 50);
		getContentPane().add(Nom_Prenom);

		JLabel lblNewLabel = new JLabel("Entrez votre Nom et votre Prénom:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(410, 225, 378, 50);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MMCB BANQUE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblNewLabel_1.setBounds(410, 100, 378, 137);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Champ obligatoire: maximum 50 caractères");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(761, 317, 306, 16);
		getContentPane().add(lblNewLabel_2);

	}
	private JTextField Nom_Prenom;
}
