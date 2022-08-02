import javax.swing.SwingUtilities;

public class EditProfile extends RobinGUI{
	static String nameforLB;
	static String employeeName;
	static String employeeLName;
	static String employeePassword;
	static String employeeUsername;
	static int employeeID;
	static int employeeMapID;
	
	static void mainMenu() {
		//Title label
		getTitle(230,"Edit Menu");
		System.out.println(nameforLB);
		//TextBox and Labels GUI
		getUserLB(35,100,"Username:              " + employeeUsername);
		getPassLB(35,140,"Insert Password: " );
		getPassTB(150,140,employeePassword);
		getFnameLB(35,180,"Insert first Name: ");
		getFnameTB(150,180,employeeName);
		getLnameLB(35,220,"Insert Last Name: ");
		getLnameTB(150,220,employeeLName);
		
		//Create button 
		editBTNMethod();
		//Go back button
		employeeMenuBTN();
		SwingUtilities.updateComponentTreeUI(panel);	
		return;
	}
	
	
	
	
}
	
	
	

	

	
	


