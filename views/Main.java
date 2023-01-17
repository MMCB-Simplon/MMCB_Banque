package views;

import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

	public static void main (String [] args)throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		UserView userView = new UserView();
		userView.setVisible(true);

		
	}
	}


