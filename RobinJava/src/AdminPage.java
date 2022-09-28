import javax.swing.SwingUtilities;

public class AdminPage extends RobinGUI {
	
	//Admin menu. Pages to take you to the edit/create profile pages, request page, and map page. 
	 public static void mainMenu() {
		 //Resets the email value.
		 AdminMap.emailValue = null;
		 //Resets the seat value.
		 AdminMap.seatValue = null;
		 //Checks if an employee is assigned to a seat in AdminMap.
		 AdminMap.employeeAssigned = null;
		 //Resets requested email value in AdminMap.
		 AdminMap.RequestedEmail = null; 
		 
		//Title label
		getTitle(460,"Admin Menu");
		//Log out button.
		homebackBTN();
		//Admin request page.
		adminrequestBTN();
		//Create and edit profile page.
		adminprofileBTN();
		//Admin map page.
		adminchangeSeatBTN();
		//Request label.
		requestLBMethod(1);
		SwingUtilities.updateComponentTreeUI(panel);	
	   }
}


