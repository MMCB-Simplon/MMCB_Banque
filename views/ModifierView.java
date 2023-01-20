package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.CompteDAO;
import models.CompteCourantModel;
import models.CompteEpargneModel;

public class ModifierView extends JFrame {
	private JTextField textField;
	private JButton btnNewButton = new JButton("Valider");

	public ModifierView(int numerocompte, String selectedcompte, String typeCompte) {
		super("Transfert");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		CompteDAO compte = new CompteDAO();

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

		JLabel lblLibelleLabel = new JLabel("Libellé:");
		lblLibelleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblLibelleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblLibelleLabel.setBounds(400, 90, 186, 29);
		getContentPane().add(lblLibelleLabel);

		JLabel lblEntreeLibelle = new JLabel(compte.getLibelleCompte(numerocompte));
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

		JLabel lblEntreeLibelle_1 = new JLabel(typeCompte);
		lblEntreeLibelle_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblEntreeLibelle_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblEntreeLibelle_1.setBackground(Color.WHITE);
		lblEntreeLibelle_1.setBounds(400, 266, 450, 40);
		getContentPane().add(lblEntreeLibelle_1);

		JLabel lblNouveauMontant = new JLabel("Nouveau Montant :");
		lblNouveauMontant.setHorizontalAlignment(SwingConstants.LEFT);
		lblNouveauMontant.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNouveauMontant.setBounds(400, 362, 212, 29);
		getContentPane().add(lblNouveauMontant);

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(400, 402, 450, 40);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnNewButton.setBounds(400, 495, 212, 41);
		getContentPane().add(btnNewButton);

		JLabel LibelleTypeCompte = new JLabel("");
		LibelleTypeCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		LibelleTypeCompte.setBounds(860, 266, 316, 40);
		getContentPane().add(LibelleTypeCompte);
		
		JButton annuleButton = new JButton("Annuler");
		annuleButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		annuleButton.setBounds(638, 495, 212, 41);
		getContentPane().add(annuleButton);
		
		annuleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestionComptes gestionCompte = new GestionComptes();
				gestionCompte.setVisible(true);

			}
		});
		
		
		

		if (typeCompte.equals("courant")) {
			LibelleTypeCompte.setText("Frais de transfert : " + CompteCourantModel.getFraisTransfert() + "€");
		} else if (typeCompte.equals("epargne")) {
			LibelleTypeCompte.setText("Taux d'intérêt : " + CompteEpargneModel.getTauxInteret() + "%");
		}

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!textField.getText().equals("")) {

					Double solde = Double.parseDouble(textField.getText());
					if (solde < 100000) {
						int valid = JOptionPane.showConfirmDialog(contentPane, "Le compte a été modifié",
								"Message de confirmation", JOptionPane.PLAIN_MESSAGE);

						
						if (valid == JOptionPane.OK_OPTION) {
							compte.updateCompte(numerocompte, solde);
							GestionComptes gestionCompte = new GestionComptes();
							gestionCompte.setVisible(true);
							dispose();

							return;
						} 
					} else {
						JOptionPane.showConfirmDialog(contentPane, "Le compte n'a pas pu être modifié, Montant supérieur à 100.000 € ",
								"Message erreur", JOptionPane.PLAIN_MESSAGE);
						
					}

				} else {
					JOptionPane.showConfirmDialog(contentPane, "Le compte n'a pas pu être modifié, le champs est vide",
							"Message erreur", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}
}
