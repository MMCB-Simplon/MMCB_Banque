package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//	this.addWindowListener(null);
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
		
		btnCreerCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						OuvertureView ouvertureCompte = new OuvertureView();
						ouvertureCompte.setVisible(true);

						setVisible(false);
						dispose();
			}

		});
		
		
		
		

		JButton btnCrediterCompte = new JButton("Créditer un compte");
		btnCrediterCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCrediterCompte.setBounds(275, 390, 285, 40);
		getContentPane().add(btnCrediterCompte);
		btnCrediterCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						CrediterView creditercompte = new CrediterView(selectedCompte);
						creditercompte.setVisible(true);
						setVisible(false);
						dispose();
			}

		});

	JButton	btnDebiterCompte = new JButton("Débiter un compte");
		btnDebiterCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnDebiterCompte.setBounds(275, 515, 285, 40);
		getContentPane().add(btnDebiterCompte);
	
		btnDebiterCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DebiterView debitcompte = new DebiterView(selectedCompte);
						debitcompte.setVisible(true);
						setVisible(false);
						dispose();
			}

		});

		JButton btnTransferer = new JButton("Transférer");
		btnTransferer.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnTransferer.setBounds(680, 265, 285, 40);
		getContentPane().add(btnTransferer);
		btnTransferer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						TransfertView transfertCompte = new TransfertView(selectedCompte, numeroCompte);
						transfertCompte.setVisible(true);
					
						dispose();
			}

		});

		JButton btnModifier = new JButton("Modifier un compte");
		btnModifier.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnModifier.setBounds(680, 390, 285, 40);
		getContentPane().add(btnModifier);
		
		btnModifier.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent evt) {


				ModifierView modifierCompte = new ModifierView(numeroCompte,selectedCompte, typeCompte);
				modifierCompte.setVisible(true);
				
				dispose();
					
					
				}
					});

		
		
		
		

		JButton btnCloturerCompte = new JButton("Clôturer un compte");
		btnCloturerCompte.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnCloturerCompte.setBounds(680, 515, 285, 40);
		getContentPane().add(btnCloturerCompte);
		
		btnCloturerCompte.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent evt) {

			int res = JOptionPane.showConfirmDialog(contentPane, "Souhaitez-vous procéder à la clotûre de ce compte?",
							"Clôturer Compte", JOptionPane.YES_NO_OPTION);

			
					if (res == JOptionPane.YES_OPTION)
					{ 
						CompteDAO compteDelete = new CompteDAO();
						compteDelete.deleteCompte(numeroCompte);
						dispose();
						GestionComptes gestion = new GestionComptes();
						gestion.setVisible(true);
						
						
					}
					else if (res == JOptionPane.NO_OPTION) {
						
					}
					
				}
					});

		comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox.setBounds(400, 162, 512, 40);
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

	
//	public void windowClosing(WindowEvent e) 
//	  {
//		  int res = JOptionPane.showConfirmDialog(this, "Souhaitez-vous procéder à la fermeture de cette fenêtre?",
//					"Fermer Site", JOptionPane.YES_NO_OPTION);
//			if (res == JOptionPane.YES_OPTION)
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			else if (res == JOptionPane.NO_OPTION)
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    }
//	

}