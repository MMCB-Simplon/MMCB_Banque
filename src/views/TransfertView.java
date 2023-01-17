package views;

import java.beans.Statement;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Dao.DatabaseConnection;
import controllers.Operation;
import models.CompteModel;
import models.CompteCourantModel;
import javax.swing.border.LineBorder;

public class TransfertView extends JFrame {
	private JTextField textField;

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		OuvertureView OuvertureView = new OuvertureView();
		OuvertureView.setVisible(true);
	}

	public TransfertView() {
		super("Transfert");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 22));
		comboBox.setBounds(400, 260, 450, 40);
		getContentPane().add(comboBox);
		
		JButton btnValiderButton = new JButton("Valider");
		btnValiderButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
		btnValiderButton.setBounds(533, 483, 212, 41);
		getContentPane().add(btnValiderButton);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textField.setBounds(463, 389, 340, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		
		JLabel lblCompteSource = new JLabel("");
		lblCompteSource.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblCompteSource.setBackground(new Color(255, 255, 255));
		lblCompteSource.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCompteSource.setBounds(400, 130, 450, 40);
		lblCompteSource.setVisible(true);
		getContentPane().add(lblCompteSource);
		
			
	}
}
