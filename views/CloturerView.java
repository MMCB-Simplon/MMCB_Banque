

package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloturerView extends WindowAdapter
{
  JFrame frame;

  CloturerView()
  {
    frame = new JFrame();
    frame.addWindowListener(this);
    frame.setSize(250, 250);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  }

  public void windowClosing(WindowEvent e) 
  {
    int res = JOptionPane.showConfirmDialog(frame,"Souhaitez-vous procéder à la clotûre de ce compte?");

    if(res == JOptionPane.YES_OPTION)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    else if (res == JOptionPane.NO_OPTION)
       frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }


  public static void main(String[] args) 
  {
    new  CloturerView();
  }
}