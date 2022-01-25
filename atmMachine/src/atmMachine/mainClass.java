package atmMachine;

import java.util.Scanner;

public class mainClass {
	
	public static int totalSavings = 500;
	public static int totalChecking = 1000;
	public static int totalCredit = 2000;
	
	
	public static void homeScreen()  {
		//Initial message that user will see. 
		System.out.println("Welcome \nPlease choose from the following:"
				+ "\nSavings press... \" 1 \" \n"
				+  "\nCheckings press... \" 2 \" \n"
				+ "\nCredit press... \" 3 \" \n \n:");			
	}
	
	
	public static void accountMessage()  {
		
		System.out.println("Choose from the following \n1 to check balance"
		  		+ "\n2 to withdraw \n3 to deposit \n4 to main menu ");
	
	}
	
	public static void savings() {
		Scanner myObj2 = new Scanner (System.in);
		//Displays account message.
		accountMessage();
		//User selected choice.
	    String username2 = myObj2.nextLine();    
	    accountSelection(username2, 1);	
	}
	
public static void checking() {
	Scanner myObj2 = new Scanner (System.in);
	//Displays account message.
	accountMessage();
	//User selected choice.
    String username2 = myObj2.nextLine();	    
    accountSelection(username2, 2);	  
	}

public static void credit() {
	Scanner myObj2 = new Scanner (System.in);
	//Displays account message.
	accountMessage();
	//User selected choice.
	String username2 = myObj2.nextLine();	    
	accountSelection(username2, 3);	  
}


public static int withdraw(int amount) {
	//do withdraaw method
	
	
	return amount;
}

public static int deposit(int amount) {
	
	//do deposit method.
	
	return amount;
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
		accountMessage();
		String username2 = myObj2.nextLine();
		accountSelection(username2, 1);	 
	} else if (amount ==2) {
		//Checking Amount
		System.out.println("Amount in Checking $" + totalChecking);
		goBackMessage();
		accountMessage();
		String username2 = myObj2.nextLine();
		accountSelection(username2, 2);	 
	}
	else if ( amount == 3) {
		//Credit Amount
		System.out.println("Amount in Credit $" + totalCredit);
		goBackMessage();
		accountMessage();
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
			checking();
			
	}	else if (balance.equals("3")) {
			System.out.println("User selected \"deposit\" ");
			credit();
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
		savings();
	} else if ( username.equals("2")) {
			System.out.println("User selected Checking \n");	
			checking();
			
	}	else if ( username.equals("3")) {
			System.out.println("User selected Credit \n");
			credit();
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
