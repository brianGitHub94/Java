import javax.swing.SwingUtilities;

	public class RequestPage extends RobinGUI{
		
		static String AdminRequestSeat;

		static void mainMenu() {		
		//Title label
	    getTitle(400,"Request Page");
	    adminMenuBTN(50);	
	    adminEmpRequestBTN();
	    adminCancelEmpRequestBTN();
	    SQLScripts.GetEmailsMapList2();
	    AdminMap.seatNumberLB(100, 75, "Please select a user: ");
		SwingUtilities.updateComponentTreeUI(panel);	
	}
}
