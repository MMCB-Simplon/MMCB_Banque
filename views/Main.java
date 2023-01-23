package views;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/*
 * Page permettant de lancer notre application
 * Ajout d'un thème en utilisant le look Nimbus
 */

public class Main {

	public static void main (String [] args)throws Exception { 
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		UserView userView = new UserView(); 
		//Lancement de la vue
		userView.setVisible(true);	
	}
	}


