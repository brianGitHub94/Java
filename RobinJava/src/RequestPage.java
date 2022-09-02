import javax.swing.SwingUtilities;

	public class RequestPage extends RobinGUI{
		
		static String AdminRequestSeat;

		static void mainMenu() {		
		//Title label
	    getTitle(500,"Request Page");
	    adminMenuBTN(50);	
	    adminEmpRequestBTN();
	    adminCancelEmpRequestBTN();
	    SQLTableScripts.GetRequestList();
	    AdminMap.seatNumberLB(200, 75, "Please select a user: ");
		SwingUtilities.updateComponentTreeUI(panel);	
	}
}
