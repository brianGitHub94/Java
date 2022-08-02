import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

public class RobinGUI {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel titlePageLB = new JLabel();
	static JTextField usernameTB = new JTextField();
	static JTextField passwordTB = new JTextField();
	static JLabel usernameLB = new JLabel();
	static JLabel passwordLB = new JLabel();
	static JTextField fNameTB = new JTextField();
	static JTextField lNameTB = new JTextField();
	static JLabel fNameLB = new JLabel();
	static JLabel lNameLB = new JLabel();
	static JLabel welcomeLB = new JLabel();
	static JButton homeBTN = new JButton();
	static JButton loginBTN = new JButton();
	static HashMap<String, String> happy = new HashMap<String, String>();
	static ArrayList<String> username = new ArrayList<String>();
	static JLabel requestLB = new JLabel();
	static JButton adminMenuBTN = new JButton();
	static JButton employeeMenuBTN = new JButton();
	static JButton profileBTN = new JButton();
	static JButton changeSeatBTN = new JButton();
	static JButton adminrequestBTN = new JButton();
	static JButton adminprofileBTN = new JButton();
	static JButton adminchangeSeatBTN = new JButton();
	static JButton insertBTN = new JButton();
	static JButton backProfileBTN = new JButton();
	static JButton createMenuBTN = new JButton();
	static JButton createBTN = new JButton();
	static JLabel mapLB = new JLabel();
	static NumberFormat longFormat = NumberFormat.getIntegerInstance();
	static NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	static JFormattedTextField mapNumberTB = new JFormattedTextField(numberFormatter);
	static JLabel insertCompleteLB = new JLabel(); 
	
	public RobinGUI() {
	//Setting the size of the window when it opens.
	frame.setSize(550,550);
	//Default close operation.
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//To set a title which will be displayed out the top center of the window.
	frame.setTitle("RobinJava");
	//Sets panel layout to null.
	panel.setLayout(null);
	//More default frame options.
	//frame.pack();
	frame.setVisible(true);
	frame.add(panel);
	
	homeBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			loginPage.loginPageMenu();
			
		}
	});
	
	loginBTN.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SQLScripts.sqlConnection(usernameTB.getText());
		}
	});
	
	adminMenuBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			AdminPage.mainMenu();
			
		}
	});
	
	employeeMenuBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			SQLScripts.sqlConnection(EditProfile.employeeUsername);
			employeePage.mainMenu();
		}
	});
	
	profileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		
			panel.removeAll();
			EditProfile.mainMenu();
			
		}
	});
	
	changeSeatBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			EmployeeMap.mainMenu();
		}
	});
	
	adminprofileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			ProfileList.mainMenu();
			
		}
	});
	
	adminchangeSeatBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			AdminMap.mainMenu();
		}
	});
	
	adminrequestBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			RequestPage.mainMenu();
		}
	});
	
	insertBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SQLScripts.updateName(EditProfile.employeeID,fNameTB.getText(),lNameTB.getText(), passwordTB.getText());
			
			
		
		}
	});
	
		backProfileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			ProfileList.mainMenu();
		}
	});
	
		createMenuBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				CreateEditProfile.mainMenu();
			}
		});	
		
		createBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SQLScripts.insertAccount(0, fNameTB.getText(), lNameTB.getText(), usernameTB.getText(), passwordTB.getText(), mapNumberTB.getText());
				
				
			
			}
		});
			
}

	//Get screen title
	public static void getTitle(int xValue, String title)  {
		//Title label
		titlePageLB.setBounds(xValue,20,250,30);
		titlePageLB.setText(title);
		panel.add(titlePageLB);
		return;
	}

	//Get Username label
	static void getUserLB(int lbX, int lbY, String text)  {
		usernameLB.setBounds(lbX,lbY,250,30);
		usernameLB.setText(text);
		panel.add(usernameLB);
	}
	//Get Password label
	static void getPassLB(int lbX, int lbY, String text)  {
		passwordLB.setBounds(lbX,lbY,250,30);
		passwordLB.setText(text);
		panel.add(passwordLB);
	}
	//Get Username textbox
	static void getUserTB(int tbX, int tbY, String text)  {
		usernameTB.setBounds(tbX,tbY,250,30);
		//Adding text box to panel.
		panel.add(usernameTB);
		//Setting text to null.
		usernameTB.setText(text);
	
	}
	//Get Password textbox
	static void getPassTB(int tbX, int tbY, String text)  {
		passwordTB.setBounds(tbX,tbY,250,30);
		//Adding text box to panel.
		panel.add(passwordTB);
		//Setting text to null.
		passwordTB.setText(text);
		
	}
	//Get First name label
	static void getFnameLB(int lbX, int lbY, String Label)  {
		//first name label
		fNameLB.setBounds(lbX,lbY,250,30);
		fNameLB.setText(Label);
		panel.add(fNameLB);
	}
	//Get last name label
	static void getLnameLB(int lbX, int lbY, String Label)  {
		lNameLB.setBounds(lbX,lbY,250,30);
		lNameLB.setText(Label);
		panel.add(lNameLB);
	}
	//Get FirstName textbox
	static void getFnameTB(int tbX, int tbY, String text)  {
	fNameTB.setBounds(tbX,tbY,250,30);
	//Adding text box to panel.
	panel.add(fNameTB);
	//Setting text to null.
	fNameTB.setText(text);
	}
	//Get LastName textbox
	static void getLnameTB(int tbX, int tbY, String text)  {
	lNameTB.setBounds(tbX,tbY,250,30);
	//Adding text box to panel.
	panel.add(lNameTB);
	//Setting text to null.
	lNameTB.setText(text);
	}
	
	//Get maplabel
	static void getMapLB(int lbX, int lbY, String Label)  {
			mapLB.setBounds(lbX,lbY,250,30);
			mapLB.setText(Label);
			panel.add(mapLB);
		}
	
		
	static void getMapTB(int tbX, int tbY)  {
			numberFormatter.setAllowsInvalid(false);
			mapNumberTB.setBounds(tbX,tbY,250,30);
			//Adding text box to panel.
			panel.add(mapNumberTB);
			//Setting text to null.
			mapNumberTB.setText(null);
			}
	
	static void getInsertLB(int lbX, int lbY, String Label)  {
		insertCompleteLB.setBounds(lbX,lbY,250,30);
		insertCompleteLB.setText(Label);
		panel.add(insertCompleteLB);
	}
	
	//Welcome label
	static void getWelcomeLB()  {
	welcomeLB.setText("Welcome " + EditProfile.employeeName);
	panel.add(welcomeLB);
	welcomeLB.setBounds(220,320,250,30);
	
	}
	
	//Buttons 
	
	//Home back button
	public static void homebackBTN() {
		homeBTN.setBounds(50, 450, 100, 40);
		homeBTN.setText("back");
		panel.add(homeBTN);
		SwingUtilities.updateComponentTreeUI(panel);
	}
		
	public static void loginBTN() {
		loginBTN.setBounds(230, 180, 100, 30);
		loginBTN.setText("login");
		panel.add(loginBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
		
	public static void requestLBMethod(int i) {
		if (i == 1) {
		requestLB.setBounds(50, 50, 200, 50);
		requestLB.setText("Number of requests: 0");
		} else if (i == 2) {
			requestLB.setBounds(50, 50, 200, 50);
			requestLB.setText("Approval status: Pending");
		}
		panel.add(requestLB);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	
	public static void adminMenuBTN() {
		adminMenuBTN.setBounds(50, 450, 100, 40);
		adminMenuBTN.setText("back");
		panel.add(adminMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
			
	}
	
	public static void employeeMenuBTN() {
		employeeMenuBTN.setBounds(50, 450, 100, 40);
		employeeMenuBTN.setText("back");
		panel.add(employeeMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	
	//Employee Page specific buttons 
	public static void profileBTNMethod() {
		profileBTN.setBounds(125, 100, 150, 40);
		profileBTN.setText("Edit profiles");
		panel.add(profileBTN);
	SwingUtilities.updateComponentTreeUI(panel);		
}

public static void changeSeatBTNMethod() {
	changeSeatBTN.setBounds(275, 100, 150, 40);
	changeSeatBTN.setText("Change seat");
	panel.add(changeSeatBTN);
	SwingUtilities.updateComponentTreeUI(panel);	
	
}

//Admin specific buttons

public static void adminprofileBTNMethod() {
	 adminprofileBTN.setBounds(250, 100, 175, 40);
	 adminprofileBTN.setText("Create and edit profiles");
		panel.add(adminprofileBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}

	public static void adminchangeSeatBTNMethod() {
		adminchangeSeatBTN.setBounds(150, 200, 200, 40);
		adminchangeSeatBTN.setText("View map and Change seats");	
		panel.add(adminchangeSeatBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	
	public static void adminrequestBTNMethod() {
		adminrequestBTN.setBounds(100, 100, 150, 40);
		adminrequestBTN.setText("View requests");
		panel.add(adminrequestBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	
	//Edit button for the employee edit page
	public static void editBTNMethod() {
		insertBTN.setBounds(175, 275, 200, 40);
		insertBTN.setText("Complete edit");
		panel.add(insertBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	
	public static void backProfileBTN () {
		backProfileBTN.setBounds(50, 450, 100, 40);
		backProfileBTN.setText("back");
		panel.add(backProfileBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	//Button that takes you to the create profile page
	 public static void createMenuBTN() {
	 	createMenuBTN.setBounds(325, 50, 200, 40);
	 	createMenuBTN.setText("Create profile");
		panel.add(createMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
			
	}
	 
	 public static void insertBTN() {
		 	createMenuBTN.setBounds(175, 275, 200, 40);
		 	createMenuBTN.setText("Create new profile");
			panel.add(createMenuBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
				
		}
	 
	 
	 public static void createBTN() {
			createBTN.setBounds(175, 300, 200, 40);
			createBTN.setText("Create account");
			panel.add(createBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void main(String arg[]) {
			new RobinGUI();
			loginPage.loginPageMenu();
			
		}


}
