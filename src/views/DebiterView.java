package views;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import controllers.Operation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JTextField;

public class DebiterView extends JFrame {
	private JTextField textField;
	private JButton btnValiderButton = new JButton("Valider");
	
	public static void main (String [] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		DebiterView DebiterView = new DebiterView();
		DebiterView.setVisible(true);	
}
	public DebiterView() {
		super("Débiter le compte");
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

				int res = JOptionPane.showConfirmDialog(contentPane, "Le compte a bien été débité de XX€",
						"Message de confirmation", JOptionPane.PLAIN_MESSAGE);

				if (btnValiderButton.isSelected()) {
					return;
				}
			}
		});
		

	}

}
