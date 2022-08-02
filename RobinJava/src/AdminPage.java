import javax.swing.SwingUtilities;

public class AdminPage extends RobinGUI {

	
	 public static void mainMenu() {
		  	
		//Title label
		getTitle(230,"Admin Menu");
		homebackBTN();
		adminrequestBTNMethod();
		adminprofileBTNMethod();
		adminchangeSeatBTNMethod();
		requestLBMethod(2);
		SwingUtilities.updateComponentTreeUI(panel);	
			
		return;
	   }

	 
	 
}


