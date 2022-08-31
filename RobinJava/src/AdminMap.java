import javax.swing.SwingUtilities;

public class AdminMap extends RobinGUI{		
static String seatNumber;
static String seatAssigned;
static String SeatEmployee;
static int counter = 0;
static String seatValue;
static String emailValue;
static String employeeAssigned; 
static Integer employeeSeatEmpty;
static String employeeSeatEmpty2;
static String originalSeatID;
static Integer numberOfRequests;
static String RequestedEmail;	

	static void mainMenu() {
		seatValue = null;
		//Title label
		getTitle(420,"MAIN ROOM");
		//Button that takes admin to the main menu.
		adminMenuBTN(50);
		getSearchTB(100, 350, null);
		mapSearchBTN();
		previousRoomBTN();
		nextRoomBTN();
		assignSeatBTN();
		removeSeatBTN();
		seatNumberLB(500,300 ,"Please select a seat number: ");
		SQLScripts.GetEmailsMapList();
		SQLScripts.GetSeatList();
		if ((counter == 0)) {
			getThirdLB(100, 300,"Select an Account: ");
		}
		SwingUtilities.updateComponentTreeUI(panel);		
	}
}
