package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

import DAOImplements.OperationRegisterDAO;

public class HistoriqueOperations extends JFrame{
	//private JTable table;
	public HistoriqueOperations (String nomprenom){
		
	super("Historique des operations");
	getContentPane().setBackground(new Color(214, 217, 223));
	getContentPane().setBounds(new Rectangle(100, 0, 0, 0));
	getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 20));
	getContentPane().setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	scrollPane.setBounds(47, 70, 1153, 459);
	getContentPane().add(scrollPane);
	
	
	
	JLabel lblNewLabel = new JLabel("Historique des Opérations");
	lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
	lblNewLabel.setBorder(new CompoundBorder());
	lblNewLabel.setBounds(422, 6, 249, 41);
	getContentPane().add(lblNewLabel);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1220, 650);
	this.setLocationRelativeTo(null);
	this.setResizable(false);

	Vector<String> v = new Vector<String> ();
OperationRegisterDAO operation=	new OperationRegisterDAO();
v=operation.getOperations();
	 
	 
JList operations = new JList(v);
operations.setBackground(new Color(171, 171, 171));
operations.setFont(new Font("SansSerif", Font.PLAIN, 24));
operations.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
scrollPane.setViewportView(operations);
JButton back = new JButton("");
back.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		GestionComptes gestion =new GestionComptes(nomprenom);
		dispose();
		gestion.setVisible(true);
		
	}
});
back.setIcon(new ImageIcon(HistoriqueOperations.class.getResource("/src/images/211686_back_arrow_icon.png")));
back.setBounds(6, 8, 75, 50);
getContentPane().add(back);
	
	
	

}

}