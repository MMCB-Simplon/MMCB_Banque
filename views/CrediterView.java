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

import DAOImplements.CompteDAO;
import DAOImplements.OperationRegisterDAO;
import DAOImplements.UserDAO;
import DAOInterfaces.CompteDAOInterface;
import models.CompteEpargneModel;

/*
 * Page contenant le code nécessaire pour créditer un compte, l'affichage de notre page et l'insertion 
 * au niveau de la base de donnée et de la table des opérations. 
 */

public class CrediterView extends JFrame {
	private JTextField textField;
	private JButton btnValiderButton = new JButton("Valider");
	private JLabel labelcontrolemontant = new JLabel("* Montant superieur au plafond");
	private int numeroCompte;

	public CrediterView(String selectedCompte, String nomPrenom) {
		super("Créditer le compte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

		JLabel lblCompteSource = new JLabel(selectedCompte);
		lblCompteSource.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblCompteSource.setBackground(new Color(255, 255, 255));
		lblCompteSource.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteSource.setBounds(203, 86, 752, 40);
		getContentPane().add(lblCompteSource);

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(410, 240, 340, 41);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblMontantLabel = new JLabel("Montant ");
		lblMontantLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblMontantLabel.setBounds(410, 180, 340, 20);
		getContentPane().add(lblMontantLabel);

		JButton annuleButton = new JButton("Annuler");
		annuleButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		annuleButton.setBounds(624, 318, 212, 41);
		getContentPane().add(annuleButton);

		annuleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestionComptes gestionCompte = new GestionComptes(nomPrenom);
				gestionCompte.setVisible(true);

			}
		});

		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(329, 318, 212, 41);
		getContentPane().add(btnValiderButton);

		labelcontrolemontant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelcontrolemontant.setForeground(new Color(255, 0, 0));
		labelcontrolemontant.setBounds(781, 240, 318, 41);
		getContentPane().add(labelcontrolemontant);
		labelcontrolemontant.setVisible(rootPaneCheckingEnabled);
		labelcontrolemontant.setVisible(false);

		JLabel userLabel = new JLabel("User : " + nomPrenom);
		userLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		userLabel.setBounds(32, 10, 225, 40);
		getContentPane().add(userLabel);

		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String typeCompte = selectedCompte.substring(7, 14);
				String caster = selectedCompte.substring(18, 24);
				numeroCompte = Integer.parseInt(caster);
				CompteDAOInterface compte = new CompteDAO();
				Double Montant = Double.parseDouble(textField.getText());
				if (Montant < 100000) {
					UserDAO user = new UserDAO();

					int iduser = user.getIduser(nomPrenom);
					if (typeCompte.equals("epargne")) {

						if (compte.crediter(iduser, numeroCompte, Montant, typeCompte)) {

							int res = JOptionPane.showConfirmDialog(contentPane,
									"Le compte a bien été crédité de: " + Montant + "€", "Message de confirmation",
									JOptionPane.PLAIN_MESSAGE);

							if (btnValiderButton.isSelected()) {
								return;
							}

							GestionComptes gestion = new GestionComptes(nomPrenom);
							gestion.setVisible(true);

							dispose();

						} else {
							labelcontrolemontant.setText("Plafond  Epargne:" + CompteEpargneModel.getPlafond());
							labelcontrolemontant.setVisible(true);
						}

					} else if (typeCompte.equals("courant")) {
						if (compte.crediter(iduser, numeroCompte, Montant, typeCompte)) {

							int res = JOptionPane.showConfirmDialog(contentPane,
									"Le compte a bien été crédité de: " + Montant + "€", "Message de confirmation",
									JOptionPane.PLAIN_MESSAGE);

							if (btnValiderButton.isSelected()) {
								return;
							}

							GestionComptes gestion = new GestionComptes(nomPrenom);
							gestion.setVisible(true);
							setVisible(false);
							dispose();

						} else {
							labelcontrolemontant.setText("Plafond ateint");
							labelcontrolemontant.setVisible(true);
						}

					}

				} else {
					labelcontrolemontant.setText("le plafond est à 100000");
					labelcontrolemontant.setVisible(true);
				}
			}
		});
	}

}