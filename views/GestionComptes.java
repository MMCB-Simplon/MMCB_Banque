package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import dao.CompteDAO;
import models.CompteModel;

import java.awt.Font;

public class GestionComptes extends JFrame {

	private String selectedCompte;
	private int numeroCompte;
	private String typeCompte = " ";

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

		

		JComboBox comboBox = new JComboBox(ConcatList());
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(400, 162, 453, 40);
		getContentPane().add(comboBox);

		btnTransferer.setEnabled(false);
		btnModifier.setEnabled(false);
		btnCrediterCompte.setEnabled(false);
		btnCloturerCompte.setEnabled(false);
		btnDebiterCompte.setEnabled(false);

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getSource() == comboBox) {

					selectedCompte = comboBox.getSelectedItem().toString();
					typeCompte = selectedCompte.substring(7, 14);
					String caster = selectedCompte.substring(18, 24);
					numeroCompte = Integer.parseInt(caster);

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

				// TODO Auto-generated method stub

			}
		});
		System.out.println(comboBox.getItemCount());

	}

	public String[] ConcatList() {
		CompteDAO gestionComptes = new CompteDAO();

		ArrayList<CompteModel> listecompte = new ArrayList<CompteModel>();
		listecompte = gestionComptes.readListeCompte();
		int taille = listecompte.size();

		String[] Combobox = new String[taille + 1];
		int i = 1;
		Combobox[0] = " selectionner un compte";
		for (CompteModel compte : listecompte) {

			Combobox[i] = "Compte " + compte.getTypeCompte() + " n° " + compte.getNumerocompte() + "-" + compte.getNom()
					+ "_" + compte.getPrenom() + " - Solde: " + compte.getSolde() + "€";

			i++;
		}

		return Combobox;

	}

}