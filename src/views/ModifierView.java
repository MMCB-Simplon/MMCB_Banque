package views;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controllers.Operation;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;


public class ModifierView extends JFrame {
	private JTextField textField;
	
	public static void main (String [] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		ModifierView ModifierView = new ModifierView();
		ModifierView.setVisible(true);
	}
	public ModifierView () {
		super("Transfert");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

		JLabel lblLibelleLabel = new JLabel("Libellé:");
		lblLibelleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblLibelleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblLibelleLabel.setBounds(400, 90, 186, 29);
		getContentPane().add(lblLibelleLabel);
		
		JLabel lblEntreeLibelle = new JLabel("");
		lblEntreeLibelle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblEntreeLibelle.setBackground(new Color(255, 255, 255));
		lblEntreeLibelle.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblEntreeLibelle.setBounds(400, 130, 450, 40);
		getContentPane().add(lblEntreeLibelle);
		
		JLabel lblTypeDeCompte = new JLabel("Type de compte :");
		lblTypeDeCompte.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeDeCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblTypeDeCompte.setBounds(400, 225, 186, 29);
		getContentPane().add(lblTypeDeCompte);
		
		JLabel lblEntreeLibelle_1 = new JLabel("");
		lblEntreeLibelle_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblEntreeLibelle_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblEntreeLibelle_1.setBackground(Color.WHITE);
		lblEntreeLibelle_1.setBounds(400, 266, 450, 40);
		getContentPane().add(lblEntreeLibelle_1);
		
		JLabel lblNouveauMontant = new JLabel("Nouveau Montant :");
		lblNouveauMontant.setHorizontalAlignment(SwingConstants.LEFT);
		lblNouveauMontant.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNouveauMontant.setBounds(400, 362, 186, 29);
		getContentPane().add(lblNouveauMontant);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(400, 402, 450, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnNewButton.setBounds(519, 497, 212, 41);
		getContentPane().add(btnNewButton);
	}
}
