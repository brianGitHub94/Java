import java.util.Arrays;

import javax.swing.SwingUtilities;

public class employeePage extends RobinGUI{
	
	
	
	static void mainMenu() {
		    //Title label
		    panel.setBounds(0,0,1100,800);
			getTitle(460,"Employee Menu");
			//Welcome label. Displays employee's name.
			getWelcomeLB();
			//Button to log out.
			homebackBTN();	
			//Button that takes you to the edit profile menu.
			profileBTNMethod();
			//Button that takes you to the map menu.
			changeSeatBTNMethod();
			SQLSelectScripts.getRequestDetail();
			//Request label for user.
			requestLBMethod(2);
			SwingUtilities.updateComponentTreeUI(panel);	
	   }	
	
	
}
	
	

