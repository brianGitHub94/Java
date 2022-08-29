import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
	static JLabel insertCompleteLB = new JLabel(); 
	static JTextField searchTB = new JTextField();
	static JLabel searchLB = new JLabel(); 
	static JButton searchBTN = new JButton();
	static JButton adminProfileListBTN = new JButton();
	static JLabel errorLB = new JLabel();
	static JButton nextRoomBTN = new JButton();
	static JButton previousRoomBTN = new JButton();
	static JButton mapSearchBTN = new JButton();
	static JButton assignSeatBTN = new JButton();
	static JButton removeSeatBTN = new JButton();
	static JButton empRequestBTN = new JButton();
	static JButton cancelEmpRequestBTN = new JButton();
	static JButton adminEmpRequestBTN = new JButton();
	static JButton adminCancelEmpRequestBTN = new JButton();
	static String RequestedEmail;
	public RobinGUI() {
	//Setting the size of the window when it opens.
	frame.setSize(900,650);
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
	
	//Logs user out and takes them to the home page.
	homeBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			loginPage.loginPageMenu();	
		}
	});
	//Logs the user in to either the employee or admin page.
	loginBTN.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SQLScripts.sqlConnection(usernameTB.getText());
		}
	});
	//Takes admin back to the admin menu.
	adminMenuBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			AdminPage.mainMenu();
			
		}
	});
	//Takes user back to the employee page from the edit menu. 
	employeeMenuBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			SQLScripts.sqlConnection(EditProfile.employeeUsername);
			employeePage.mainMenu();
		}
	});
	//Takes user to the edit profile page.
	profileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			EditProfile.mainMenu(1);
			
		}
	});
	//Takes user to the map page.
	changeSeatBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			EmployeeMap.mainMenu();
		}
	});
	//Takes admin to the profile list page.
	adminprofileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			ProfileList.mainMenu();
			
		}
	});
	//Takes admin to the admin map page.
	adminchangeSeatBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			AdminMap.mainMenu();
		}
	});
	//Takes admin to the request page.
	adminrequestBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			RequestPage.mainMenu();
		}
	});
	
	//Edits account information in the database.
	insertBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SQLScripts.updateName(EditProfile.employeeID,fNameTB.getText(),lNameTB.getText(), passwordTB.getText());

		}
	});
		//Takes user back to the profile list menu. (Admin page)
		backProfileBTN.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			ProfileList.mainMenu();
		}
	});
		//Takes user back to the Admin profile list menu from employee Page. (Admin page/Employee Page)
				adminProfileListBTN.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					ProfileList.mainMenu();
				}
			});
		
		//Takes user to the create edit profile.
		createMenuBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				CreateEditProfile.mainMenu();
			}
		});	
		//Inserts account data to the database.
		createBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fNameTB.getText().equals("") || lNameTB.getText().equals("") || usernameTB.getText().equals("") || passwordTB.getText().equals("")){
				panel.removeAll();
				 getAccountNotFoundLB(380, 325, "Account details cannot be empty");
				 CreateEditProfile.mainMenu();
				} else {
					SQLScripts.insertAccount(0, fNameTB.getText(), lNameTB.getText(), usernameTB.getText(), passwordTB.getText());
				}
				}
		});			
		//Logs the user in to either the employee or admin page.
		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SQLScripts.sqlConnectionAdmin(searchTB.getText());
				
			}
		});
		
		//Searches user in the admin map.
		mapSearchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SQLScripts.sqlConnectionGetAccount(searchTB.getText());					
			}
	});			
		//Searches user in the admin map.
				assignSeatBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (AdminMap.emailValue == null) {
							panel.removeAll();
							AdminMap.mainMenu();
							AdminMap.buttonErrorLB(280, 320, "Please select a current employee from list before assigning.");
							SwingUtilities.updateComponentTreeUI(panel);	
						} else if (AdminMap.seatNumberLB.getText() == "Please select a seat number: ") {
							AdminMap.buttonErrorLB(380, 320, "Please select a seat.");
							SwingUtilities.updateComponentTreeUI(panel);	
						} else if (!(AdminMap.seatValue == null)) {
						panel.removeAll();
						AdminMap.mainMenu();
						AdminMap.buttonErrorLB(350, 320, "Please empty seat before assigning.");
						//resets email value
						AdminMap.emailValue = null;
						AdminMap.employeeAssigned = null;
						AdminMap.seatValue = null;
						SwingUtilities.updateComponentTreeUI(panel);	
					}	else if (AdminMap.seatValue == null && AdminMap.employeeAssigned == null) {
						SQLScripts.GetAccountSeat();
					} else {
						AdminMap.buttonErrorLB(250, 320, "Please remove employee from assigned seat before assigning.");
						SwingUtilities.updateComponentTreeUI(panel);	
					}
					}
			});			
				//Searches user in the admin map.
				removeSeatBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 if (AdminMap.seatNumberLB.getText() == "Please select a seat number: ") {
							AdminMap.buttonErrorLB(380, 320, "Please select a seat.");
							SwingUtilities.updateComponentTreeUI(panel);	
						} else if (AdminMap.seatValue == null) {
						panel.removeAll();
						AdminMap.mainMenu();
						AdminMap.buttonErrorLB(390, 320, "Seat is already empty.");
						//resets email value
						AdminMap.emailValue = null;
						AdminMap.employeeAssigned = null;
						AdminMap.seatValue = null;
						SwingUtilities.updateComponentTreeUI(panel);	
					}	else if (AdminMap.seatValue != null) {
						SQLScripts.GetAccountSeat3();
					} 	 
				}
			});	
				
				
				//Request button for user in employee map page
				empRequestBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 if (AdminMap.seatNumberLB.getText() == "Please select a seat number: ") {
						 	System.out.println("hi");
							SwingUtilities.updateComponentTreeUI(panel);	
						} 
						SwingUtilities.updateComponentTreeUI(panel);	
					}	
			});			
				//Cancel request button for user in employee map page
				cancelEmpRequestBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 if (AdminMap.seatNumberLB.getText() == "Please select a seat number: ") {
						 	System.out.println("hi");
							SwingUtilities.updateComponentTreeUI(panel);	
						} 
						SwingUtilities.updateComponentTreeUI(panel);	
					}	
			});	
				
				//Approve button for admin in Admin request page
				adminEmpRequestBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { 
						 	System.out.println("hi");
							SwingUtilities.updateComponentTreeUI(panel);	
						SwingUtilities.updateComponentTreeUI(panel);	
					}	
			});			
				//Deny request button for admin in Admin request page
				adminCancelEmpRequestBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {
						if (RequestedEmail == null) {
							
							SwingUtilities.updateComponentTreeUI(panel);
						} else {
							SQLScripts.removeRequestedSeat();
							panel.removeAll();
							RequestedEmail = null;
							RequestPage.mainMenu();			
						}
						
							
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
		usernameLB.setBounds(lbX,lbY,300,30);
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
	
	//Get search label for search textbox
		static void getSearchLB(int lbX, int lbY, String Label)  {
				searchLB.setBounds(lbX,lbY,250,40);
				searchLB.setText(Label);
				panel.add(searchLB);
			}
		
		//Get search textbox
		static void getSearchTB(int tbX, int tbY, String text)  {
			searchTB.setBounds(tbX,tbY,150,40);
			//Adding text box to panel.
			panel.add(searchTB);
			//Setting text to null.
			searchTB.setText(text);
		}
			
	//Method that displays the insert label
	static void getInsertLB(int lbX, int lbY, String Label)  {
		insertCompleteLB.setBounds(lbX,lbY,250,30);
		insertCompleteLB.setText(Label);
		panel.add(insertCompleteLB);
	}
	
	//Method that displays the welcome label
	static void getWelcomeLB()  {
		welcomeLB.setText("Welcome " + EditProfile.employeeName);
		panel.add(welcomeLB);
		welcomeLB.setBounds(420,320,250,30);
	
	}
	
	//Get accoount not found label 
	static void getAccountNotFoundLB(int lbX, int lbY, String Label)  {
			errorLB.setBounds(lbX,lbY,250,30);
			errorLB.setText(Label);
			panel.add(errorLB);
				}
	
	//Method that displays the request text
		public static void requestLBMethod(int i) {
			if (i == 1) {
			requestLB.setBounds(50, 50, 200, 50);
			requestLB.setText("Number of requests: 0");
			} else if (i == 2) {
				requestLB.setBounds(370, 100, 200, 50);
				requestLB.setText("Approval status: Pending");
			}
			panel.add(requestLB);
			SwingUtilities.updateComponentTreeUI(panel);			
		}
	
	//Buttons 
	
	//Home back button
	public static void homebackBTN() {
		homeBTN.setBounds(50, 500, 100, 40);
		homeBTN.setText("back");
		panel.add(homeBTN);
		SwingUtilities.updateComponentTreeUI(panel);
	}
		//Button that logs the user into the admin or employee page.
	public static void loginBTN() {
		loginBTN.setBounds(400, 200, 100, 40);
		loginBTN.setText("login");
		panel.add(loginBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	
	//Button that takes you back to the admin menu
	public static void adminMenuBTN(int x) {
		adminMenuBTN.setBounds(x, 500, 100, 40);
		adminMenuBTN.setText("back");
		panel.add(adminMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
			
	}
	// Button that takes you back to the employee menu
	public static void employeeMenuBTN() {
		employeeMenuBTN.setBounds(50, 500, 100, 40);
		employeeMenuBTN.setText("back");
		panel.add(employeeMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	
	//Employee Page specific buttons 
	//Button that takes you to the employee edit profile page 
	public static void profileBTNMethod() {
		profileBTN.setBounds(200, 200, 250, 50);
		profileBTN.setText("Edit profiles");
		panel.add(profileBTN);
	SwingUtilities.updateComponentTreeUI(panel);		
}
	//Button that takes you to the employee change seat page 
	public static void changeSeatBTNMethod() {
	changeSeatBTN.setBounds(450, 200, 250, 50);
	changeSeatBTN.setText("Change seat");
	panel.add(changeSeatBTN);
	SwingUtilities.updateComponentTreeUI(panel);	
	
}

	//Admin specific buttons
	//A button that takes you to the admin profile page
	public static void adminprofileBTNMethod() {
	 adminprofileBTN.setBounds(350, 200, 175, 40);
	 adminprofileBTN.setText("Create and edit profiles");
		panel.add(adminprofileBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	//A button that takes you to the admin Change seat page
	public static void adminchangeSeatBTNMethod() {
		adminchangeSeatBTN.setBounds(550, 200, 200, 40);
		adminchangeSeatBTN.setText("View map and Change seats");	
		panel.add(adminchangeSeatBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
		
	}
	//A button that takes you to the admin request page
	public static void adminrequestBTNMethod() {
		adminrequestBTN.setBounds(150, 200, 175, 40);
		adminrequestBTN.setText("View requests");
		panel.add(adminrequestBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	
	//Edit button for the employee edit page
	public static void editBTNMethod() {
		insertBTN.setBounds(375, 275, 200, 40);
		insertBTN.setText("Complete edit");
		panel.add(insertBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	//Button that takes you back to the profile page
	public static void backProfileBTN () {
		backProfileBTN.setBounds(50, 500, 100, 40);
		backProfileBTN.setText("back");
		panel.add(backProfileBTN);
		SwingUtilities.updateComponentTreeUI(panel);	
	}
	//Button that takes you back to the Admin profile list page
		public static void adminProfileListBTN () {
			adminProfileListBTN.setBounds(50, 500, 100, 40);
			adminProfileListBTN.setText("back");
			panel.add(adminProfileListBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	
	//Button that takes you to the create profile page
	 public static void createMenuBTN() {
	 	createMenuBTN.setBounds(680, 50, 200, 40);
	 	createMenuBTN.setText("Create profile");
		panel.add(createMenuBTN);
		SwingUtilities.updateComponentTreeUI(panel);			
	}

	 //Buton that insert a new account to the database
	 public static void createBTN() {
			createBTN.setBounds(375, 275, 200, 40);
			createBTN.setText("Create account");
			panel.add(createBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 //Buton that insert a new account to the database
	 public static void searchBTN() {
			searchBTN.setBounds(680, 500, 200, 40);
			searchBTN.setText("search account");
			panel.add(searchBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	//Buton that insert a new account to the database
		 public static void mapSearchBTN() {
				mapSearchBTN.setBounds(260, 350, 60, 40);
				mapSearchBTN.setText("Search");
				panel.add(mapSearchBTN);
				SwingUtilities.updateComponentTreeUI(panel);	
			}
	 
	 //Buton that insert a new account to the database
	 public static void nextRoomBTN() {
			nextRoomBTN.setBounds(350, 450, 125, 40);
			nextRoomBTN.setText("Previous Room");
			panel.add(nextRoomBTN);
			SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void previousRoomBTN() {
		 previousRoomBTN.setBounds(475, 450, 100, 40);
		 previousRoomBTN.setText("Next Room");
		 panel.add(previousRoomBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 	
	 public static void assignSeatBTN() {
		 assignSeatBTN.setBounds(475, 400, 100, 40);
		 assignSeatBTN.setText("Assign seat");
		 panel.add(assignSeatBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void removeSeatBTN() {
		 removeSeatBTN.setBounds(350, 400, 125, 40);
		 removeSeatBTN.setText("Remove Seat");
		 panel.add(removeSeatBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 
	 public static void empRequestBTN() {
		 empRequestBTN.setBounds(475, 450, 170, 40);
		 empRequestBTN.setText("Request seat change");
		 panel.add(empRequestBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void cancelEmpRequestBTN() {
		 cancelEmpRequestBTN.setBounds(300, 450, 170, 40);
		 cancelEmpRequestBTN.setText("cancel request");
		 panel.add(cancelEmpRequestBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void adminEmpRequestBTN() {
		 adminEmpRequestBTN.setBounds(455, 450, 170, 40);
		 adminEmpRequestBTN.setText("Approve Request");
		 panel.add(adminEmpRequestBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 public static void adminCancelEmpRequestBTN() {
		 adminCancelEmpRequestBTN.setBounds(280, 450, 170, 40);
		 adminCancelEmpRequestBTN.setText("Deny Request");
		 panel.add(adminCancelEmpRequestBTN);
		 SwingUtilities.updateComponentTreeUI(panel);	
		}
	 
	 
	 //Main method
	 public static void main(String arg[]) {
			new RobinGUI();
			loginPage.loginPageMenu();
			
		}
}
