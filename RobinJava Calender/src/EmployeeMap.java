
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class EmployeeMap extends RobinGUI{
	//String of seat number selected.
	static String employeeSeatNumber;
	//String of user requested seat.
	static String empRequestSeat;
	//Variable that gets assign a value for each room a number.
	static Integer empRoomNumber;
	static JLabel FutureRequestLB = new JLabel();
	static JLabel explainingLB = new JLabel();
	static Calendar calendar = Calendar.getInstance();
	static Integer day = 0;
	static Integer time = 0;
	static String employee_email = null;
	static String requested_time = null;
	
	static void getFutureRequestLB(int lbX, int lbY, String Label)  {
		explainingLB.setBounds(lbX,lbY,350,50);
		explainingLB.setText(Label);
		panel.add(explainingLB);
	} 
	//Label that instructs the user on how to use the page. 
	static void explainingLB(int lbX, int lbY, String Label)  {
		FutureRequestLB.setBounds(lbX,lbY,650,50);
		FutureRequestLB.setText(Label);
		panel.add(FutureRequestLB);
	}
	static void mainMenu() {
		EmployeeMap.employeeSeatNumber  = null;
		empRoomNumber = 1;
		//Title label
		getTitle(550,"Main Room");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Main_Room");
		RobinGUI.getUserLB(10, 30, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		getFutureRequestLB(700,60, "Future Request table");
		explainingLB(50,350, "You can make a current request and one future request. Please select a date, time, and seat. ");
;		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		SQLTableScripts.GetFutureRequestList2();
		empPreviousRoomBTN.setEnabled(false);
		empNextRoomBTN.setEnabled(true);
		getSetTimeLB();
		calendar.add(Calendar.DATE, +day);
		getDatePreviousButton();
		getDateNextButton();
		getTimePreviousButton();
		getTimeNextButton();
		getTimeSeatAcceptBTN();
		getCalendarLB(400,day);
		//getSetTimeLB2();
		//getTimeNextButton2();
		//getTimePreviousButton2();
		getCancelPriortyRequestBTN();
		SQLSelectScripts.CheckFutureRequestList4();
	
		
		
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(165,600,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			};	
		JavaGraphics graphics = new JavaGraphics();
		graphics.setSize(1200,1000);
		panel.add(graphics);
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
	}	

	
	static void roomTwo() {	
		empRoomNumber = 2;
		EmployeeMap.employeeSeatNumber  = null;
		//Title label
		getTitle(550,"Room Two");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Room_Two");
		RobinGUI.getUserLB(10, 30, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		getFutureRequestLB(700,60, "Future Request table");
		explainingLB(50,350, "You can make a current request and one future request. Please select a date, time, and seat. ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		empPreviousRoomBTN.setEnabled(true);
		empNextRoomBTN.setEnabled(true);
		SQLTableScripts.GetFutureRequestList2();
		getSetTimeLB();
		calendar.add(Calendar.DATE, +day);
		getDatePreviousButton();
		getDateNextButton();
		getTimePreviousButton();
		getTimeNextButton();
		getTimeSeatAcceptBTN();
		getCalendarLB(400,day);
		//getSetTimeLB2();
		//getTimeNextButton2();
		//getTimePreviousButton2();
		getCancelPriortyRequestBTN();
		SQLSelectScripts.CheckFutureRequestList4();
		
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(165,600,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		    JavaGraphics graphics = new JavaGraphics();
			graphics.setSize(1200,1000);
			panel.add(graphics);
		
			SwingUtilities.updateComponentTreeUI(panel);	
	}	
	
	static void roomThree() {	
		empRoomNumber = 3;
		EmployeeMap.employeeSeatNumber  = null;
		//Title label
		getTitle(550,"Room Three");
	    employeeMenuBTN();	
	    SQLTableScripts.GetSeatList2("Room_Three");
		RobinGUI.getUserLB(10, 30, "User: " + EditProfile.employeeUsername);
		AdminMap.seatNumberLB(10, 75, "Please select a seat number: ");
		getFutureRequestLB(700,60, "Future Request table");
		explainingLB(50,350, "You can make a current request and one future request. Please select a date, time, and seat. ");
		SQLSelectScripts.getRequestDetail();
		empRequestBTN();
		cancelEmpRequestBTN();
		empPreviousRoomBTN();
		empNextRoomBTN();
		empPreviousRoomBTN.setEnabled(true);
		empNextRoomBTN.setEnabled(false);
		SQLTableScripts.GetFutureRequestList2();
		getSetTimeLB();
		calendar.add(Calendar.DATE, +day);
		getDatePreviousButton();
		getDateNextButton();
		getTimePreviousButton();
		getTimeNextButton();
		getTimeSeatAcceptBTN();
		getCalendarLB(400,day);
		//getSetTimeLB2();
		//getTimeNextButton2();
		//getTimePreviousButton2();
		getCancelPriortyRequestBTN();
		SQLSelectScripts.CheckFutureRequestList4();
		
		 if (EditProfile.changeRequestDetail.equals("1") ) {
			 getFeedbackLB(165,600,"Please cancel request before requesting a new seat.");
			 getSecondLB(370,75,"Requested seat: " + empRequestSeat);
			 empRequestBTN.setEnabled(false);
			 SwingUtilities.updateComponentTreeUI(panel);	
			} else {
				empRequestBTN.setEnabled(true);
			}
		 	JavaGraphics graphics = new JavaGraphics();
			graphics.setSize(1200,1000);
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


