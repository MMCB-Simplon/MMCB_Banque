package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAOImplements.CompteDAO;
import models.CompteCourantModel;
import models.CompteEpargneModel;

/*
 * Page contenant les items de la page ouverture de compte
 * Page contenant l'ensemble des champs pour la création d'un compte avec les restrictions associées 
 * (champs vide, montant >100 000, restrictions propres au type du compte)
 */

public class OuvertureView extends JFrame {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldSolde;
	private JLabel lblNewLabelEpargne = new JLabel();
	private JLabel lblNewLabelCourant = new JLabel();
	private JRadioButton rdbtnRadioButtonCourant = new JRadioButton("Compte Courant");
	private JRadioButton rdbtnRadioButtonEpargne = new JRadioButton("Compte Epargne");
	private JLabel labelcontroleSolde = new JLabel("* Le solde initial ne peut exceder le plafond");
	private String typeCompte;
	private int numerocompte;
	private int iduser;

	public OuvertureView(String nomPrenom) {
		super("Ouvrir un compte");

		CompteDAO compte = new CompteDAO();
		iduser = compte.getIduser();
		numerocompte = compte.getGeneratedNumCompte();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

		rdbtnRadioButtonEpargne.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRadioButtonEpargne.setFont(new Font("SansSerif", Font.PLAIN, 22));
		rdbtnRadioButtonEpargne.setBounds(167, 180, 220, 35);
		getContentPane().add(rdbtnRadioButtonEpargne);

		rdbtnRadioButtonCourant.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRadioButtonCourant.setFont(new Font("SansSerif", Font.PLAIN, 22));
		rdbtnRadioButtonCourant.setBounds(862, 180, 220, 35);
		getContentPane().add(rdbtnRadioButtonCourant);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRadioButtonEpargne);
		group.add(rdbtnRadioButtonCourant);

		JButton btnNewValiderButton = new JButton("Valider");
		btnNewValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnNewValiderButton.setBounds(347, 466, 212, 41);
		getContentPane().add(btnNewValiderButton);
		btnNewValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (rdbtnRadioButtonCourant.isSelected() || rdbtnRadioButtonEpargne.isSelected()) {
					if (!(textFieldNom.getText().equals("") || textFieldPrenom.getText().equals("")
							|| textFieldSolde.getText().equals(""))) {
						double solde_initial = Double.parseDouble(textFieldSolde.getText());
						if (solde_initial >= 0) {
							if (solde_initial < 100000) {
								if (typeCompte.equals("epargne")) {
									if (solde_initial <= CompteEpargneModel.getPlafond()) {
										compte.insertCompte(numerocompte, iduser, textFieldNom.getText(),
												textFieldPrenom.getText(), solde_initial, typeCompte);
										int res = JOptionPane.showConfirmDialog(contentPane,
												"Le compte a bien été créé", "Message de confirmation",
												JOptionPane.PLAIN_MESSAGE);
										if (btnNewValiderButton.isSelected()) {
											return;
										}
										GestionComptes gestionCompte = new GestionComptes(nomPrenom);
										gestionCompte.setVisible(true);
										dispose();
									} else {
										labelcontroleSolde.setText("* Le solde initial ne peut exceder le plafond");
										labelcontroleSolde.setVisible(true);
									}
								} else if (typeCompte.equals("courant")) {
									if ((CompteCourantModel.getSoldeMinimum() <= solde_initial)) {
										compte.insertCompte(numerocompte, iduser, textFieldNom.getText(),
												textFieldPrenom.getText(), solde_initial, typeCompte);
										int res = JOptionPane.showConfirmDialog(contentPane,
												"Le compte a bien été créé", "Message de confirmation",
												JOptionPane.PLAIN_MESSAGE);
										if (btnNewValiderButton.isSelected()) {
											return;
										}
										GestionComptes gestionCompte = new GestionComptes(nomPrenom);
										gestionCompte.setVisible(true);
										dispose();
									} else {
										labelcontroleSolde.setText("* Montant inférieur au solde minimum");
										labelcontroleSolde.setVisible(true);
									}
								}
							} else {
								labelcontroleSolde.setText("* Montant supérieur au solde maximum");
								labelcontroleSolde.setVisible(true);
							}
						} else {
							labelcontroleSolde.setText("* Le solde initial  inferieur à 0");
							labelcontroleSolde.setVisible(true);
						}

					} else {
						labelcontroleSolde.setText(" * Tous les champs sont obligatoires");
						labelcontroleSolde.setVisible(true);
					}

				} else {
					rdbtnRadioButtonCourant.setForeground(new Color(255, 0, 0));
					rdbtnRadioButtonEpargne.setForeground(new Color(255, 0, 0));
				}
			}
		});

		textFieldNom = new JTextField();
		textFieldNom.setToolTipText("Nom");
		textFieldNom.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textFieldNom.setBounds(450, 239, 343, 41);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setToolTipText("Prénom");
		textFieldPrenom.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(450, 314, 343, 41);
		getContentPane().add(textFieldPrenom);

		textFieldSolde = new JTextField();
		textFieldSolde.setToolTipText("Solde initial");
		textFieldSolde.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textFieldSolde.setColumns(10);
		textFieldSolde.setBounds(450, 390, 343, 41);
		getContentPane().add(textFieldSolde);

		JLabel lblNewLabelNom = new JLabel("Nom");
		lblNewLabelNom.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabelNom.setBounds(450, 213, 75, 26);
		getContentPane().add(lblNewLabelNom);

		JLabel lblNewLabelPrenom = new JLabel("Prénom");
		lblNewLabelPrenom.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabelPrenom.setBounds(450, 289, 75, 26);
		getContentPane().add(lblNewLabelPrenom);

		JLabel lblNewLabelSolde = new JLabel("Solde initial");
		lblNewLabelSolde.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabelSolde.setBounds(450, 367, 150, 26);
		getContentPane().add(lblNewLabelSolde);

		lblNewLabelEpargne.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelEpargne.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabelEpargne.setBounds(121, 213, 299, 40);
		getContentPane().add(lblNewLabelEpargne);
		lblNewLabelEpargne.setText("Taux d'intérêt de 20%; Plafond de 10 000€");
		lblNewLabelEpargne.setVisible(false);

		lblNewLabelCourant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelCourant.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabelCourant.setBounds(825, 213, 299, 40);
		getContentPane().add(lblNewLabelCourant);
		lblNewLabelCourant.setText("Frais de transfert de 2€, Solde minimum 0€");
		lblNewLabelCourant.setVisible(false);
		JLabel lblNumroDeCompte = new JLabel("Numéro de compte : " + numerocompte);
		lblNumroDeCompte.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNumroDeCompte.setBounds(450, 122, 300, 26);
		getContentPane().add(lblNumroDeCompte);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnAnnuler.setBounds(685, 466, 212, 41);
		getContentPane().add(btnAnnuler);

		labelcontroleSolde.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelcontroleSolde.setForeground(new Color(255, 0, 0));
		labelcontroleSolde.setBounds(812, 390, 364, 41);
		getContentPane().add(labelcontroleSolde);
		labelcontroleSolde.setVisible(false);
		
		JLabel userLabel = new JLabel("User : "+nomPrenom);
		userLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		userLabel.setBounds(32, 10, 225, 40);
		getContentPane().add(userLabel);

		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionComptes gestionCompte = new GestionComptes(nomPrenom);
				gestionCompte.setVisible(true);
				setVisible(false);
				dispose();
			}
		});

		rdbtnRadioButtonEpargne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (rdbtnRadioButtonEpargne.isSelected()) {
					lblNewLabelEpargne.setVisible(true);
					lblNewLabelCourant.setVisible(false);
					typeCompte = "epargne";
				} else {
					lblNewLabelEpargne.setVisible(false);
				}

			}
		});

		rdbtnRadioButtonCourant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (rdbtnRadioButtonCourant.isSelected()) {
					lblNewLabelCourant.setVisible(true);
					lblNewLabelEpargne.setVisible(false);
					typeCompte = "courant";
				} else {
					lblNewLabelCourant.setVisible(false);
				}

			}
		});
	}

}