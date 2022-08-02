import javax.swing.SwingUtilities;

public class employeePage extends RobinGUI{

	
	static void mainMenu() {
		    //Title label
			getTitle(220,"Employee Menu");
			getWelcomeLB();
			homebackBTN();		
			profileBTNMethod();
			changeSeatBTNMethod();
			requestLBMethod(2);
			SwingUtilities.updateComponentTreeUI(panel);
			
	   }

		
		
	
		
}
	
	

