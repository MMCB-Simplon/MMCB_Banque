package views;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.CompteDAO;
import models.CompteModel;

public class GestionComptes extends JFrame {

	private String selectedCompte;
	private int numeroCompte;
	private String typeCompte = " ";
	private JComboBox comboBox;

	public GestionComptes() {
		super("Liste des comptes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

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

		JButton btnDebiterCompte = new JButton("Débiter un compte");
		btnDebiterCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnDebiterCompte.setBounds(275, 515, 285, 40);
		getContentPane().add(btnDebiterCompte);

		JButton btnTransferer = new JButton("Transférer");
		btnTransferer.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnTransferer.setBounds(680, 265, 285, 40);
		getContentPane().add(btnTransferer);

		JButton btnModifier = new JButton("Modifier un compte");
		btnModifier.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnModifier.setBounds(680, 390, 285, 40);
		getContentPane().add(btnModifier);

		JButton btnCloturerCompte = new JButton("Clôturer un compte");
		btnCloturerCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCloturerCompte.setBounds(680, 515, 285, 40);
		getContentPane().add(btnCloturerCompte);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(400, 162, 453, 40);
		getContentPane().add(comboBox);
//		remplissage de la list des comptes
		ConcatList();

		btnTransferer.setEnabled(false);
		btnModifier.setEnabled(false);
		btnCrediterCompte.setEnabled(false);
		btnCloturerCompte.setEnabled(false);
		btnDebiterCompte.setEnabled(false);

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getSource() == comboBox) {
					if (!comboBox.getSelectedItem().toString().equals("selectionner un compte")) {
						selectedCompte = comboBox.getSelectedItem().toString();

						typeCompte = selectedCompte.substring(7, 14);
						String caster = selectedCompte.substring(18, 24);
						numeroCompte = Integer.parseInt(caster);
						System.out.println(selectedCompte);
						if (typeCompte.equals("courant")) {
							btnTransferer.setEnabled(true);
							btnModifier.setEnabled(true);
							btnCrediterCompte.setEnabled(true);
							btnCloturerCompte.setEnabled(true);
							btnDebiterCompte.setEnabled(true);
							btnTransferer.setEnabled(true);

						} else if (typeCompte.equals("epargne")) {
							btnTransferer.setEnabled(true);
							btnModifier.setEnabled(true);
							btnCrediterCompte.setEnabled(true);
							btnCloturerCompte.setEnabled(true);
							btnDebiterCompte.setEnabled(true);
							btnTransferer.setEnabled(false);
						}

					}
					else {
						btnTransferer.setEnabled(false);
						btnModifier.setEnabled(false);
						btnCrediterCompte.setEnabled(false);
						btnCloturerCompte.setEnabled(false);
						btnDebiterCompte.setEnabled(false);

						
					}

					// TODO Auto-generated method stub

				}
			}
		});

	}

	public void ConcatList() {
		CompteDAO gestionComptes = new CompteDAO();

		List<CompteModel> listecompte = new Vector<CompteModel>();
		listecompte = gestionComptes.readListeCompte();

		String itemCombox = "";

		comboBox.addItem("selectionner un compte");
		for (int i = 0; i < listecompte.size(); i++) {

			itemCombox = "Compte " + listecompte.get(i).getTypeCompte() + " n° " + listecompte.get(i).getNumerocompte()
					+ "-" + listecompte.get(i).getNom() + "_" + listecompte.get(i).getPrenom() + " - Solde: "
					+ listecompte.get(i).getSolde() + "€";

			comboBox.addItem(itemCombox);

		}

	}

	public static void main(String[] args) {
		GestionComptes gestion = new GestionComptes();
		// gestion.ConcatList();
		gestion.setVisible(true);

	}
}