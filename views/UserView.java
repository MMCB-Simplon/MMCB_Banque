package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UserDAO;
import java.awt.Color;

public class UserView extends JFrame {

	private JTextField Nom_Prenom;
	private JButton validerbtn = new JButton("Valider");
//	private button valider = new 

	JLabel obligatoirelabel = new JLabel(" * obligatoire");

	public UserView() {

		getContentPane().setLayout(null);

		Nom_Prenom = new JTextField();
		Nom_Prenom.setToolTipText("maximum 50 caracteres");
		Nom_Prenom.setBounds(198, 344, 402, 42);
		getContentPane().add(Nom_Prenom);
		Nom_Prenom.setColumns(10);

		JLabel lblNewLabel = new JLabel("Entrez votre Nom et votre Prénom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(198, 284, 378, 35);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MMCB BANQUE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1.setBounds(198, 142, 378, 137);
		getContentPane().add(lblNewLabel_1);

		validerbtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		validerbtn.setBounds(338, 418, 148, 42);
		validerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!Nom_Prenom.getText().equals("")) {

					if (Nom_Prenom.getText().length() < 50) {
						UserDAO userdao = new UserDAO();
						userdao.insertUser(Nom_Prenom.getText());
						
						setVisible(false);
						dispose();
						GestionComptes listes = new GestionComptes();
						listes.setVisible(true);
					} else {
						obligatoirelabel.setText("* Maximum 50 caracteres");
						obligatoirelabel.setVisible(true);
					}
				} else { 
					obligatoirelabel.setText("* Champ obligatoire");
					obligatoirelabel.setVisible(true);
				}

				// TODO Auto-generated method stub

			}

			
		});

		getContentPane().add(validerbtn);

		obligatoirelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		obligatoirelabel.setForeground(new Color(255, 0, 0));
		obligatoirelabel.setBounds(610, 344, 118, 36);
		getContentPane().add(obligatoirelabel);
		obligatoirelabel.setVisible(false);

	}
}
