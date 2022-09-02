import javax.swing.SwingUtilities;

public class CreateEditProfile extends RobinGUI{
	//Admin create menu to insert new data to the PostGres database.
	static void mainMenu() {
		//Title label
		RobinGUI.getTitle(515,"Create Menu");
		//TextBox and Labels GUI for the create profile menu.
		getUserLB(320,100,"Insert Username: ");
		getUserTB(435,100,null);
		getSecondLB(320,140,"Insert Password: " );
		getPassTB(435,140,null);
		getThirdLB(320,180,"Insert first Name: ");
		getFnameTB(435,180, null);
		getLnameLB(320,220,"Insert Last Name: ");
		getLnameTB(435,220, null);
		SwingUtilities.updateComponentTreeUI(RobinGUI.panel);	
		//Inserts account details to the database.
		createBTN();
		//Back button.
		backProfileBTN();
	}	
}

