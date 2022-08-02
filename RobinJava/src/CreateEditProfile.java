import javax.swing.SwingUtilities;

public class CreateEditProfile extends RobinGUI{
	
	static void mainMenu() {
	
		//Title label
		RobinGUI.getTitle(230,"Create Menu");
		
		//TextBox and Labels GUI
		getUserLB(35,100,"Insert Username: ");
		getUserTB(150,100,null);
		getPassLB(35,140,"Insert Password: " );
		getPassTB(150,140,null);
		getFnameLB(35,180,"Insert first Name: ");
		getFnameTB(150,180, null);
		getLnameLB(35,220,"Insert Last Name: ");
		getLnameTB(150,220, null);
		getMapLB(35,260,"Insert map id: ");
		getMapTB(150,260);
		
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
		//Create Button WIP
		createBTN();
		backProfileBTN();
	}
	
}

