package atmMachine;

import java.util.Scanner;

public class mainClass {
	
	public static int totalSavings = 500;
	public static int totalChecking = 1000;
	public static int totalCredit = -2000;
	public static int totalCreditLimit = -4500;
	
	
	public static void homeScreen()  {
		//Initial message that user will see. 
		System.out.println("Welcome \nPlease choose from the following:"
				+ "\nSavings press... \" 1 \" \n"
				+  "\nCheckings press... \" 2 \" \n"
				+ "\nCredit press... \" 3 \" \n \n:");			
	}
	
	    public static void accountMenu(int number) {
	    	//Savings Menu
	       if (number == 1) {
		    Scanner myObj2 = new Scanner (System.in);
		    //Displays account message.
		    System.out.println("Choose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
	    	//User selected choice.
	       String username2 = myObj2.nextLine();    
	       accountSelection(username2, 1);	
	    }  else if (number == 2) {
	    	//Checking Menu
	    	Scanner myObj2 = new Scanner (System.in);
	    	//Displays account message.
	    	System.out.println("Choose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
	    	//User selected choice.
	        String username2 = myObj2.nextLine();	    
	        accountSelection(username2, 2);	   	
	    }  else if (number == 3) {
	    	//Credit Menu
	    	Scanner myObj2 = new Scanner (System.in);
	    	//Displays account message.
	    	System.out.println("Choose from the following \n1 to check balance \n2 to withdraw from credit \n3 to pay credit amount \n4 to main menu ");
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
		System.out.println("Please select the amount you want to withdraw from savings");
		
		try {int username = word.nextInt();
		if (username > 0 && username < totalSavings) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalSavings = totalSavings - username;
			System.out.println("press any button to go to the acccount main menu.");
			String username2 = word2.nextLine();
			accountMenu(1); 
			
		} else {
			System.out.println("Insufficient funds, Please try again later. Press any key to go back to Savings menu.");
			String username2 = word2.nextLine();
			accountMenu(1);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Please use only numbers. \n Press any key to go back to account main menu");
			String username2 = word2.nextLine();
			accountMenu(1);
		}
		
	} if (amount == 2) {
	//Withdraw from Checking	
		System.out.println("Please select the amount you want to withdraw from checking");
		try { int username = word.nextInt();
		if (username > 0 && username < totalChecking) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalChecking = totalChecking - username;
			System.out.println("press any button to go to the acccount main menu.");
			String username2 = word2.nextLine();
			accountMenu(2); 
			
		} else {
			System.out.println("Insufficient funds, Please try again later. Press any key to go back to account menu.");
			String username2 = word2.nextLine();
			accountMenu(2);
		} } catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Please only use numbers. \nPress any key to go back to account main menu");
			String username2 = word2.nextLine();
			accountMenu(2);
		}
	} if (amount == 3) {
	//Withdraw from credit	
		System.out.println("Please select the amount you want to withdraw from credit");
		try { int username = word.nextInt();
		if (username > 0) {
			int limit = totalCreditLimit;
			if (totalCredit - username >= limit) {
			System.out.println("$" + username + " has been withdrawn from your account");
			totalCredit = totalCredit - username;
			System.out.println("press any button to go to the acccount main menu.");
			String username2 = word2.nextLine();
			accountMenu(3); 
			}	
		} else {
			System.out.println("Insufficient funds, Please try again later. "
					+ "Press any key to go back to account menu.");
			
			String username2 = word2.nextLine();
			accountMenu(3);
	}
		System.out.println("Credit limit reached, Please try again later. "
				+ "Press any key to go back to Checking menu.");
		String username2 = word2.nextLine();
		accountMenu(3);
		} catch(Exception e) { 
			// Catches error if user uses a string or char and not an int.
			System.out.println("Please only use numbers. \nPress any key to go back to account menu.");
			String username2 = word2.nextLine();
			accountMenu(3);
		}
	}
	
}

public static void deposit(int amount) {
		//deposit method
	Scanner word = new Scanner (System.in);
	Scanner word2 = new Scanner (System.in);
	Scanner word3 = new Scanner (System.in);
	Scanner word4 = new Scanner (System.in);
	if (amount == 1) {
		//Deposit into Savings
		System.out.println("Please select the amount you want to deposit into savings");
		
		try {int username = word.nextInt();
		if (username > 0 && username <= 2000) {
			System.out.println("$" + username + " has been deposited into your account");
			totalSavings = totalSavings + username;
			System.out.println("press any button to go to the acccount main menu.");
			String username2 = word2.nextLine();
			accountMenu(1); 
			
		} else {
			System.out.println("Deposit limit reached. You can't deposit more then $2000 in a single trasaction."
					+ " Please try again later. Press any key to go back to Saving's menu.");
			String username2 = word2.nextLine();
			accountMenu(1);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Please use only numbers. \n Press any key to go back to account main menu");
			String username2 = word2.nextLine();
			accountMenu(1);
		}
	}
	
	if (amount == 2) {
		//Deposit into Checking
		System.out.println("Please select the amount you want to deposit into Checking");
		
		try {int username = word.nextInt();
		if (username > 0 && username <= 2000) {
			System.out.println("$" + username + " has been deposited into your account");
			totalChecking = totalChecking + username;
			System.out.println("press any button to go to the acccount main menu.");
			String username2 = word2.nextLine();
			accountMenu(2); 
			
		} else {
			System.out.println("Deposit limit reached. You can't deposit more then $2000 in a single trasaction."
					+ " Please try again later. Press any key to go back to Checking's menu.");
			String username2 = word2.nextLine();
			accountMenu(2);
		}
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("Please use only numbers. \n Press any key to go back to account main menu");
			String username2 = word2.nextLine();
			accountMenu(2);
		}
	}
	if (amount == 3) {
		//Deposit into credit
		System.out.println("Please select an account to pay off your credit statement. Current credit statment :" + totalCredit);
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
				String username2 = word2.nextLine();
				accountMenu(3); 
			}  else {
				System.out.println("Amount selected exceedes the amount in the account. Please add more funds and try again \n"
						+ "Press any key to go back to account menu");
				String username2 = word2.nextLine();
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
				String username2 = word2.nextLine();
				accountMenu(3); 
			}  else {
				System.out.println("Amount selected exceedes the amount in the account. Please add more funds and try again \n"
						+ "Press any key to go back to account menu");
				String username2 = word2.nextLine();
				accountMenu(3);
			}		
			
			
		} else {
			System.out.println("User has cancelled. Going back to account main menu \n Press any key to continue.");
			String username2 = word2.nextLine();
			accountMenu(3);
			
		}
				
		
		} catch (Exception e) {
			// Catches error if user uses a string or char and not an int.
			System.out.println("User has cancelled. User will go back to account main menu \n Press any key to continue.");
			String username2 = word2.nextLine();
			accountMenu(3);
		}
	}
	
}
	
public static void goBackMessage() {
	Scanner myObj2 = new Scanner (System.in);
	System.out.println("Press any key to go back");
	String username = myObj2.nextLine();
}


public static void balance(int amount) {
	Scanner myObj2 = new Scanner (System.in);
	if (amount == 1) {
		//Savings Amount
		System.out.println("Amount in Savings $" + totalSavings);
		goBackMessage();
		System.out.println("Choose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
		String username2 = myObj2.nextLine();
		accountSelection(username2, 1);	 
	} else if (amount ==2) {
		//Checking Amount
		System.out.println("Amount in Checking $" + totalChecking);
		goBackMessage();
		System.out.println("Choose from the following \n1 to check balance \n2 to withdraw \n3 to deposit \n4 to main menu ");
		String username2 = myObj2.nextLine();
		accountSelection(username2, 2);	 
	}
	else if ( amount == 3) {
		//Credit Amount
		System.out.println("Amount owed in Credit $" + totalCredit);
		goBackMessage();
		System.out.println("Choose from the following \n1 to check balance \n2 to withdraw \n3 to pay credit amount \n4 to main menu ");
		String username2 = myObj2.nextLine();
		accountSelection(username2, 3);	 
	}	
}

public static void accountSelection(String balance, int number) {
		Scanner myObj2 = new Scanner (System.in);

	if (balance.equals("1")) {
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
	  String username2 = myObj2.nextLine();
		homeScreen();
		selection();
				
	}
}


public static void selection() {
	Scanner myObj = new Scanner (System.in);
	Scanner myObj2 = new Scanner (System.in);
	String username = myObj.nextLine();
	if (username.equals("1")) {
		System.out.println("User selected Savings \n");
		accountMenu(1);
	} else if ( username.equals("2")) {
			System.out.println("User selected Checking \n");	
			accountMenu(2);
			
	}	else if ( username.equals("3")) {
			System.out.println("User selected Credit \n");
			accountMenu(3);
	} else {
	  System.out.println("Wrong input was selected. \nPress any key to try again. \n");
	  String username2 = myObj2.nextLine();
		homeScreen();
		selection();
	}

}
	
	public static void main(String[] args) {
		homeScreen();
		selection(); 
	}

}
