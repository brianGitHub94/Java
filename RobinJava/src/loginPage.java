import javax.swing.SwingUtilities;

public class loginPage extends RobinGUI{
		
	static void loginPageMenu() {	
			//Title label
			getTitle(470,"Robin Java Application");
			getUserLB(300,100,"Insert Username: ");
			getUserTB(430,100,null);
			getSecondLB(300,140,"Insert Password: " );
			getPassTB(430,140,null);	
			//Login button
			loginBTN();
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	}
