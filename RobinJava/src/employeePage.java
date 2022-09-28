import javax.swing.SwingUtilities;

public class employeePage extends RobinGUI{
	
	static String empSeatid;
	
	static void mainMenu() {
		    //Title label
		    panel.setBounds(0,0,1100,800);
			getTitle(460,"Employee Menu");
			//Welcome label. Displays employee's name.
			getWelcomeLB();
			//Button to log out.
			homebackBTN();	
			//Button that takes you to the edit profile menu.
			profileBTN();
			//Button that takes you to the map menu.
			changeSeatBTN();
			SQLSelectScripts.getRequestDetail();
			empLeaveSeatBTN();
	
			if (empSeatid == null) {
				empLeaveSeatBTN.setEnabled(false);
			} else {
				//Button that unassigns users from current assigned seat. 
				empLeaveSeatBTN.setEnabled(true); 
			}
			//Label that shows current seat.
			getCurrentSeatLB();
			//Request label for user.
			requestLBMethod(2);
			SwingUtilities.updateComponentTreeUI(panel);	
	   }	
	
	
}
	
	

