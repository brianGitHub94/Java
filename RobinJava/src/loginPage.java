import javax.swing.SwingUtilities;

public class loginPage extends RobinGUI{
		
	static void loginPageMenu() {
		
			//Title label
			getTitle(200,"Robin Java Application");
			getUserLB(35,100,"Insert Username: ");
			getUserTB(150,100,null);
			getPassLB(35,140,"Insert Password: " );
			getPassTB(150,140,null);
				
			//Login button
			loginBTN();
			
			SwingUtilities.updateComponentTreeUI(panel);	
			return;
		}
	
	}
