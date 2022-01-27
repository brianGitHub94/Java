package atmMachine;

import java.util.Scanner;

public class mainClass {
	
	public static int totalSavings = 500;
	public static int totalChecking = 1000;
	public static int totalCredit = -2000;
	public static int totalCreditLimit = -4500;
	
	
	/*public static void homeScreen()  {
		//Initial message that user will see. 
		System.out.println("   Please choose from the following:"
				+ "\n\n       Savings press \" 1 \" \n"
				+  "\n       Checking press \" 2 \" \n"
				+ "\n       Credit press \" 3 \"");	
		
	}*/
	
	    public static void accountMenu(int number) {
	    	//Savings Menu
	       Scanner myObj2 = new Scanner (System.in);
	       if (number == 1) {
		    //Displays account message.
		    System.out.println("Savings menu: \nChoose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
	    	//User selected choice.
	       String username2 = myObj2.nextLine();   
	       accountSelection(username2, 1);	
	    }  else if (number == 2) {
	    	//Checking Menu
	    	//Displays account message.
	    	System.out.println("Checking menu:\nChoose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
	    	//User selected choice.
	        String username2 = myObj2.nextLine();	
	       
	        accountSelection(username2, 2);	   	
	    }  else if (number == 3) {
	    	//Credit Menu
	    	//Displays account message.
	    	System.out.println("Credit menu:\nChoose from the following \n1 to check balance \n2 to withdraw from credit \n3 to pay credit amount \n4 to main menu ");
	    	//User selected choice.
	    	String username2 = myObj2.nextLine();	  
	    	
	    	accountSelection(username2, 3);	
	    }  	
	       
	    }

public static void withdraw(int amount) {
	//withdraw method
	Scanner word = new Scanner (System.in);
	Scanner word2 = new Scanner (System.in);
	if (amount == 1) {
		//Withdraw from Savings
		System.out.println("Please select the amount you want to withdraw from savings.\n"
				+ "Press any non-number key to cancel.");
		
		try {int username = word.nextInt();
		
		if (username > 0 && username < totalSavings) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalSavings = totalSavings - username;
			System.out.println("press any button to go to the acccount main menu.");
			word2.nextLine();
			
			accountMenu(1); 
			
		} else if (username < 0) {
			System.out.println("Amount can't be a negative value. \nPress any key to try again. \n");
			word2.nextLine();
			
			withdraw(1);
			
		} else {
			System.out.println("Insufficient funds, Press any key to try again.");
			word2.nextLine();
			
			withdraw(1);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("User iniciated cancel sequance. \nPress any key to go back to account main menu");
			word2.nextLine();
			
			accountMenu(1);
		}
		
	} if (amount == 2) {
	//Withdraw from Checking	
		System.out.println("Please select the amount you want to withdraw from checking \n"
				+ "Press any non-number key to cancel.");
		try { int username = word.nextInt();
	
		if (username > 0 && username < totalChecking) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalChecking = totalChecking - username;
			System.out.println("press any button to go to the acccount main menu.");
			word2.nextLine();
			
			accountMenu(2); 
			
		} else if (username < 0) {
			System.out.println("Amount can't be a negative value. \nPress any key to try again. \n");
			word2.nextLine();
			
			withdraw(2);
			
		} else {
			System.out.println("Insufficient funds, Press any key to try again. \n");
			word2.nextLine();
			
			withdraw(2);
		} } catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("User iniciated cancel sequance. \nPress any key to go back to account main menu");
			word2.nextLine();
			
			accountMenu(2);
		}
	} if (amount == 3) {
	//Withdraw from credit	
		System.out.println("Please select the amount you want to withdraw from credit.\nPress any non-number key to cancel.");
		try { int username = word.nextInt();
		
		if (username > 0) {
			int limit = totalCreditLimit;
			if (totalCredit - username >= limit) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalCredit = totalCredit - username;
			System.out.println("press any button to go to the acccount main menu.");
			word2.nextLine();
		
			accountMenu(3); 
			}	
		} else {
			System.out.println("Number can't be a negative value. Please try again.");
			word2.nextLine();
			
			withdraw(3);
	}
		System.out.println("Credit limit reached, Please try again later.");
		word2.nextLine();
		
		accountMenu(3);
		} catch(Exception e) { 
			// Catches error if user uses a string or char and not an int.
			System.out.println("Cancel sequance initiated.\nPress any key to go back.");
			word2.nextLine();
			
			accountMenu(3);
		}
	}
}
//word close done.
public static void deposit(int amount) {
		//deposit method
	Scanner word = new Scanner (System.in);
	Scanner word2 = new Scanner (System.in);
	Scanner word3 = new Scanner (System.in);
	if (amount == 1) {
		//Deposit into Savings
		System.out.println("Please select the amount you want to deposit into savings. \nPress any non-number key to cancel. ");
		//If user put more then 0 and equal to or less then 2000, then the amount will be deposit into the account.
		try {int username = word.nextInt();
		if (username > 0 && username <= 2000) {
			System.out.println("$" + username + " has been deposited into your account");
			totalSavings = totalSavings + username;
			System.out.println("press any button to go to the acccount main menu.");
			word2.nextLine();
			
			accountMenu(1); 
			//If user selects more then 2000 a message will appear.
		} else if (username < 0) {
			System.out.println("Number can't be a negative value.\n"
					+ "Press any key to try again.");
			word2.nextLine();
			
			deposit(1);
		}
		
		else {
			System.out.println("Deposit limit reached. You can't deposit more then $2000 in a single trasaction."
					+ " Please try again later. Press any key to go back to Saving's menu.");
			word2.nextLine();
			
			accountMenu(1);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Cancel sequance initiated.\nPress any key to go back.");
			word2.nextLine();
		
			accountMenu(1);
		}
	}
	
	if (amount == 2) {
		//Deposit into Checking
		System.out.println("Please select the amount you want to deposit into Checking.\nPress any non-number key to cancel. ");
		//If user put more then 0 and equal to or less then 2000, then the amount will be deposit into the account.
		try {int username = word.nextInt();
		
		if (username > 0 && username <= 2000) {
			System.out.println("$" + username + " has been deposited into your account");
			totalChecking = totalChecking + username;
			System.out.println("press any button to go to the acccount main menu.");
			word2.nextLine();
			
			accountMenu(2); 
			
		} else if (username < 0) {
			System.out.println("Number can't be a negative value.\n"
					+ "Press any key to try again.");
			word2.nextLine();
		
			deposit(2);
		}
		
		else {
			//If user selects more then 2000 a message will appear.
			System.out.println("Deposit limit reached. You can't deposit more then $2000 in a single trasaction."
					+ " Please try again later. Press any key to go back to Checking's menu.");
			word2.nextLine();
		
			accountMenu(2);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Cancel sequance initiated.\nPress any key to go back.");
			word2.nextLine();
		
			accountMenu(2);
		}
	}
	if (amount == 3) {
		//Deposit into credit
		System.out.println("Please select an account to pay off your credit statement. Current credit statement :" + totalCredit);
		System.out.println("Press 1 to use Savings \nPress 2 for Checking \nPress any key to cancel and go back.");
		
		 
		try { int username3 = word3.nextInt();
		
		if (username3 == 1) {
			System.out.println("Savings account selected. \nPlease select an amount from savings. \nAmount in savings:" + totalSavings
					+ "\n Press any letter key to cancel.");
			int username = word.nextInt();
			
			if (username > 0 && username <= totalSavings) {
				System.out.println("Payment completed" + "$" + username + "Has been used to pay off your credit statement.");
				totalCredit = totalCredit + username;
				totalSavings = totalSavings - username;
				System.out.println("press any button to go to the acccount main menu.");
				word2.nextLine();
			
				accountMenu(3); 
			}  else if (username < 0) {
				System.out.println("Number can't be a negative number.\n"
						+ "Press any key to try again.");
				word2.nextLine();
				
				deposit(3);
			}
			
			else {
				System.out.println("Amount selected exceedes the amount in the account. Please add more funds and try again \n"
						+ "Press any key to go back to account menu");
				word2.nextLine();
				
				accountMenu(3);
			}		
		} else if (username3 == 2){
			System.out.println("Checking account selected. \nPlease select an amount from Checking. \nAmount in Checking:" + totalChecking);
			int username = word.nextInt();
		
			if (username > 0 && username <= totalChecking) {
				System.out.println("Payment completed" + "$" + username + "Has been used to pay off your credit statement.");
				totalCredit = totalCredit + username;
				totalChecking = totalChecking - username;
				System.out.println("press any button to go to the acccount main menu.");
				word2.nextLine();
			
				accountMenu(3); 
			}  else if (username < 0) {
				System.out.println("Number can't be a negative number.\n"
						+ "Press any key to try again.");
				word2.nextLine();
			
				deposit(3);
			}
			
			else {
				System.out.println("Amount selected exceedes the amount in the account. Please add more funds and try again \n"
						+ "Press any key to go back to account menu");
				word2.nextLine();
				
				accountMenu(3);
			}		
			
			
		} else {
			System.out.println("Please choose between option 1 or 2, or press any non-number key to cancel."
					+ " \nPress any key to try again.");
			word2.nextLine();
			
			deposit(3);
			
		}
				
		
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("User has cancelled. User will go back to account main menu \nPress any key to continue.");
			word2.nextLine();
			
			accountMenu(3);
		}
	}
	
}
    //Method that displays balance.
    public static void balance(int amount) {
	Scanner myObj2 = new Scanner (System.in);
	if (amount == 1) {
		//Displays Savings Amount
		System.out.println("Amount in Savings $" + totalSavings);
		System.out.println("Press any key to go back.");
		myObj2.nextLine();
		accountMenu(1);
	} else if (amount ==2) {
		//Displays Checking Amount
		System.out.println("Amount in Checking $" + totalChecking);
		System.out.println("Press any key to go back.");
		myObj2.nextLine();
		accountMenu(2);
	}
	else if ( amount == 3) {
		//Displays Credit Amount
		System.out.println("Amount owed in Credit $" + totalCredit);
		System.out.println("Press any key to go back.");
		myObj2.nextLine();
		accountMenu(3);
	}	
}

public static void accountSelection(String balance, int number) {
	//Method that allows user to choose between options AFTER selecting their account in selection method. Ex: Check balance, withdraw.
		Scanner myObj2 = new Scanner (System.in);

	if (balance.equals("1")) {
		// If user selects 1, the check balance method will be executed.
		System.out.println("User selected \"Check balance\" ");
		
		if (number == 1) {
			balance(number);
		}
		else if (number == 2) {
			balance(number);
		}
		else if (number == 3) {
			balance(number);
		}
		
		} else if (balance.equals("2")) {
			System.out.println("User selected \"Withdraw\" ");	
			// If user selects 2, the check withdraw method will be executed.
			if (number == 1) {
				withdraw(number);
			}
			else if (number == 2) {
				withdraw(number);
			}
			else if (number == 3) {
				withdraw(number);
			}
			
	    } else if (balance.equals("3")) {
	    	// If user selects 1, the check balance method will be executed.
			if (number == 1) {
				System.out.println("User selected \"deposit\" ");			
				deposit(number);
			}
			else if (number == 2) {
				System.out.println("User selected \"deposit\" ");
				deposit(number);
			}
			else if (number == 3) {
				System.out.println("User selected \"to pay credit amount\" ");
				deposit(number);
			}
				
			
	} else {
	  System.out.println("User selected to go back to main menu. \n      Press any key to continue.");
	  myObj2.nextLine();
		homeScreen();
		//selection();
				
	}
	
	 
}

public static void homeScreen() {
	//Initial message that user will see. 
	System.out.println("   Please choose from the following:"
	+ "\n\n       Savings press \" 1 \" \n"
	+  "\n       Checking press \" 2 \" \n"
	+ "\n       Credit press \" 3 \"");	
	//First menu user see that allows user to select between accounts. Ex: Savings, checking
	Scanner myObj = new Scanner (System.in);
	Scanner myObj2 = new Scanner (System.in);
	String username = myObj.nextLine();
	
	//If user select 1 the account menu method will be executed using savings if statement
	if (username.equals("1")) {
		System.out.println("User selected Savings \n");
		accountMenu(1);
		//If user select 1 the account menu method will be executed in savings
	} else if ( username.equals("2")) {
			System.out.println("User selected Checking \n");	
			accountMenu(2);
			//If user select 2 the account menu method will be executed in checking
	}	else if ( username.equals("3")) {
			System.out.println("User selected Credit \n");
			accountMenu(3);
			//If user select 3 the account menu method will be executed in credit
	} else {
	  System.out.println("Wrong input was selected. \nPress any key to try again. \n");
	  myObj2.nextLine();
	
		homeScreen();  
		//selection();
	}
	 
}
	
	public static void main(String[] args) {
		//HomeScreen method. Displays message and selection.
	    homeScreen();
	    //selection();
		
	}

}
