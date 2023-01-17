package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class OuvertureView extends JFrame {
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldSolde;
	private JLabel lblNewLabelEpargne = new JLabel();
	private JLabel lblNewLabelCourant = new JLabel();
	private JRadioButton rdbtnRadioButtonCourant = new JRadioButton("Compte Courant");
	private JRadioButton rdbtnRadioButtonEpargne = new JRadioButton("Compte Epargne");

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		OuvertureView OuvertureView = new OuvertureView();
		OuvertureView.setVisible(true);
	}

	public OuvertureView() {
		super("Ouvrir un compte");
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
		
		JLabel lblNumroDeCompte = new JLabel("Numéro de compte");
		lblNumroDeCompte.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNumroDeCompte.setBounds(450, 122, 188, 26);
		getContentPane().add(lblNumroDeCompte);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnAnnuler.setBounds(685, 466, 212, 41);
		getContentPane().add(btnAnnuler);
		
		JPanel panelNumeroCompte = new JPanel();
		panelNumeroCompte.setBackground(new Color(255, 255, 255));
		panelNumeroCompte.setBounds(450, 160, 343, 41);
		getContentPane().add(panelNumeroCompte);
		lblNewLabelCourant.setVisible(false);			
	

		rdbtnRadioButtonEpargne.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (rdbtnRadioButtonEpargne.isSelected()) {
					lblNewLabelEpargne.setVisible(true);
					lblNewLabelCourant.setVisible(false);
			}else {
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
				}else {
						lblNewLabelCourant.setVisible(false);			
					}
					
				}
			});	
		}
	}

