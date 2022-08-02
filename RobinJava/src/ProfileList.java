import javax.swing.SwingUtilities;

public class ProfileList extends RobinGUI{

	
	 static void mainMenu() {
		  	
		     //Title label
		   getTitle(230,"profile Menu");
			createMenuBTN();
			adminMenuBTN();
			SwingUtilities.updateComponentTreeUI(panel);	
	   }
	
	
}
