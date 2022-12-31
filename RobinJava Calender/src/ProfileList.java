import javax.swing.SwingUtilities;

public class ProfileList extends RobinGUI {

	 static void mainMenu() {
		    //Title label
		 	SQLTableScripts.DisplayAllAccounts();
		    RobinGUI.getTitle(530,"Profile Menu");
		    //Label for search text box.
		    RobinGUI.getUserLB(400, 560, "Search email: ");
		    //Shows select account text
		    getThirdLB(575, 400,"Select an Account: ");
		    //Textbox
		    RobinGUI.getSearchTB(500, 550, null);
		    //Takes you to the create profile page in admin account
		    RobinGUI.createMenuBTN();
			//Button to take you back to admin menu.
		    RobinGUI.adminMenuBTN(100);
		    // Search button to search for account.
		    RobinGUI.searchBTN();	    
		    SwingUtilities.updateComponentTreeUI(RobinGUI.panel);			
	   }	
}
