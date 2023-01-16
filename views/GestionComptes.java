package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.Font;

public class GestionComptes extends JFrame {
	

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		GestionComptes GestionComptes = new GestionComptes();
		GestionComptes.setVisible(true);
	}

	public GestionComptes() {
		super("Liste des comptes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout (null);
		
		JLabel lblNewLabel = new JLabel("Liste des comptes");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(473, 98, 300, 30);
		getContentPane().add(lblNewLabel);
		
		JButton btnCreerCompte = new JButton("Ouvrir un compte");
		btnCreerCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCreerCompte.setBounds(275, 265, 285, 40);
		getContentPane().add(btnCreerCompte);
		
		JButton btnCrediterCompte = new JButton("Créditer un compte");
		btnCrediterCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCrediterCompte.setBounds(275, 390, 285, 40);
		getContentPane().add(btnCrediterCompte);
		btnCrediterCompte.setEnabled(false);
		
		JButton btnDebiterCompte = new JButton("Débiter un compte");
		btnDebiterCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnDebiterCompte.setBounds(275, 515, 285, 40);
		getContentPane().add(btnDebiterCompte);
		btnDebiterCompte.setEnabled(false);
		
		JButton btnTransferer = new JButton("Transférer");
		btnTransferer.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnTransferer.setBounds(680, 265, 285, 40);
		getContentPane().add(btnTransferer);
		btnTransferer.setEnabled(false);
		
		JButton btnModifier = new JButton("Modifier un compte");
		btnModifier.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnModifier.setBounds(680, 390, 285, 40);
		getContentPane().add(btnModifier);
		btnModifier.setEnabled(false);
		
		JButton btnCloturerCompte = new JButton("Clôturer un compte");
		btnCloturerCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCloturerCompte.setBounds(680, 515, 285, 40);
		getContentPane().add(btnCloturerCompte);
		btnCloturerCompte.setEnabled(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(400, 162, 453, 40);
		getContentPane().add(comboBox);
				
	}
}