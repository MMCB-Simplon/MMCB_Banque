package views;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controllers.Operation;
import javax.swing.JTextField;
import java.awt.Font;


public class ModifierView extends JFrame {
	private JTextField textField;
	
	public static void main (String [] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		OuvertureView OuvertureView = new OuvertureView();
		OuvertureView.setVisible(true);
	}
	public ModifierView () {
		super("Transfert");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(400, 130, 450, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	}

}
