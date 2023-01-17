package views;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import dao.CompteDAO;
import models.CompteModel;
import java.awt.Dimension;

public class TransfertView extends JFrame {
	private JTextField textField;
	private JComboBox comboBox;
	private String compteDestination;
	private String compteSource;
	private int numeroCompteSource;
	private int numeroCompteDestination;
	private JLabel labelcontrolmontant;

	public TransfertView(String compteSource, int numerocompteSource) {
		
		super("Transfert");
		this.compteSource = compteSource;
		this.numeroCompteSource = numerocompteSource;
	
		System.out.println(numeroCompteSource);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		
		
		JButton btnValiderButton = new JButton("Valider");
		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(533, 483, 212, 41);
		getContentPane().add(btnValiderButton);
		
		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					CompteDAO transfertCompte = new CompteDAO();
					double solde = Double.parseDouble(textField.getText());
					if(transfertCompte.transfert(numerocompteSource, numeroCompteDestination, solde )) {
						setVisible(false);
						dispose();
						System.out.println("ok");
						GestionComptes listes = new GestionComptes();
						listes.setVisible(true);
					}
					else labelcontrolmontant.setVisible(true);
					
			}

		});
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(463, 389, 340, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 22));
		comboBox.setBounds(400, 260, 450, 40);
		getContentPane().add(comboBox);
		ConcatList(compteSource);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String selected="";
				if (e.getSource() == comboBox) {
					
					if (!comboBox.getSelectedItem().toString().equals("selectionner un compte")) {
						selected = comboBox.getSelectedItem().toString();
						String caster = selected.substring(18, 24);
						numeroCompteDestination = Integer.parseInt(caster);
						System.out.println(numeroCompteDestination);

					}
					

					// TODO Auto-generated method stub

				}
			}
		});
		
		
		
		
		JLabel lblCompteSourceLabel = new JLabel("Compte Source :");
		lblCompteSourceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompteSourceLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteSourceLabel.setBounds(400, 90, 186, 29);
		getContentPane().add(lblCompteSourceLabel);
		
		JLabel lblCompteDestinateur = new JLabel("Compte Destinateur :");
		lblCompteDestinateur.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompteDestinateur.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteDestinateur.setBounds(400, 219, 242, 29);
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
		lblCompteSource.setBounds(400, 130, 524, 40);
		getContentPane().add(lblCompteSource);
		
		labelcontrolmontant = new JLabel("somme superieur au soldel");
		
	     labelcontrolmontant.setSize(new Dimension(28, 5));
		labelcontrolmontant.setPreferredSize(new Dimension(122, 13));
		labelcontrolmontant.setForeground(new Color(255, 0, 0));
		labelcontrolmontant.setBackground(new Color(255, 255, 255));
		labelcontrolmontant.setBounds(854, 389, 225, 41);
		getContentPane().add(labelcontrolmontant);
		labelcontrolmontant.setVisible(false);
		
			
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