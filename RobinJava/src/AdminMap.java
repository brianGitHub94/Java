import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class AdminMap extends RobinGUI{	
static JLabel employeeLB = new JLabel();
static JLabel employeeEmailLB = new JLabel();	
static JLabel seatNumberLB = new JLabel();	
static String seatNumber;
static String seatAssigned;
static String SeatEmployee;
static int counter = 0;
static String seatValue;
static String emailValue;
static String employeeAssigned; 
static JLabel buttonErrorLB = new JLabel();
static Integer employeeSeatEmpty;
static String employeeSeatEmpty2;
static String originalSeatID;
static Integer numberOfRequests;

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
			AdminMap.getEmployeeNameLB(100, 300,"Select an Account: ");
		}
		SwingUtilities.updateComponentTreeUI(panel);		
	}

	static void getEmployeeLB(int lbX, int lbY, String Label)  {
		employeeLB.setBounds(lbX,lbY,250,30);
		employeeLB.setText(Label);
		panel.add(employeeLB);

	}

	static void getEmployeeNameLB(int lbX, int lbY, String Label)  {
		employeeEmailLB.setBounds(lbX,lbY,250,30);
		employeeEmailLB.setText(Label);
		panel.add(employeeEmailLB);
	}

	
	static void seatNumberLB(int lbX, int lbY, String Label)  {
		seatNumberLB.setBounds(lbX,lbY,250,30);
		seatNumberLB.setText(Label);
		panel.add(seatNumberLB);
	}

	static void buttonErrorLB(int lbX, int lbY, String Label)  {
		buttonErrorLB.setBounds(lbX,lbY,400,30);
		buttonErrorLB.setText(Label);
		panel.add(buttonErrorLB);
	}
	
}
