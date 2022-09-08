import java.awt.Color;

import javax.swing.SwingUtilities;

public class loginPage extends RobinGUI{
		
	static void loginPageMenu() {	
			//Title label
			getTitle(420,"Robin Java Application");
			getUserLB(300,100,"Insert Username: ");
			getUserTB(430,100,null);
			getSecondLB(300,140,"Insert Password: " );
			getPassTB(430,140,null);	
			//Login button
			loginBTN();
			Color lightGray = new Color(220,220,220);
			panel.setBackground(lightGray);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	}
