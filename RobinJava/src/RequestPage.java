import javax.swing.SwingUtilities;

	public class RequestPage extends RobinGUI{
		
		

		static void mainMenu() {		
		//Title label
	    getTitle(400,"Request Page");
	    adminMenuBTN(50);	
	    adminEmpRequestBTN();
	    adminCancelEmpRequestBTN();
	    SQLScripts.GetEmailsMapList2();
		SwingUtilities.updateComponentTreeUI(panel);	
	}
}
