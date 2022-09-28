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
		getTitle(490,"Edit Menu");
		//TextBox and Labels GUI
		getUserLB(335,100,"Username:              " + employeeUsername);
		getSecondLB(335,140,"Insert Password: " );
		getPassTB(450,140,employeePassword);
		getThirdLB(335,180,"Insert first Name: ");
		getFnameTB(450,180,employeeName);
		getLnameLB(335,220,"Insert Last Name: ");
		getLnameTB(450,220,employeeLName);	
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
	
	
	

	

	
	


