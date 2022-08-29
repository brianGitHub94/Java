import javax.swing.SwingUtilities;

public class EmployeeMap extends RobinGUI{
	
	static String employeeSeatNumber;

	static void mainMenu() {	
		//Title label
		getTitle(400,"Map menu");
	    employeeMenuBTN();	
	    SQLScripts.GetSeatList2();
		RobinGUI.getUserLB(400, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(200, 75, "Please select a seat number: ");
		empRequestBTN();
		cancelEmpRequestBTN();
		SwingUtilities.updateComponentTreeUI(panel);	
	}
}

