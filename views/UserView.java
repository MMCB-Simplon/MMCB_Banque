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

	private JLabel obligatoirelabel = new JLabel();

	public UserView() {
		super("Gestion bancaire");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
      

		Nom_Prenom = new JTextField();
		getContentPane().setLayout(null);
		Nom_Prenom = new JTextField();
		Nom_Prenom.setBounds(450, 300, 300, 50);
		getContentPane().add(Nom_Prenom);

		JLabel lblNewLabel = new JLabel("Entrez votre Nom et votre Prénom:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(410, 225, 378, 50);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MMCB BANQUE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblNewLabel_1.setBounds(410, 100, 378, 137);
		getContentPane().add(lblNewLabel_1);

		validerbtn.setFont(new Font("SansSerif", Font.PLAIN, 22));
		validerbtn.setBounds(500, 400, 200, 50);
		getContentPane().add(validerbtn);

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
		

		//JLabel obligatoirelabel = new JLabel("*Champ obligatoire: maximum 50 caractères");
		obligatoirelabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		obligatoirelabel.setForeground(new Color(255, 0, 0));
		obligatoirelabel.setBounds(761, 317, 306, 16);
		getContentPane().add(obligatoirelabel);
		

	}
}
