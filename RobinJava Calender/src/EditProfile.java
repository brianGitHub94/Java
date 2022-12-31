import javax.swing.SwingUtilities;

public class EditProfile extends RobinGUI{
	//Employee first name
	static String employeeName;
	//Employee last name
	static String employeeLName;
	//Employee password
	static String employeePassword;
	//Employee email
	static String employeeUsername;
	//Employee Id
	static int employeeID;
	static String changeRequestDetail;
	
	
	static void mainMenu(int profile) {
		//Title label
		getTitle(560,"Edit Menu");
		//TextBox and Labels GUI
		getUserLB(415,100,"Username:              " + employeeUsername);
		getSecondLB(415,140,"Insert Password: " );
		getPassTB(530,140,employeePassword);
		getThirdLB(415,180,"Insert first Name: ");
		getFnameTB(530,180,employeeName);
		getLnameLB(415,220,"Insert Last Name: ");
		getLnameTB(530,220,employeeLName);	
		//Create button 
		editBTNMethod();
		/*If profile equals 1 the back button will take user back to employee page
		if equals 2 it'll take them to admin page.*/
		  if (profile == 1) {
			//Go back button
			employeeMenuBTN();
		} else 
			RobinGUI.adminProfileListBTN();
			SwingUtilities.updateComponentTreeUI(panel);	
	}	
}
	
	
	

	

	
	


