import javax.swing.SwingUtilities;

public class MainGUI extends deleteGUI {

	public static void main(String[] args) {
	
				login();
				
			
				

				}
			
			
			//Pages
			
			
			static void login() {
				//Title label
						getTitle(200,"Robin Java Application");
						getUserLB(35,100,"Insert Username: ");
						getUserTB(150,100,null);
						getPassLB(35,140,"Insert Password: " );
						getPassTB(150,140,null);
						//Login button
						loginBTN();	
						SwingUtilities.updateComponentTreeUI(panel);	
				
			}
			
			
			static void adminPage () {
					  	
					//Title label
					getTitle(230,"Admin Menu");
					homebackBTN();
					adminrequestBTNMethod();
					adminprofileBTNMethod();
					adminchangeSeatBTNMethod();
					requestLBMethod(2);
					SwingUtilities.updateComponentTreeUI(panel);	
						
					return;
				   
			
			}
			

	}

