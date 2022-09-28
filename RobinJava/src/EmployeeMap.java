import javax.swing.SwingUtilities;

public class EmployeeMap extends RobinGUI{
	//String of seat number selected.
	static String employeeSeatNumber;
	//String of user requested seat.
	static String empRequestSeat;
	//Variable that gets assign a value for each room a number.
	static Integer empRoomNumber;
	//Gets value of if the seat is assigned or not and inserts it in a array.
	
	static void mainMenu() {
		
		empRoomNumber = 1;
		//Title label
		getTitle(480,"Main Room");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Main_Room");
		RobinGUI.getUserLB(220, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		empPreviousRoomBTN.setEnabled(false);
		empNextRoomBTN.setEnabled(true);
		
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(415,420,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			};	
		JavaGraphics graphics = new JavaGraphics();
		graphics.setSize(1100,1000);
		panel.add(graphics);
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
	}	

	
	static void roomTwo() {	
		empRoomNumber = 2;
		//Title label
		getTitle(480,"Room Two");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Room_Two");
		RobinGUI.getUserLB(220, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		empPreviousRoomBTN.setEnabled(true);
		empNextRoomBTN.setEnabled(true);
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(415,420,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		    JavaGraphics graphics = new JavaGraphics();
			graphics.setSize(1100,1000);
			panel.add(graphics);
			SwingUtilities.updateComponentTreeUI(panel);	
	}	
	
	static void roomThree() {	
		empRoomNumber = 3;
		//Title label
		getTitle(480,"Room Three");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Room_Three");
		RobinGUI.getUserLB(220, 400, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		empPreviousRoomBTN.setEnabled(true);
		empNextRoomBTN.setEnabled(false);
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(415,420,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		 	JavaGraphics graphics = new JavaGraphics();
			graphics.setSize(1100,1000);
			panel.add(graphics);
			SwingUtilities.updateComponentTreeUI(panel);	
	}	
	
	static void getRoom() {
		if (empRoomNumber == 1) {
			mainMenu();
		}else if (empRoomNumber == 2) {
			roomTwo();
		}else if (empRoomNumber == 3) {
			roomThree();
		}
	}
}


