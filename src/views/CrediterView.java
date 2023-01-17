package views;

import java.util.Scanner;

import javax.swing.JFrame;
import controllers.Operation;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CrediterView extends JFrame {
	private JTextField textField;
	private JButton btnValiderButton = new JButton("Valider");

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		CrediterView CrediterView = new CrediterView();
		CrediterView.setVisible(true);

	}

	public CrediterView() {
		super("Créditer le compte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);

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
		
		btnValiderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel messagePopup =new JLabel("Le compte a bien été crédité de XX€");
				messagePopup.setFont(new Font("SansSerif", Font.PLAIN, 14));
				getContentPane().add(lblMontantLabel);
				
				JFrame frame = new JFrame("Message de confirmation");
			    frame.add(messagePopup);
			    frame.setBounds(450,300,400,100);
				frame.setVisible(true);
			    
				if (btnValiderButton.isSelected()) {
				JOptionPane.showMessageDialog(frame,"", "",JOptionPane.PLAIN_MESSAGE);				
				}				
			}
			});			
	}	
}
