import javax.swing.SwingUtilities;

public class CreateEditProfile extends RobinGUI{
	
	//Admin create menu to insert new data to the PostGres database.
	static void mainMenu() {
		//Title label
		RobinGUI.getTitle(430,"Create Menu");
		//TextBox and Labels GUI for the create profile menu.
		getUserLB(235,100,"Insert Username: ");
		getUserTB(350,100,null);
		getPassLB(235,140,"Insert Password: " );
		getPassTB(350,140,null);
		getFnameLB(235,180,"Insert first Name: ");
		getFnameTB(350,180, null);
		getLnameLB(235,220,"Insert Last Name: ");
		getLnameTB(350,220, null);
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
		//Inserts account details to the database.
		createBTN();
		//Back button.
		backProfileBTN();
	}	
}

