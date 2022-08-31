import javax.swing.SwingUtilities;

public class AdminPage extends RobinGUI {
	
	

	//Admin menu. Pages to take you to the edit/create profile pages, request page, and map page. 
	 public static void mainMenu() {	
		 //Resets the email value.
		 AdminMap.emailValue = null;
		 //Resets the seat value.
		 AdminMap.counter = 0;
		 //Resets the seat value.
		 AdminMap.seatValue = null;
		 AdminMap.employeeAssigned = null;
		 //Resest requested email value
		 RequestedEmail = null;
		//Title label
		getTitle(400,"Admin Menu");
		//Log out button.
		homebackBTN();
		//Admin request page.
		adminrequestBTNMethod();
		//Create and edit profile page.
		adminprofileBTNMethod();
		//Admin map page.
		adminchangeSeatBTNMethod();
		//Request label.
		requestLBMethod(1);
		SwingUtilities.updateComponentTreeUI(panel);	
	   }
}


