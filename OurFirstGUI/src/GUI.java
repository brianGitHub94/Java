//import java.awt.GridLayout;
//import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Queue;


public class GUI {
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();;
	private static JTextField usernameTB = new JTextField();
	private static JPasswordField passwordTB = new JPasswordField(); 
	private static JLabel titlelabel = new JLabel();
	private static JLabel savingslabel = new JLabel();
	private static JLabel checkinglabel = new JLabel(); 
	private static JLabel creditLabel = new JLabel(); 
	private static JButton goback = new JButton("Go Back");
	private static JButton loginButton = new JButton("Login");
	private static JLabel balance = new JLabel(); 
	private static JLabel transactions = new JLabel(); 
	private static int totalChecking = 1000;
	private static int totalSavings = 2000;
	private static int totalCredit = 5000;
	private static int amount = 0;
	private static int transferAmount = 0;
	private static JLabel chooseAmount;
	private static JFormattedTextField amountTB;
	private static JLabel errorCode = new JLabel("");
	private static JButton signoutButton = new JButton("Sign Out");
	private static JButton depositButton = new JButton("");
	private static JButton transferButton = new JButton();
	private static NumberFormat numberFormat = NumberFormat.getNumberInstance(); 
	private static JLabel acceptLB = new JLabel("");
	private static JLabel newBalanceLB = new JLabel();
	private static int newBalance = 0;
	private static int creditCardLimit = 6000;
	private static JButton accept = new JButton();
	private static JButton cancel = new JButton();
	private static JRadioButton checkingRadio2 = new JRadioButton();
	private static JRadioButton savingsRadio2 = new JRadioButton();
	private static JRadioButton checkingRadio = new JRadioButton();
	private static JRadioButton savingsRadio = new JRadioButton();
	private static JRadioButton creditRadio = new JRadioButton();
	private static JLabel TransferBalanceErrorLB = new JLabel();
	private static  Queue <Integer> q = new LinkedList <Integer>();
	private static  Queue <Integer> q1 = new LinkedList <Integer>();
	private static  Queue <Integer> q2 = new LinkedList <Integer>();
	private static JLabel recentLabel1 = new JLabel();
	private static JLabel recentLabel2 = new JLabel();
	private static JLabel recentLabel3= new JLabel();
	private static JLabel recentLabel4 = new JLabel();
	private static JLabel recentLabel5 = new JLabel();
	//Constructor
	public GUI() {
		//Setting up panel
		panel.setLayout(null);
		//Setting up frame
		frame.setSize(550,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Brian bank application");
		frame.add(panel);
		frame.setVisible(true);
		
		//Active listener for loginButton
	    loginButton.addActionListener(new ActionListener() {
			@Override
			//User name and password to enter the account.
			public void actionPerformed(ActionEvent e) {
				if (usernameTB.getText().equals("a") && passwordTB.getText().equals("a"))  {	
					panel.removeAll();
					mainMenu();
					} 
				}			
	    	} 
	    );		
	}	
	
	static //Method to deposit from the accounts.
	void deposit (int number) {
		amount = 0;
		amount =  Integer.parseInt(amountTB.getText());
		errorCode.setVisible(false);
		if (number == 1 & amount > 0 & amount < 1000) {
			totalChecking = totalChecking + amount ;
			balance.setText("Balance amount:     $" + totalChecking);	
		    queueMethod(amount);
		} else if (number == 2 & amount > 0 & amount < 1000) {
			totalSavings = totalSavings + amount;
			balance.setText("Balance amount:     $" + totalSavings);
			queueMethodSavings(amount);
		} else if (number == 3 & amount > 0 & amount < 1000 & checkingRadio.isSelected()) {
			totalChecking = totalChecking - amount;
			totalCredit = totalCredit - amount;
			queueMethodCredit(amount);
			queueMethod(-amount);
			balance.setText("Balance amount:     $" + totalCredit);	
		} else if (number == 3 & amount > 0 & amount < 1000 & savingsRadio.isSelected()) {
			totalSavings = totalSavings - amount;
			totalCredit = totalCredit - amount;
			queueMethodCredit(amount);
			queueMethodSavings(-amount);
		}
		
		else {
			errorCode.setText("Please make sure the amount is between $1-$999");
			errorCode.setBounds(145, 240, 400, 30);
			errorCode.setVisible(true);
			panel.add(errorCode);
			
		}
		SwingUtilities.updateComponentTreeUI(panel);
		return;
	}
	
		//Method to withdraw from the accounts.
		static void withdrawl (int number) {
			amount = 0;
			amount =  Integer.parseInt(amountTB.getText());
			errorCode.setVisible(false);
			if (number == 1 & amount > 0 & amount < 1000) {
				totalChecking = totalChecking - amount ;
				balance.setText("Balance amount:     $" + totalChecking);
				queueMethod(-amount);
			} else if (number == 2 & amount > 0 & amount < 1000) {
				totalSavings = totalSavings - amount;
				balance.setText("Balance amount:     $" + totalSavings);
				queueMethodSavings(-amount);
			} else if (number == 3 & amount > 0 & amount < 1000) {
				totalCredit = totalCredit + amount;
				balance.setText("Balance amount:     $" + totalCredit);
				queueMethodCredit(-amount);
			} else {
				errorCode.setText("Please make sure the amount is between $1-$999");
				errorCode.setBounds(145, 240, 400, 30);
				errorCode.setVisible(true);
				panel.add(errorCode);
			}
			SwingUtilities.updateComponentTreeUI(panel);
			return;
		}
	
		//SignOut button Method.
	    static void signOut(int x, int y, int height, int width)  {
		signoutButton.setBounds(x, y, height, width);
		panel.add(signoutButton);
		signoutButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				signIn();
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {					
						}	
					} 
				);		
		return;
	}	    
	    //Go back button Method
	   static void goBack(int x, int y, int height, int width ,int accountNumber)  {
		    goback = new JButton("Go back");
			goback.setBounds(x, y, height,width);
			panel.add(goback);
			goback.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					panel.removeAll();
					if (accountNumber == 0) {
						mainMenu();
					} else {
						accountMenu(accountNumber);
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				public void mouseExited(MouseEvent e) {		
					
				}	
			} 
		);	
			SwingUtilities.updateComponentTreeUI(panel);
			return;
	    }
	   
	 //titleLabel method
	 static void titleLabel(int x, int y, int height,int width,String titleText)  {
	 		titlelabel.setBounds(x, y, height, width);
	 		titlelabel.setText(titleText);
	 		titlelabel.setFont(new Font("Verdana", Font.PLAIN, 20));
	 		panel.add(titlelabel);
	   }
	//Deposit button method
	 static void depositButton(int number) {
			depositButton = new JButton("Deposit");
			if (number == 3) {
				depositButton.setText("Pay Credit Statment");
			}
			depositButton.setBounds(130, 400, 150, 30);
			panel.add(depositButton);
			depositButton.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					panel.removeAll();
					if (number == 1) {
						transfersPage(number,1);
					} else if (number == 2) {
						transfersPage(number,1);
					} else if (number == 3) {
						transfersPage(number,1);
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				public void mouseExited(MouseEvent e) {		
					
				}	
			} 
		);	
		 return;
	 }
	 //Withdraw button Method
	 static void withdrawButton(int number) {
		 JButton withdrawl = new JButton("Withdrawl");
			withdrawl.setBounds(270, 400, 150, 30);
			panel.add(withdrawl);
			withdrawl.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					panel.removeAll();
					if (number == 1) {
						transfersPage(number,2);
					} else if (number == 2) {
						transfersPage(number,2);
					} else if (number == 3) {
						transfersPage(number,2);
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				public void mouseExited(MouseEvent e) {		
					
					}	
				} 
			);
			return;
		}	
	//Transfer button Method
	 static void transferButton(int number)  {
			transferButton = new JButton("Transfer balance");
			transferButton.setBounds(210, 450, 150, 30);
			panel.add(transferButton);
			transferButton.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					panel.removeAll();
					transferChangePage(number);
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				public void mouseExited(MouseEvent e) {		
					
				}	
			} 
		);
			return;
	 }	 
	 //Transactions method for checking
	 static void recentTransactions (int number, int type)  {
		 	//First Label
		    recentLabel1.setBounds(150,150,250,20);
			//Second Label
			recentLabel2.setBounds(150,190,250,20);
			//third Label
			recentLabel3 .setBounds(150,230,250,20);
			//Fourth Label
			recentLabel4.setBounds(150,270,250,20);
			//Fifth Label
			recentLabel5.setBounds(150,310,250,20);
			//Creates dollar sign format.
			NumberFormat formatter = NumberFormat.getCurrencyInstance();	
			if (type == 1) {
			recentLabel1.setText("1.  " + formatter.format((int)q.toArray()[4]));
			recentLabel2.setText("2.  " + formatter.format((int)q.toArray()[3]));
			recentLabel3.setText("3.  " + formatter.format((int)q.toArray()[2]));
			recentLabel4.setText("4.  " + formatter.format((int)q.toArray()[1]));
			recentLabel5.setText("5.  " + formatter.format((int)q.toArray()[0]));
			}	
			if (type == 2) {
				recentLabel1.setText("1.  " + formatter.format((int)q1.toArray()[4]));
				recentLabel2.setText("2.  " + formatter.format((int)q1.toArray()[3]));
				recentLabel3.setText("3.  " + formatter.format((int)q1.toArray()[2]));
				recentLabel4.setText("4.  " + formatter.format((int)q1.toArray()[1]));
				recentLabel5.setText("5.  " + formatter.format((int)q1.toArray()[0]));
			}		
			if (type == 3) {
				recentLabel1.setText("1.  " + formatter.format((int)q2.toArray()[4]));
				recentLabel2.setText("2.  " + formatter.format((int)q2.toArray()[3]));
				recentLabel3.setText("3.  " + formatter.format((int)q2.toArray()[2]));
				recentLabel4.setText("4.  " + formatter.format((int)q2.toArray()[1]));
				recentLabel5.setText("5.  " + formatter.format((int)q2.toArray()[0]));
			}		
			panel.add(recentLabel1);
			panel.add(recentLabel2);
			panel.add(recentLabel3);
			panel.add(recentLabel4);
			panel.add(recentLabel5);
			return;		
	 } 
	 //Confirm button for transferPage
	 static void confirmButton (int number, int transferType)  {
		 JButton confirm = new JButton();
		   	confirm.setText("accept");
		   	
		   	if (number == 3) {
		   	 confirm.setBounds(230, 290, 150, 35);
		   	} else {
		    confirm.setBounds(210, 200, 150, 35);  
		   	}
	        confirm.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {	
			//will store number from textbox in variable.
			amount =  Integer.parseInt(amountTB.getText());
			//Number from textbox needs to be between 1-999
			if (amount > 0 & amount < 1000)  {
				errorCode.setVisible(false);
				//Accept button will appear.
				accept.setVisible(true);
				confirm.setVisible(false);
				//If it's the Deposit menu
				if (transferType == 1)  {
					//Ask user to confirm the amount
					if (number == 3) {
						
					if (checkingRadio.isSelected())  {
					
					acceptLB.setText("    Use amount: $" + amount + " from your Checking account");
					amountTB.setVisible(false);
					acceptLB.setVisible(true);
					chooseAmount.setVisible(false);  
					panel.remove(checkingRadio);
					panel.remove(savingsRadio);
					} else if (savingsRadio.isSelected()) {
						acceptLB.setText("     Use amount: $" + amount + " from your Savings account");
						amountTB.setVisible(false);
						acceptLB.setVisible(true);
						chooseAmount.setVisible(false);  
						panel.remove(checkingRadio);
						panel.remove(savingsRadio);
					} else if ((checkingRadio.isSelected() == false & savingsRadio.isSelected() == false)) {
						acceptLB.setText("            Please select an account to withdraw");
						amountTB.setVisible(false);
						acceptLB.setVisible(true);
						chooseAmount.setVisible(false);  
						cancel.setVisible(true);
						panel.remove(checkingRadio);
						panel.remove(savingsRadio);
						panel.remove(accept);
						cancel.setBounds(230, 200, 100, 30);
						return;
					}
					
	        }	
					else {
					acceptLB.setText("Are you sure you want to deposit the following: $" + amount);
					amountTB.setVisible(false);
					acceptLB.setVisible(true);
					chooseAmount.setVisible(false); 
	        }
					//Cancel button will appear.
					cancel.setVisible(true);
					//If it's the checking or savings account the following changes will occur.
					if (number < 3) {
						cancel.setVisible(true);
						newBalance = newBalance + amount;
						newBalanceLB.setText("Your new balance will be: $" + newBalance);
						newBalanceLB.setBounds(180, 270, 300, 30);
						newBalanceLB.setVisible(true);	
						} else {
					//If it's the credit account the following changes will occur.
					//If you paid of your statement this  will happen.
						if (newBalance < -1) {
							amountTB.setVisible(false);
							chooseAmount.setVisible(false);
							cancel.setBounds(200, 200, 150, 30);
							cancel.setVisible(true);
							newBalanceLB.setText("You already payed off your statement, and have overpayed. ");
							newBalanceLB.setBounds(100, 150, 400, 30);
							newBalanceLB.setVisible(true);
							accept.setVisible(false);
							acceptLB.setVisible(false);
							//If you didn't this will happen.
							} else {
								newBalance = newBalance - amount;
								newBalanceLB.setText("Your new credit balance will be: $" + newBalance);
								newBalanceLB.setBounds(150, 250, 300, 30);
								newBalanceLB.setVisible(true);
					}
				}
			}
				//Withdraw
				else if (transferType == 2) {
				//Checks if you have enough funds, and asks user to confirm the amount
				if (newBalance > amount) {
					acceptLB.setText("Are you sure you want to withdraw the following: $" + amount);
					acceptLB.setVisible(true);
					amountTB.setVisible(false);
					chooseAmount.setVisible(false);
					cancel.setVisible(true);
					//If it's withdraw and checking or savings account the following changes will occur.
					if (number < 3) {
						newBalance = newBalance - amount;
						newBalanceLB.setText("Your new balance will be: $" + newBalance);
						newBalanceLB.setBounds(180, 300, 300, 30);
						newBalanceLB.setVisible(true);	
					//If you exceed your credit limit this will happen.
			    	} else  {
						newBalance = newBalance + amount;
						if (newBalance > creditCardLimit) {
							newBalanceLB.setText("You cannot exceed credit card limit.");
							newBalanceLB.setBounds(170, 120, 300, 30);
							newBalanceLB.setVisible(true);
							accept.setVisible(false);
							cancel.setBounds(200, 180, 150, 30);
							chooseAmount.setVisible(false);
							acceptLB.setVisible(false);
						//If you didn't exceed your credit limit this will happen.
						} else {
							newBalanceLB.setText("Your new balance will be: $" + newBalance);
							newBalanceLB.setBounds(180, 300, 300, 30);
							newBalanceLB.setVisible(true);
						}
					}			
				} else {
					//Credit account the following changes will occur.
					if (number == 3)  {
						newBalance = newBalance + amount;
						newBalanceLB.setText("Your new balance will be: $" + newBalance);
						newBalanceLB.setBounds(180, 300, 300, 30);
						newBalanceLB.setVisible(true);
						cancel.setVisible(true);
						
					} else {
					//If there's no funds in checking or savings this will happen.
						amountTB.setVisible(false);
						chooseAmount.setVisible(false);
						newBalanceLB.setText("Please make sure you have enough funds");
						newBalanceLB.setBounds(150, 120, 300, 30);
						newBalanceLB.setVisible(true);
						accept.setVisible(false);
						cancel.setBounds(200, 180, 150, 30);
						cancel.setVisible(true);
					}
				}
			}	
			//Show error message	
			} else {
			accept.setVisible(false);
			errorCode.setVisible(true);						
			}				
		}
			@Override
			public void mousePressed(MouseEvent e) {
		}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {		
			}
			public void mouseExited(MouseEvent e) {				
				}	
			} 
		);	
	        //Add confirm button to panel.
			panel.add(confirm);	 
			return;
	 }	  
	 //Transfer balances between accounts button.
	 static void transferBalancesButton (int number) {
		 amount =  Integer.parseInt(amountTB.getText());
		 int a = amount;
		 //Withdraw from checking. 
		 if (checkingRadio.isSelected() & totalChecking > amount &  (amount > 0  & amount < 999)) {
			 totalChecking = totalChecking - amount;
			 queueMethod(-a);
			 totalSavings = totalSavings + amount;
			 queueMethodSavings(a);
			 panel.removeAll();
			 transferChangePage(number);
			 //withdraw from savings.
		 } else if (savingsRadio.isSelected() & totalSavings > amount &  (amount > 0  & amount < 999)) {
			 totalSavings = totalSavings - amount;
			 queueMethodSavings(-a);
			 totalChecking = totalChecking + amount;
			 queueMethod(a);
			 panel.removeAll();
			 transferChangePage(number);
		 } 
		 //Withdraw from credit if statements.
		 else if (creditRadio.isSelected()) {
			 transferAmount = totalCredit;
			 transferAmount = transferAmount + amount;
			 //Deposit into checking and withdraw from checking.
			 if (checkingRadio2.isSelected() & transferAmount < creditCardLimit &  (amount > 0  & amount < 999)) {
				 totalCredit = totalCredit + amount;
				 queueMethodCredit(a);
				 totalChecking = totalChecking + amount;
				 queueMethod(a);
				 panel.removeAll();
				 transferChangePage(number);
				//Deposit into savings and withdraw from checking.
			 } else if (savingsRadio2.isSelected() & transferAmount < creditCardLimit &  (amount > 0  & amount < 999)) {
				 totalCredit = totalCredit + amount;
				 queueMethodCredit(a);
				 totalSavings = totalSavings + amount;
				 queueMethodSavings(a);
				 panel.removeAll();
				 transferChangePage(number);
			 }  
			 // Below are the else if statements with error messages.
			 
			 //Error message if no withdraw account is selected.
			 else if (creditRadio.isSelected() & checkingRadio2.isSelected() == false & savingsRadio2.isSelected() == false) 	 {
				 panel.removeAll();
				 transferChangePage(number);
				 TransferBalanceErrorLB(3);		
			}
			 //Error message if limit is exceeded.
			 else if (transferAmount > creditCardLimit) {
				 panel.removeAll();
				 transferChangePage(number);
				 TransferBalanceErrorLB(1);
			 //Error message if amount textbox value is lower then 0 and higher than 999. 
			 } else if (creditRadio.isSelected() & (savingsRadio2.isSelected() 
						 || checkingRadio2.isSelected()) & (amount < 0  || amount > 999)) {
					 panel.removeAll();
					 transferChangePage(number);
					 TransferBalanceErrorLB(5);
			 }	 
		 }
		 //Error message if no withdraw and deposit message is selected.
		 else if (creditRadio.isSelected() == false & checkingRadio.isSelected() == false & savingsRadio.isSelected() == false)	 {
			 panel.removeAll();
			 transferChangePage(number);
			 TransferBalanceErrorLB(4);
		//Error message if amount textbox value is lower then 0 and higher than 999.
		} else if (( checkingRadio.isSelected() || savingsRadio.isSelected()) & (savingsRadio2.isSelected() 
				 || checkingRadio2.isSelected()) & (amount < 0  || amount > 999)) {
			 panel.removeAll();
			 transferChangePage(number);
			 TransferBalanceErrorLB(5);
		} else {
		//Error message if no funds.
			 panel.removeAll();
			 transferChangePage(number);
			 TransferBalanceErrorLB(2);
		 }	 
		 return;
	 }
	 //Error messages labels.
	 static void TransferBalanceErrorLB(int number)  {
		 if (number == 1) {
			 //Error message if limit is exceeded.
		 TransferBalanceErrorLB = new JLabel("You can't exceed your limit. Transaction declined");
			TransferBalanceErrorLB.setBounds(130,400,400,50);
			TransferBalanceErrorLB.setVisible(true);
			 panel.remove(TransferBalanceErrorLB);
			panel.add(TransferBalanceErrorLB);	
			SwingUtilities.updateComponentTreeUI(panel); 
		 } if (number == 2) {
			 //Error message if no funds.
			 TransferBalanceErrorLB = new JLabel("You don't have enough funds");
				TransferBalanceErrorLB.setBounds(200,400,400,50);
				TransferBalanceErrorLB.setVisible(true);
				 panel.remove(TransferBalanceErrorLB);
				panel.add(TransferBalanceErrorLB);	
				SwingUtilities.updateComponentTreeUI(panel); 
		 } if (number == 3) {
			 //Error message if no withdraw account is selected
			 TransferBalanceErrorLB = new JLabel("Please select an account to withdraw");
				TransferBalanceErrorLB.setBounds(160,400,400,50);
				TransferBalanceErrorLB.setVisible(true);
				 panel.remove(TransferBalanceErrorLB);
				panel.add(TransferBalanceErrorLB);	
				SwingUtilities.updateComponentTreeUI(panel); 
		 } if (number == 4) {
			 //Error message if no withdraw and deposit message is selected.
			 TransferBalanceErrorLB = new JLabel("Please select an account to withdraw and deposit");
				TransferBalanceErrorLB.setBounds(120,400,400,50);
				TransferBalanceErrorLB.setVisible(true);
				 panel.remove(TransferBalanceErrorLB);
				panel.add(TransferBalanceErrorLB);	
				SwingUtilities.updateComponentTreeUI(panel); 
		 } if (number == 5) { 
			 //Error message if amount textbox value is lower then 0 and higher than 999.
			 TransferBalanceErrorLB = new JLabel("Please insert amount between $1 and $999");
				TransferBalanceErrorLB.setBounds(150,400,400,50);
				TransferBalanceErrorLB.setVisible(true);
				 panel.remove(TransferBalanceErrorLB);
				panel.add(TransferBalanceErrorLB);	
				SwingUtilities.updateComponentTreeUI(panel); 
		 }
	 }	 
	 //checking queue
	 static void queueMethod (int number) {
	//320 line
		 if (q.size() < 5) {
			 q.add(number);
		 } else {
			 q.poll();
			 q.add(number);
		 }	 
	 }
	 //Queue method for savings
	 static void queueMethodSavings (int number) {
			//320 line
				 if (q1.size() < 5) {
					 q1.add(number);
				 } else {
					 q1.poll();
					 q1.add(number);
				 }	 
			 }
	 //Queue method for credit
	 static void queueMethodCredit (int number) {
			//320 line
				 if (q2.size() < 5) {
					 q2.add(number);
				 } else {
					 q2.poll();
					 q2.add(number);
				 }	 
			 }
		//Sign in page GUI elements
		static void signIn()  {	
		//UsernameTB coordinates
		usernameTB.setBounds(150,100,250,20);
		panel.add(usernameTB);
		usernameTB.setText(null);
		
		//PasswordTB coordinates
		passwordTB.setBounds(150,150,250,20);
		panel.add(passwordTB);
		passwordTB.setText(null);
			
		//UsernameLabel text and coordinates
		JLabel usernameLabel = new JLabel(); 
		usernameLabel.setBounds(80,100,250,20);
		usernameLabel.setText("Username");
		panel.add(usernameLabel);
			
		//PasswordLabel text and coordinates
		JLabel passwordLabel = new JLabel(); 
		passwordLabel.setBounds(80,150,250,20);
		passwordLabel.setText("Password");
		panel.add(passwordLabel);
				
		//titleLabel text and coordinates
		titleLabel(150,0,250,80,"Brian bank: Alpha 1.70");		
		//Login button coordinates 
		loginButton.setBounds(200, 200, 150, 30);
		panel.add(loginButton);
		SwingUtilities.updateComponentTreeUI(panel);		
}
	
	//The main menu page
	static void mainMenu()  {
		//Menu title
		titleLabel(100,0,400,70,"Please click on the following options");
		//SignOut button
		signOut(210,210,150,30);
		
		//Options the user gets to choose, Checking, savings, and credit.
		
		//Checking label text and coordinates.
		
		checkinglabel.setBounds(230,80,300,20);
		checkinglabel.setText("Checking account");
		panel.add(checkinglabel);
		checkinglabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				accountMenu(1);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				checkinglabel.setForeground(Color.blue);
			}
			public void mouseExited(MouseEvent e) {		
				checkinglabel.setForeground(Color.black);
			}	
		} 
	);		
		//Savings label in main menu
		savingslabel.setBounds(235,120,300,20);
		savingslabel.setText("Savings account");
		panel.add(savingslabel);
		savingslabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();	
				accountMenu(2);
			}
			@Override
			public void mousePressed(MouseEvent e) {		
				}
			@Override
			public void mouseReleased(MouseEvent e) {			
				}
			@Override
			public void mouseEntered(MouseEvent e) {		
				savingslabel.setForeground(Color.blue);
				}
			@Override
			public void mouseExited(MouseEvent e) {			
				savingslabel.setForeground(Color.black);
				}		
			} 	
		);	
		//credit label in main menu
		creditLabel.setBounds(240,160,300,20);
		creditLabel.setText("Credit account");
		panel.add(creditLabel);
		creditLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();	
				accountMenu(3);
			}
			@Override
			public void mousePressed(MouseEvent e) {		
				}
			@Override
			public void mouseReleased(MouseEvent e) {			
				}
			@Override
			public void mouseEntered(MouseEvent e) {		
				creditLabel.setForeground(Color.blue);
				}
			@Override
			public void mouseExited(MouseEvent e) {			
				creditLabel.setForeground(Color.black);
				}		
			} 	
		);	
		SwingUtilities.updateComponentTreeUI(panel);
		
	}
	
	//AccountMenu Main Page (Page before the transactions page
	static void accountMenu(int number)  {
		//Label position
		//Checking GUI text
		if (number == 1) {
			titleLabel(160,0,400,70,"Checking Account Menu");
			balance.setText("Balance amount:     $" + totalChecking);	
			recentTransactions(1, 1);
			//Savings page GUI text
		} else if (number == 2) {	
			titleLabel(160,0,400,70,"Savings Account Menu");
			balance.setText("Balance amount:     $"  + totalSavings);
			recentTransactions(1, 2);
			//credit page
		}  else if (number == 3) {
			titleLabel(160,0,400,70,"Checking Account Menu");
			balance.setText("Balance amount:     $"  + totalCredit);
			JLabel creditLimitLabel = new JLabel("Credit Limit:  $"  + creditCardLimit);
			creditLimitLabel.setBounds(230,50,300,20);
			creditLimitLabel.setVisible(true);
			panel.add(creditLimitLabel);
			recentTransactions(1, 3);
		} 
		//Balance label position.
		balance.setBounds(200,70,300,20);
		panel.add(balance);
		transactions.setBounds(165,110,300,20);
		transactions.setText("Recent transactions");
		transactions.setFont(new Font ("Verdana", Font.PLAIN, 24));
		panel.add(transactions);	
		//Sign out button to exit user account.
		signOut(370, 450, 150, 30);			
		//Go back button to go back to the account menu
		goBack(50, 450, 150, 30,0);	
		//Deposit button
		depositButton(number);
		//Withdraw button
		withdrawButton(number);
		//TransferButton
		transferButton(number);
		SwingUtilities.updateComponentTreeUI(panel);
	}				
	//Balance transfer page
	static void transfersPage(int number, int transferType)   {	
		//NumberFormat text box
		//Formatted text field
		numberFormat.setMinimumIntegerDigits(1);
		numberFormat.setMaximumIntegerDigits(3);
		amountTB = new JFormattedTextField(numberFormat);
		if (number == 3) {
		amountTB.setBounds(180, 245,250,30);
		} else {
		amountTB.setBounds(180, 145,250,30);
		}
		panel.add(amountTB);  
			
		//SignOut button
		signOut(370, 450, 150, 30);
		
		//Cancel button
		cancel = new JButton();
		cancel.setVisible(false);
		cancel.setText("Cancel");
		cancel.setBounds(290, 200, 150, 30);
		cancel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {		
			panel.removeAll();
			transfersPage(number,transferType);				
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {		
				
			}	
		} 
	);		
		panel.add(cancel);
		
		//GUI labels
		if (number == 1) {
			balance.setText("Balance amount:     $" + totalChecking);	
			newBalance = totalChecking;
			//Savings page
		} else if (number == 2) {
			balance.setText("Balance amount:     $"  + totalSavings);	
			newBalance = totalSavings;
			//credit page
		}  else if (number == 3) {
			balance.setText("Balance amount:     $"  + totalCredit);
			JLabel creditLimitLabel = new JLabel("Credit Limit:           $"  + creditCardLimit);
			creditLimitLabel.setBounds(200,90,300,20);
			creditLimitLabel.setVisible(true);
			panel.add(creditLimitLabel);
			
			if (transferType == 1) { 
			JLabel CheckingLabel = new JLabel("Checking balance:  $"  + totalChecking);
			panel.add(CheckingLabel);
			CheckingLabel .setBounds(200, 105, 400, 30);
			CheckingLabel .setVisible(true);
			
			JLabel SavingsLabel = new JLabel("Savings balance:    $"  + totalSavings);
			SavingsLabel.setBounds(200, 125, 400, 30);
			SavingsLabel.setVisible(true);
			panel.add(SavingsLabel);
			
			//Checking Radio button for group 1
			checkingRadio = new JRadioButton("Checking Account");
			checkingRadio.setBounds(110, 180, 150, 50);
			checkingRadio.setVisible(true);
			panel.add(checkingRadio);
			
			//Checking Radio button for group 1
			savingsRadio = new JRadioButton("Savings Account");
			savingsRadio.setBounds(310, 180, 150, 50);
			savingsRadio.setVisible(true);
			panel.add(savingsRadio);
						
			ButtonGroup group1 = new ButtonGroup();
			group1.add(checkingRadio);
			group1.add(savingsRadio); 	
			}		
			newBalance = totalCredit;
			//Transfer between accounts page
		} 
		//Error code label
		errorCode.setText("Please make sure the amount is between $1-$999");
		errorCode.setBounds(120, 240, 400, 30);
		errorCode.setVisible(false);
		panel.add(errorCode);
		
		//Accept label
		acceptLB.setText("Are you sure you want to deposit the following: " + amount);
		if (number == 3) {
			acceptLB.setBounds(120, 160, 400, 30); 
		} else {
		acceptLB.setBounds(120, 120, 400, 30); 
		}
		acceptLB.setVisible(false);
		panel.add(acceptLB);
		
		//New balance label
		newBalanceLB.setBounds(120, 120, 400, 30);
		newBalanceLB.setVisible(false);
		panel.add(newBalanceLB);	
		//ACTUAL BUTTON TO MAKE CHANGES IN BALANCE 	
		accept = new JButton();
		accept.setVisible(false);
		//GUI for deposit menu
		if (transferType == 1) {
			titleLabel(200,0,380,70,"Deposit Menu");
			accept.setText("Make Deposit");
		//GUI for withdraw menu
		} else if (transferType == 2) {
			titleLabel(200,0,400,70,"Withdraw Menu");
			accept.setText("Make Withdraw");	
		}
		    accept.setBounds(120, 200, 150, 30);
			accept.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {		
			//If it's savings
			if (number == 1) {
			//If it's Saving's deposit
			if (transferType == 1) {
				deposit(number);
			//If it's Saving's Withdraw 
			} else {
				withdrawl(number);
			}
			//If it's checking
			} else if (number == 2) {
			//If it's Checking deposit
			if (transferType == 1) {
				deposit(number);
			//If it's Checking withdraw
			} else {
				withdrawl(number);
		}
			//credit page
		}  else if (number == 3) {
			//If it's credit pay
			if (transferType == 1) {
				deposit(number);
			//if it's credit withdraw
			} else {
				withdrawl(number);
		}			
	} 		
			/*Once the button function is done reset the page, 
			so user won't spam the deposit or withdraw button. */
			panel.removeAll();
			transfersPage(number,transferType);	
		}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {		
			}
			public void mouseExited(MouseEvent e) {				
				}	
			} 
		);		
		panel.add(accept);			
		//Button that will ask to confirm the changes if pressed.
		//Confirm button
		confirmButton(number, transferType);
		//Adds and postions balance.
		balance.setBounds(200,70,300,20);
		panel.add(balance);	
		//InsertAmount label
		chooseAmount = new JLabel("Insert Amount: ");
		chooseAmount.setVisible(true);
		// If number equals to credit. Change size of label.
		if (number == 3 ) {
		chooseAmount.setBounds(70,250,300,20);
		}
		else {
			chooseAmount.setBounds(70,150,300,20);
		}
		panel.add(chooseAmount);
		//Go back button in transfers page.
		goBack(50, 450, 150, 30,number);
		SwingUtilities.updateComponentTreeUI(panel);
	}
	
	//Transfers change Page (Page were you transfer between accounts.
	static void transferChangePage (int number) {
		//GUI Labels top page
		JLabel creditAmountLabel = new JLabel("Credit amount:       $"  + totalCredit);
		creditAmountLabel.setBounds(200,90,300,20);
		creditAmountLabel.setVisible(true);
		panel.add(creditAmountLabel);
		JLabel creditLimitLabel = new JLabel("Credit Limit:           $"  + creditCardLimit);
		creditLimitLabel.setBounds(200,110,300,20);
		creditLimitLabel.setVisible(true);
		panel.add(creditLimitLabel);
		JLabel savingsBalanceLB = new JLabel("Savings amount:     $"  + totalSavings);
		savingsBalanceLB.setBounds(200,70,300,20);
		savingsBalanceLB.setVisible(true);
		panel.add(savingsBalanceLB);
		JLabel checkingBalanceLB = new JLabel("Checking amount:  $"  + totalChecking);
		checkingBalanceLB.setBounds(200,50,300,20);
		checkingBalanceLB.setVisible(true);
		panel.add(checkingBalanceLB);		
		
		//Go Back Button
		goBack(50, 450, 150, 30,number);
		
		//SignOut button
		signOut(370, 450, 150, 30);
		
		titleLabel(200,0,400,70,"Transfers Menu");
		//Insert Amount Label
		chooseAmount = new JLabel("Insert Amount: ");
		chooseAmount.setVisible(true);
		chooseAmount.setBounds(70,330,300,20);
		panel.add(chooseAmount);
		//Select account to withdraw from label
		chooseAmount = new JLabel("Select account to withdraw from: ");
		chooseAmount.setVisible(true);
		chooseAmount.setBounds(70,150,300,20);
		panel.add(chooseAmount);
		//Select account to deposit to label
		chooseAmount = new JLabel("Select account to deposit to: ");
		chooseAmount.setVisible(true);
		chooseAmount.setBounds(70,230,300,20);
		panel.add(chooseAmount);
		
		//Checking Radio button for group 1
		checkingRadio = new JRadioButton("Checking Account");
		checkingRadio.setBounds(70, 180, 150, 50);
		checkingRadio.setVisible(true);
		panel.add(checkingRadio);
		checkingRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkingRadio.isSelected()) {
					checkingRadio2.setEnabled(false);
					savingsRadio2.setEnabled(true);
					savingsRadio2.doClick();
				}
			}
		});	
		//Savings radio for group 1
		savingsRadio = new JRadioButton("Savings Account");
		savingsRadio.setBounds(230, 180, 140, 50);
		savingsRadio.setVisible(true);
		panel.add(savingsRadio);
		savingsRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (savingsRadio.isSelected()) {
					checkingRadio2.setEnabled(true);
					checkingRadio2.doClick();
					savingsRadio2.setEnabled(false);
				}
			}
		});	
		//credit Radio for group 1
		creditRadio = new JRadioButton("Credit Account");
		creditRadio.setBounds(370, 180, 140, 50);
		creditRadio.setVisible(true);
		panel.add(creditRadio);
		
		creditRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (creditRadio.isSelected()) {
					checkingRadio2.setEnabled(true);
					savingsRadio2.setEnabled(true);
				}
			}
		});
		
		//Grouping the radio button. Group 2
		ButtonGroup group1 = new ButtonGroup();
		group1.add(creditRadio);
		group1.add(savingsRadio);
		group1.add(checkingRadio);
		//Checking Radio button for group 2
		checkingRadio2 = new JRadioButton("Checking Account");
		checkingRadio2.setBounds(140, 260, 150, 50);
		checkingRadio2.setVisible(true);
		panel.add(checkingRadio2);
		//Savings radio for group 2
		savingsRadio2 = new JRadioButton("Savings Account");
		savingsRadio2.setBounds(300, 260, 140, 50);
		savingsRadio2.setVisible(true);
		panel.add(savingsRadio2);
		
		//Grouping the radio button. Group 2
		ButtonGroup group2 = new ButtonGroup();
		group2.add(savingsRadio2);
		group2.add(checkingRadio2);
		//Textbox to insert transfer amount
		numberFormat.setMinimumIntegerDigits(1);
		numberFormat.setMaximumIntegerDigits(3);
		amountTB = new JFormattedTextField(numberFormat);
		amountTB.setBounds(180, 325,250,30);
		panel.add(amountTB);  
		
		//Button
		JButton acceptTransfer = new JButton();
		acceptTransfer.setVisible(true);
		acceptTransfer.setText("Accept Transfer");
		acceptTransfer.setBounds(210, 370, 150, 30);
		acceptTransfer.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				transferBalancesButton(number);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {			
			}	
		} 
	);		
		panel.add(acceptTransfer);
		SwingUtilities.updateComponentTreeUI(panel);
	}
	//Main method
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			q.add(0);
		}	
		for (int j = 0; j < 5; j++) {
			q1.add(0);
		}
		for (int k = 0; k < 5; k++) {
			q2.add(0);
		}
		new GUI(); 		
		signIn();
	}
}