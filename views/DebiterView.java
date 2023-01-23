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
import DAOImplements.UserDAO;
import models.CompteEpargneModel;

/*
* Page contenant le code nécessaire pour débiter un compte, l'affichage de notre page et l'insertion 
* au niveau de la base de donnée et de la table des opérations. 
*/

public class DebiterView extends JFrame {
	private JTextField textField;
	private JButton btnValiderButton = new JButton("Valider");
	private JLabel labelcontrolemontant = new JLabel("* Saisir un montannt inferieur à");
	private int numeroCompte;
	private int solde;

	public DebiterView(String selectedCompte, String nomPrenom) {
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
		lblCompteSource.setBounds(213, 87, 752, 40);
		getContentPane().add(lblCompteSource);

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(410, 240, 340, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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

		JLabel lblMontantLabel = new JLabel("Montant ");
		lblMontantLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblMontantLabel.setBounds(410, 180, 340, 20);
		getContentPane().add(lblMontantLabel);

		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(326, 318, 212, 41);
		getContentPane().add(btnValiderButton);

		labelcontrolemontant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelcontrolemontant.setForeground(new Color(255, 0, 0));
		labelcontrolemontant.setBounds(781, 240, 318, 41);
		getContentPane().add(labelcontrolemontant);
		labelcontrolemontant.setVisible(rootPaneCheckingEnabled);
		labelcontrolemontant.setVisible(false);
		
		JLabel userLabel = new JLabel("User : "+nomPrenom);
		userLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		userLabel.setBounds(32, 10, 225, 40);
		getContentPane().add(userLabel);

		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String caster = selectedCompte.substring(18, 24);
				numeroCompte = Integer.parseInt(caster);
				CompteDAO compte = new CompteDAO();
				Double Montant = Double.parseDouble(textField.getText());
				UserDAO user= new UserDAO();
				int iduser=user.getIduser(nomPrenom);
				
				if (compte.debiter(iduser, numeroCompte, Montant))

				{

					int res = JOptionPane.showConfirmDialog(contentPane,
							"Le compte a bien été débité de: " + Montant + "€", "Message de confirmation",
							JOptionPane.PLAIN_MESSAGE);

					if (btnValiderButton.isSelected()) {
						return;
					}

					GestionComptes gestion = new GestionComptes(nomPrenom);
					gestion.setVisible(true);
					
					dispose();

				} else {

					labelcontrolemontant
							.setText("* Saisir un montannt inferieur à" + compte.getSoldeFromDatabase(numeroCompte));
					labelcontrolemontant.setVisible(true);
				}

			}
		});
	}
}