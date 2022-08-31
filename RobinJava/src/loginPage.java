import javax.swing.SwingUtilities;

public class loginPage extends RobinGUI{
		
	static void loginPageMenu() {	
			//Title label
			getTitle(370,"Robin Java Application");
			getUserLB(200,100,"Insert Username: ");
			getUserTB(330,100,null);
			getSecondLB(200,140,"Insert Password: " );
			getPassTB(330,140,null);	
			//Login button
			loginBTN();
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	}
