import java.awt.Color;

import javax.swing.SwingUtilities;

public class loginPage extends RobinGUI{
		
	static void loginPageMenu() {	
			//Title label
			getTitle(500,"Robin Java Calender");
			getUserLB(380,100,"Insert Username: ");
			getUserTB(510,100,null);
			getSecondLB(380,140,"Insert Password: " );
			getPassTB(510,140,null);	
			//Login button
			loginBTN();
			Color lightGray = new Color(220,220,220);
			panel.setBackground(lightGray);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	}
