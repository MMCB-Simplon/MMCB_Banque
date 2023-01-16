package views;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GestionComptes extends JFrame {
	public GestionComptes() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().setLayout(null);
		
		JButton btnCreerCompte = new JButton("Ouvrir un compte");
		btnCreerCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCreerCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreerCompte.setBounds(293, 307, 285, 40);
		getContentPane().add(btnCreerCompte);
		
		JButton btnCrediterCompte = new JButton("Créditer un compte");
		btnCrediterCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCrediterCompte.setBounds(293, 416, 285, 40);
		getContentPane().add(btnCrediterCompte);
		
		JButton btnDebiterCompte = new JButton("Débiter un compte");
		btnDebiterCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDebiterCompte.setBounds(293, 512, 285, 40);
		getContentPane().add(btnDebiterCompte);
		
		JButton btnTransferer = new JButton("Transférer");
		btnTransferer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnTransferer.setBounds(682, 307, 285, 40);
		getContentPane().add(btnTransferer);
		
		JButton btnModifier = new JButton("Modifier un compte");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnModifier.setBounds(682, 416, 285, 40);
		getContentPane().add(btnModifier);
		
		JButton btnCloturerCompte = new JButton("Clôturer un compte");
		btnCloturerCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCloturerCompte.setBounds(682, 512, 285, 40);
		getContentPane().add(btnCloturerCompte);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(398, 204, 453, 40);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Liste des comptes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(454, 146, 341, 29);
		getContentPane().add(lblNewLabel);
	}
}
