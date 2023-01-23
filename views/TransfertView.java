package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import DAOImplements.CompteDAO;
import DAOImplements.UserDAO;
import models.CompteModel;
/*
* Page contenant le code nécessaire pour transfer un montant d'un compte à un autre. L'affichage de notre page et l'insertion 
* au niveau de la base de donnée et de la table des opérations. 
*/

public class TransfertView extends JFrame {
	private JTextField textField;
	private JComboBox comboBox;
	private String compteDestination;
	private String compteSource;
	private int numeroCompteSource;
	private int numeroCompteDestination;
	private JLabel labelcontrolmontant;
	private JLabel labelChoixcompte;
	private String typeCompte;


	
	public TransfertView(String compteSource, int numerocompteSource, String nomPrenom) {

		super("Transfert");
		this.compteSource = compteSource;
		this.numeroCompteSource = numerocompteSource;


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		JButton annuleButton = new JButton("Annuler");
		annuleButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		annuleButton.setBounds(677, 476, 212, 41);
		getContentPane().add(annuleButton);
		
		annuleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestionComptes gestionCompte = new GestionComptes(nomPrenom);
				gestionCompte.setVisible(true);

			}
		});

		JButton btnValiderButton = new JButton("Valider");
		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(383, 476, 212, 41);
		getContentPane().add(btnValiderButton);

		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CompteDAO transfertCompte = new CompteDAO();
				UserDAO user= new UserDAO();
				int iduser=user.getIduser(nomPrenom);
				if (!comboBox.getSelectedItem().toString().equals("selectionner un compte")) {
					if ((!textField.getText().equals(""))) {
                
						double solde = Double.parseDouble(textField.getText());
						
					   
						if (transfertCompte.transfert(iduser, numerocompteSource, numeroCompteDestination, solde,typeCompte)) {
							int res = JOptionPane.showConfirmDialog(contentPane, "Le transfert a bien été realisé",
									"Message de confirmation", JOptionPane.PLAIN_MESSAGE);

							if (btnValiderButton.isSelected()) {
								return;
							}
						
							
							dispose();
							GestionComptes listes = new GestionComptes(nomPrenom);
							listes.setVisible(true);
						} else {
							labelcontrolmontant.setVisible(true);
							labelcontrolmontant.setText("Montant superieure au solde ou le plafond ateint");

						}
					}
					else {
						labelcontrolmontant.setVisible(true);
						labelcontrolmontant.setText("choisir un montant");

					}
				} else {

					labelChoixcompte.setVisible(true);
				}

			}

		});

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(463, 389, 340, 41);
		getContentPane().add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 22));
		comboBox.setBounds(296, 258, 684, 40);
		getContentPane().add(comboBox);
		ConcatList(compteSource);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String selected = "";
				if (e.getSource() == comboBox) {

					if (!comboBox.getSelectedItem().toString().equals("selectionner un compte")) {
						selected = comboBox.getSelectedItem().toString();
						typeCompte = selected.substring(7, 14);
						String caster = selected.substring(18, 24);
						numeroCompteDestination = Integer.parseInt(caster);

					}


				}
			}
		});

		JLabel lblCompteSourceLabel = new JLabel("Compte Source :");
		lblCompteSourceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompteSourceLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteSourceLabel.setBounds(294, 90, 186, 29);
		getContentPane().add(lblCompteSourceLabel);

		JLabel lblCompteDestinateur = new JLabel("Compte Destinateur :");
		lblCompteDestinateur.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompteDestinateur.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteDestinateur.setBounds(296, 219, 242, 29);
		getContentPane().add(lblCompteDestinateur);

		JLabel lblMontantLabel = new JLabel("Montant :");
		lblMontantLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblMontantLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblMontantLabel.setBounds(463, 355, 242, 29);
		getContentPane().add(lblMontantLabel);

		JLabel lblCompteSource = new JLabel(compteSource);
		lblCompteSource.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblCompteSource.setBackground(new Color(255, 255, 255));
		lblCompteSource.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteSource.setBounds(288, 129, 701, 40);
		getContentPane().add(lblCompteSource);

		labelcontrolmontant = new JLabel("* Somme superieure au solde");
		labelcontrolmontant.setFont(new Font("SansSerif", Font.PLAIN, 22));

		labelcontrolmontant.setSize(new Dimension(28, 5));
		labelcontrolmontant.setPreferredSize(new Dimension(122, 13));
		labelcontrolmontant.setForeground(new Color(255, 0, 0));
		labelcontrolmontant.setBackground(new Color(255, 255, 255));
		labelcontrolmontant.setBounds(829, 389, 316, 41);
		getContentPane().add(labelcontrolmontant);

		labelcontrolmontant.setVisible(false);

		labelChoixcompte = new JLabel("* Choisir un compte");
		labelChoixcompte.setForeground(new Color(255, 0, 0));
		labelChoixcompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		labelChoixcompte.setBounds(990, 258, 196, 40);
		getContentPane().add(labelChoixcompte);
		labelChoixcompte.setVisible(false);

		JLabel userLabel = new JLabel("User : "+nomPrenom);
		userLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		userLabel.setBounds(32, 10, 225, 40);
		getContentPane().add(userLabel);
	}

	public void ConcatList(String compteSource) {
		CompteDAO gestionComptes = new CompteDAO();

		List<CompteModel> listecompte = new Vector<CompteModel>();
		listecompte = gestionComptes.readListeCompte();

		String itemCombox = "";

		comboBox.addItem("selectionner un compte");
		for (int i = 0; i < listecompte.size(); i++) {

			itemCombox = "Compte " + listecompte.get(i).getTypeCompte() + " n° " + listecompte.get(i).getNumerocompte()
					+ "-" + listecompte.get(i).getNom() + "_" + listecompte.get(i).getPrenom() + " - Solde: "
					+ listecompte.get(i).getSolde() + "€";

			if (!itemCombox.equals(compteSource)) {
				comboBox.addItem(itemCombox);
			}
		}

	}
}