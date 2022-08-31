import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class EmployeeMap extends RobinGUI{
	
	static String employeeSeatNumber;
	static JLabel requestedSeatLB = new JLabel();
	//String of user requested seat.
	static String empRequestSeat;

	static void mainMenu() {	
		//Title label
		getTitle(400,"Map menu");
	    employeeMenuBTN();	
	    SQLScripts.GetSeatList2();
		RobinGUI.getUserLB(390, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(200, 75, "Please select a seat number: ");
		SQLScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 AdminMap.buttonErrorLB(315,490,"Please cancel request before requesting a new seat.");
			 requestedSeatLB(580,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	
	
	static void requestedSeatLB(int lbX, int lbY, String Label)  {
		requestedSeatLB.setBounds(lbX,lbY,400,30);
		requestedSeatLB.setText(Label);
		panel.add(requestedSeatLB);
	}
}

