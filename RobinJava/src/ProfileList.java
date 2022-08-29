import javax.swing.SwingUtilities;

public class ProfileList {

	 static void mainMenu() {
		    //Title label
		 	SQLScripts.GetAllAccounts();
		    RobinGUI.getTitle(400,"Profile Menu");
		    //Label for search text box.
		    RobinGUI.getSearchLB(405, 505, "Insert email: ");
		    //Shows select account text
		    AdminMap.getEmployeeNameLB(400, 400,"Select an Account: ");
		    //Textbox
		    RobinGUI.getSearchTB(500, 500, null);
		    //Takes you to the create profile page in admin account
		    RobinGUI.createMenuBTN();
			//Button to take you back to admin menu.
		    RobinGUI.adminMenuBTN(50);
		    // Search button to search for account.
		    RobinGUI.searchBTN();	    
		    SwingUtilities.updateComponentTreeUI(RobinGUI.panel);			
	   }	
}
