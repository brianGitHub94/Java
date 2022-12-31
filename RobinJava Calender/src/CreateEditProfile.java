import javax.swing.SwingUtilities;

public class CreateEditProfile extends RobinGUI{
	//Admin create menu to insert new data to the PostGres database.
	static void mainMenu() {
		//Title label
		RobinGUI.getTitle(515,"Create Menu");
		//TextBox and Labels GUI for the create profile menu.
		getUserLB(400,100,"Insert Username: ");
		getUserTB(515,100,null);
		getSecondLB(400,140,"Insert Password: " );
		getPassTB(515,140,null);
		getThirdLB(400,180,"Insert first Name: ");
		getFnameTB(515,180, null);
		getLnameLB(400,220,"Insert Last Name: ");
		getLnameTB(515,220, null);
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
		//Inserts account details to the database.
		createBTN();
		//Back button.
		backProfileBTN();
	}	
}

