import javax.swing.SwingUtilities;

public class EmployeeMap extends RobinGUI{
	//String of seat number selected.
	static String employeeSeatNumber;
	//String of user requested seat.
	static String empRequestSeat;

	static void mainMenu() {	
		//Title label
		getTitle(500,"Map menu");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2();
		RobinGUI.getUserLB(440, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(300, 75, "Please select a seat number: ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(415,490,"Please cancel request before requesting a new seat.");
			 getSecondLB(680,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		SwingUtilities.updateComponentTreeUI(panel);	
	}	
}

