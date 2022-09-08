import javax.swing.SwingUtilities;

public class AdminMap extends RobinGUI{		
// Returns seat_number FROM seatid in getseatlist and getseatlist2 methods in SQLTableScripts.
static String seatNumber;
//Returns seat_assigned FROM seatid in getseatlist and getseatlist2 methods in SQLTableScripts.
static String seatAssigned;
//Returns employee_name FROM seatid in getseatlist and getseatlist2 methods in SQLTableScripts.
static String SeatEmployee;
/*String of seat number FROM seatid table in CheckSeatStatus method in SQLScripts and 
employee_name in mouse listener in getSeatList in SQLTableScripts. */
static String seatValue;
//Returns email string used use to check or validate email in SQL methods in Select and table SQLscripts classes.
static String emailValue;
//Use to set seat_assigned to null in SQLTableScripts and to check if the employee is assigned to a seat in Robin table.
static String employeeAssigned; 
// Returns seat_assigned FROM Robin Integer in CheckEmpSeatStatus method in SQLSelectScripts.
static Integer employeeSeatEmpty;
// Returns employee_name String in SeatID table in CheckSeatStatus and CheckSeatStatus2 methods in SQLSelectScripts.
static String employeeSeatEmpty2; 
//Seat_number in mouse listener in getSeatList in SQLTableScripts. //
static String originalSeatID;
//Returns Integer of requests.
static Integer numberOfRequests;
//Returns the email the requested a seat change.
static String RequestedEmail;
//Checks if the seat_assigned is Yes or No.
static String seatnull;
//Variable that sets the room number. 
static Integer roomNumber;

	static void mainMenu() {
		seatValue = null;
		emailValue = null;
		employeeAssigned = null;
		 //Variable that sets the room number. Current set to first room.
		roomNumber = 1;
		previousRoomBTN.setEnabled(false);
		nextRoomBTN.setEnabled(true);
		//Title label
		getTitle(450,"MAIN ROOM");
		//Button that takes admin to the main menu.
		adminMenuBTN(50);
		getSearchTB(780, 50, null);
		getLnameLB(630,60,"Search for an employee");
		mapSearchBTN();
		previousRoomBTN();
		nextRoomBTN();
		assignSeatBTN();
		removeSeatBTN();
		seatNumberLB(600,300 ,"Please select a seat number: ");
		SQLTableScripts.GetEmailsMapList();
		SQLTableScripts.GetSeatList("Main_Room");
		getThirdLB(100, 300,"Select an Account: ");
		SwingUtilities.updateComponentTreeUI(panel);		
	}
	
	static void Room2() {
		seatValue = null;
		emailValue = null;
		employeeAssigned = null;
		//Variable that sets the room number.
		roomNumber = 2;
		previousRoomBTN.setEnabled(true);
		nextRoomBTN.setEnabled(true);
		//Title label
		getTitle(480,"Room Two");
		//Button that takes admin to the main menu.
		adminMenuBTN(50);
		getSearchTB(780, 50, null);
		getLnameLB(630,60,"Search for an employee");
		mapSearchBTN();
		previousRoomBTN();
		nextRoomBTN();
		assignSeatBTN();
		removeSeatBTN();
		seatNumberLB(600,300 ,"Please select a seat number: ");
		SQLTableScripts.GetEmailsMapList();
		SQLTableScripts.GetSeatList("Room_Two");
		getThirdLB(100, 300,"Select an Account: ");
		SwingUtilities.updateComponentTreeUI(panel);		
	}
	
	static void Room3() {
		seatValue = null;
		emailValue = null;
		employeeAssigned = null;
		//Variable that sets the room number.
		roomNumber = 3;
		nextRoomBTN.setEnabled(false);
		//Title label
		getTitle(470,"Room Three");
		//Button that takes admin to the main menu.
		adminMenuBTN(50);
		getSearchTB(780, 50, null);
		getLnameLB(630,60,"Search for an employee");
		mapSearchBTN();
		previousRoomBTN();
		nextRoomBTN();
		assignSeatBTN();
		removeSeatBTN();
		seatNumberLB(600,300 ,"Please select a seat number: ");
		SQLTableScripts.GetEmailsMapList();
		SQLTableScripts.GetSeatList("Room_Three");
		getThirdLB(100, 300,"Select an Account: ");
		SwingUtilities.updateComponentTreeUI(panel);		
	}
	
	static void getRoom() {
		if (roomNumber == 1) {
			AdminMap.mainMenu();
		}else if (roomNumber == 2) {
			AdminMap.Room2();
		}else if (roomNumber == 3) {
			AdminMap.Room3();
		}
	}
}
