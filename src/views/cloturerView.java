package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class cloturerView extends WindowAdapter
{
  JFrame frame;

  cloturerView()
  {
    frame = new JFrame();
    frame.addWindowListener(this);
    frame.setSize(250, 250);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void windowClosing(WindowEvent e) 
  {
	  int res = JOptionPane.showConfirmDialog(frame, "Souhaitez-vous procéder à la clotûre de ce compte?",
				"Clôturer Compte", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		else if (res == JOptionPane.NO_OPTION)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


  public static void main(String[] args) 
  {
    new  cloturerView();
  }
}