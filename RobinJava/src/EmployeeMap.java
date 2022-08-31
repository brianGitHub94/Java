import javax.swing.SwingUtilities;

public class EmployeeMap extends RobinGUI{
	//String of seat number selected.
	static String employeeSeatNumber;
	//String of user requested seat.
	static String empRequestSeat;

	static void mainMenu() {	
		//Title label
		getTitle(400,"Map menu");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2();
		RobinGUI.getUserLB(390, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(200, 75, "Please select a seat number: ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(315,490,"Please cancel request before requesting a new seat.");
			 getSecondLB(580,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		SwingUtilities.updateComponentTreeUI(panel);	
	}	
}

