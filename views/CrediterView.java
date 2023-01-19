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
import models.CompteEpargneModel;

public class CrediterView extends JFrame {
	private JTextField textField;
	private JButton btnValiderButton = new JButton("Valider");
	private JLabel labelcontrolemontant = new JLabel("* Montant superieur au plafond");
	private int numeroCompte;
	private int solde;

	public CrediterView(String selectedCompte) {
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

		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(477, 320, 212, 41);
		getContentPane().add(btnValiderButton);

		labelcontrolemontant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelcontrolemontant.setForeground(new Color(255, 0, 0));
		labelcontrolemontant.setBounds(781, 240, 318, 41);
		getContentPane().add(labelcontrolemontant);
		labelcontrolemontant.setVisible(rootPaneCheckingEnabled);
		labelcontrolemontant.setVisible(false);

		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String typeCompte = selectedCompte.substring(7, 14);
				String caster = selectedCompte.substring(18, 24);
				numeroCompte = Integer.parseInt(caster);
				CompteDAO compte = new CompteDAO();
				Double Montant = Double.parseDouble(textField.getText());
				System.out.println(Montant);
				if (Montant < 100000) {
					if (typeCompte.equals("epargne")) {
						if (compte.crediter(numeroCompte, Montant, typeCompte)) {

							JLabel messagePopup = new JLabel("Le compte a bien été crédité de " + Montant + "€");
							messagePopup.setFont(new Font("SansSerif", Font.PLAIN, 14));
							getContentPane().add(lblMontantLabel);

							JFrame frame = new JFrame("Message de confirmation");
							frame.getContentPane().add(messagePopup);
							frame.setBounds(450, 300, 400, 100);
							frame.setVisible(true);

							JOptionPane.showMessageDialog(frame, "", "", JOptionPane.PLAIN_MESSAGE);
//							if (btnValiderButton.isSelected()) {
//								
//							}
							GestionComptes gestion = new GestionComptes();
							gestion.setVisible(true);
							setVisible(false);
							dispose();
							
						} else {
							labelcontrolemontant.setText("Plafond  Epargne:" + CompteEpargneModel.getPlafond());
							labelcontrolemontant.setVisible(true);
						}

					} else if (typeCompte.equals("courant")) {
						if (compte.crediter(numeroCompte, Montant, typeCompte)) {

							JLabel messagePopup = new JLabel("Le compte a bien été crédité de " + Montant + "€");
							messagePopup.setFont(new Font("SansSerif", Font.PLAIN, 14));
							getContentPane().add(lblMontantLabel);

							JFrame frame = new JFrame("Message de confirmation");
							frame.getContentPane().add(messagePopup);
							frame.setBounds(450, 300, 400, 100);
							frame.setVisible(true);

							JOptionPane.showMessageDialog(frame, "", "", JOptionPane.PLAIN_MESSAGE);

//							if (btnValiderButton.isSelected()) {
//								
//							}
							GestionComptes gestion = new GestionComptes();
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

//	public static void main(String[] arsg) {
//		CrediterView crediter = new CrediterView(null, null);
//		crediter.setVisible(true);
//
//	}
}