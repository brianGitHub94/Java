import javax.swing.SwingUtilities;

	public class RequestPage extends RobinGUI{
		
		static String AdminRequestSeat;

		static void mainMenu() {		
		//Title label
	    getTitle(490,"Current Request Page");
	    adminMenuBTN(50);	
	    adminEmpRequestBTN();
	    adminCancelEmpRequestBTN(380);
	    getFutureRequestBTN(730);
	    SQLTableScripts.GetRequestList();
	    AdminMap.seatNumberLB(250, 75, "Please select a user: ");
	    getCurrentDateTime(600);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
		
		static void ScheduledRequestPage() {
			AdminMap.RequestedEmail = null;
			//Title label
		    getTitle(490,"Scheduled Request Page");
		    AdminMap.seatNumberLB(250, 75, "Please select a scheduled request: ");
		    adminMenuBTN(50); 
		    getCurrentDateTime(600);
		    getFutureRequestBTN(650);
		    adminCancelEmpRequestBTN(470);
		    SQLTableScripts.GetFutureRequestList();
		    SwingUtilities.updateComponentTreeUI(panel);
		  
		    
		}
		
		
}
