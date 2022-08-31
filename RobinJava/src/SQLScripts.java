import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class SQLScripts extends RobinGUI{
	
	static Connection c = null;
    static Statement stmt = null;
    
	//Method to check if user and password matches in the database. 
    public static void sqlLogin(String username)  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, password, name, lname FROM Robin WHERE email = '" + username + "';";
	       //Executes Query
	         ResultSet rs = stmt.executeQuery(query);
	         while ( rs.next() ) {   
	            EditProfile.employeeID= rs.getInt("id");
	       		EditProfile.employeeName = rs.getString("name");
	       		EditProfile.employeeLName = rs.getString("lname");
	       		EditProfile.employeePassword = rs.getString("password");  		
	            EditProfile.employeeUsername = username;
	         }  
	         //Clses statement and connection
	         rs.close();
	         stmt.close();
	         c.close();
	           //If email and password matches from the database it'll enter employee page.
	           if (RobinGUI.usernameTB.getText().equals(username) && RobinGUI.passwordTB.getText().equals(EditProfile.employeePassword) && !username.equals("brian")) {
	        	  panel.removeAll();
	        	   employeePage.mainMenu();
	        	   //If admin username and password matches from database it''ll enter admin page.
	           } else if (username.equals("brian") && RobinGUI.passwordTB.getText().equals(EditProfile.employeePassword)) {
	        	   panel.removeAll();
	        	   AdminPage.mainMenu();
	           }  else {
	        	   RobinGUI.getWrongCredentials();	           
	           }
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}

   //Method to get admin in the database.
   public static void sqlConnectionAdmin(String username)  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, password, name, lname FROM Robin WHERE email = '" + username + "';";
	       //Executes Query
	         ResultSet rs = stmt.executeQuery(query);
	         while ( rs.next() ) {   
	            EditProfile.employeeID= rs.getInt("id");
	       		EditProfile.employeeName = rs.getString("name");
	       		EditProfile.employeeLName = rs.getString("lname");
	       		EditProfile.employeePassword = rs.getString("password");  		
	            EditProfile.employeeUsername = username;
	         }
	         //Closes statement and connection
	         rs.close();
	         stmt.close();
	         c.close();
	           //If email and password matches from the database it'll enter employee page.
	         if (RobinGUI.searchTB.getText().equals("brian") || RobinGUI.searchTB.getText().equals("") || !RobinGUI.searchTB.getText().equals(EditProfile.employeeUsername)) {
	        	 panel.removeAll();
	        	 ProfileList.mainMenu();
	        	 getAccountNotFoundLB(515, 475, "Account not found");
	         }
	         else if (RobinGUI.searchTB.getText().equals(EditProfile.employeeUsername)) {
	        	 panel.removeAll();
	        	 EditProfile.mainMenu(2);
	        	 }  	   	     
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}

   		//Method to get account in the search bar in admin map.
   		public static void sqlConnectionGetAccount(String username)  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, name, lname FROM Robin WHERE email = '" + username + "';";
	       //Executes Query
	         ResultSet rs = stmt.executeQuery(query);
	         
	         while ( rs.next() ) {   
	            EditProfile.employeeID= rs.getInt("id");
	       		EditProfile.employeeName = rs.getString("name");
	       		EditProfile.employeeLName = rs.getString("lname");
	            EditProfile.employeeUsername = username;
	         }
	           //If email and password matches from the database it'll enter employee page.
	         	if (RobinGUI.searchTB.getText().equals("brian") || RobinGUI.searchTB.getText().equals("") || !RobinGUI.searchTB.getText().equals(EditProfile.employeeUsername)) {
	         		panel.removeAll();
	         		AdminMap.getEmployeeLB(100, 75, "Account not found");
	         		AdminMap.emailValue = null;
	         		AdminMap.mainMenu();
	         		
	         } else {
	        	    AdminMap.counter = 1;
	        	 	panel.removeAll();
	        	 	AdminMap.getEmployeeLB(100, 75, "Emailed selected: " + EditProfile.employeeUsername);
	        	 	AdminMap.getEmployeeNameLB(100, 300,"Employee name: " + EditProfile.employeeName + " " + EditProfile.employeeLName);
	        	 	AdminMap.mainMenu();
	         } 	   
	         //Closes statement and connection
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}
   		//This method executes when Assign button is clicked in Admin map page.
   		public static void GetAccountSeat() {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT seat_assigned FROM Robin WHERE email = '" + AdminMap.emailValue + "';";
	       //Executes Query
	         ResultSet rs = stmt.executeQuery(query); 
	         while ( rs.next() ) {   
	        	 AdminMap.employeeSeatEmpty =  rs.getInt("seat_assigned");
	         }
	         	if (AdminMap.employeeSeatEmpty != 0) {
	         rs.close();
	   	     stmt.close();
	   	     c.close();
	         panel.removeAll();
	         AdminMap.mainMenu();
	         AdminMap.buttonErrorLB(275, 325, "Please remove employee from assigned seat before assigning.");
	         SwingUtilities.updateComponentTreeUI(panel);	
	         }  else {
	        	 rs.close();
		         stmt.close();
		         c.close();
		         GetAccountSeat2();	
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}
   		//This method executes when Assign button is clicked in Admin map page..
   		public static void GetAccountSeat2() {
   			try {
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT employee_name FROM seatid WHERE seat_number = '" + AdminMap.seatValue + "';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   
   					AdminMap.employeeSeatEmpty2 =  rs.getString("employee_name");
   				}
   				if (AdminMap.employeeSeatEmpty2 != null) {
   					AdminMap.buttonErrorLB(350, 330, "Please make sure the seat is empty.");
   					rs.close();
   					stmt.close();
   					c.close();
   					panel.removeAll();
   					AdminMap.mainMenu();
   				} else {
   					rs.close();
   					stmt.close();
             	c.close();
             	updateEmailSeat(1,AdminMap.originalSeatID,EditProfile.employeeUsername); 
   				}
   			} catch (Exception e) {
   				e.printStackTrace();
   				System.err.println(e.getClass().getName()+": "+e.getMessage());
   				System.exit(0);
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}
//This method executes when Assign button is clicked in Admin map page.
public static void GetAccountSeat3(String seatNumber) {
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
            "postgres", "123");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         String query = "SELECT employee_name FROM seatid WHERE seat_number = '" + seatNumber + "';";
       //Executes Query
         ResultSet rs = stmt.executeQuery(query); 
         while ( rs.next() ) {   
        	 AdminMap.employeeSeatEmpty2 =  rs.getString("employee_name");
         }
         	if (AdminMap.employeeSeatEmpty2 == null) {
         AdminMap.buttonErrorLB(350, 330, "Please make sure the seat is not empty.");
         rs.close();
         stmt.close();
         c.close();
         panel.removeAll();
         AdminMap.mainMenu();
         }  else {
        	rs.close();
            stmt.close();
            c.close();
            removeEmailSeat();
         }
       
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
         SwingUtilities.updateComponentTreeUI(panel);	
      }		
	}

//Method to get all accounts in profile list.
public static void GetAllAccounts()  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT name, lname, email, seat_assigned FROM Robin;";
	         //Executes Query
	           ResultSet rs = stmt.executeQuery(query);
	           
	           @SuppressWarnings("serial")
			JTable jTable = new JTable() {
				public boolean isCellEditable (int row, int column) {
					return false;       		 
	        	 };
	           };
	           JScrollPane jScrollPane = new JScrollPane(jTable);
	           jScrollPane.setBounds(175, 100, 550, 300);
	           RobinGUI.panel.add(jScrollPane);
	         //Used for inserting rows and columns. 
	         DefaultTableModel model = (DefaultTableModel) jTable.getModel();
	         //Sets the columns names.
	         String[] tableColumn = {"FIRST NAME", "Last Name", "Email","Seat Assigned"};
	         //Sets the string as the Column header.     
	         model.setColumnIdentifiers(tableColumn);
	         //While The Query is running do the following.
	         while ( rs.next() ) {   
	        	//Sets the following variables to the string values.
	        	
	       		String employeeName = rs.getString("name");
	       		String employeeLName = rs.getString("lname");		
	            String employeeUsername = rs.getString("email");
	            String employeeID = (rs.getString("seat_assigned"));
	            
	            if (!employeeUsername.equals("brian")) {	 
	            //Creates an array with all the previous strings.
	            String[] tableData = {employeeName,employeeLName,employeeUsername,employeeID};
	            //Adds the array into a row.
	            model.addRow(tableData);
	       	 }
	    }        
	         jTable.addMouseListener((MouseListener) new MouseAdapter() {
	        	 public void mouseClicked(MouseEvent e) {
	        		 if (e.getClickCount() == 1)  {
	        		 JTable target = (JTable)e.getSource();
	        		 int row = target.getSelectedRow();			
	        		RobinGUI.searchTB.setText((String) model.getValueAt(row, 2));
	        		RobinGUI.searchBTN.doClick();	 
	        		 }
	        	 }	 
	         });
	         //Sets table to equal to model. This allows headers and rows to display.
	         //jTable = new JTable(model);
	         //Closes statement and connection
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}
	//Method to display emails in the Map list.
	public static void GetEmailsMapList()  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT email, seat_assigned FROM Robin;";
	         //Executes Query
	           ResultSet rs = stmt.executeQuery(query);	           
	           @SuppressWarnings("serial")
			JTable jTable2 = new JTable() {
				public boolean isCellEditable (int row, int column) {
					return false;       		 
	        	 };
	           };
	           JScrollPane jScrollPane = new JScrollPane(jTable2);
	           jScrollPane.setBounds(100, 100, 300, 200);
	           RobinGUI.panel.add(jScrollPane);
	         //Used for inserting rows and columns. 
	         DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
	         //Sets the columns names.
	         String[] tableColumn = {"Email","Seat Assigned"};
	         //Sets the string as the Column header.     
	         model2.setColumnIdentifiers(tableColumn);
	         //While The Query is running do the following.
	         while ( rs.next() ) {   
	        	//Sets the following variables to the string values.	
	            String employeeUsername = rs.getString("email");
	            String employeeID = (rs.getString("seat_assigned"));
	            if (!employeeUsername.equals("brian")) {	
	            //Creates an array with all the previous strings.
	            String[] tableData = {employeeUsername,employeeID};
	            //Adds the array into a row.
	            model2.addRow(tableData);
	            }
	         }   
	         jTable2.addMouseListener((MouseListener) new MouseAdapter() {
	        	 public void mouseClicked(MouseEvent e) {
	        		 if (e.getClickCount() == 1)  {
	        		 JTable target = (JTable)e.getSource();
	        		 int row = target.getSelectedRow();
	        		RobinGUI.searchTB.setText((String) model2.getValueAt(row, 0));
	        		AdminMap.emailValue = (String) model2.getValueAt(row, 0);
	        		AdminMap.employeeAssigned = (String) model2.getValueAt(row, 1);
	        		//Admin can't be changed.
	        		if (AdminMap.emailValue.equals("brian")) {
	        			AdminMap.emailValue = null;
	        			AdminMap.employeeAssigned = null;
	        		}
	        		 SwingUtilities.updateComponentTreeUI(panel);	
	        		RobinGUI.mapSearchBTN.doClick();
	        		 }
	        	 }   	 
	         });
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}
	
	//Method to display emails in the Map list.
		public static void GetEmailsMapList2()  {
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT name, lname, email, seat_assigned, requested_seat FROM Robin WHERE change_request = '1';";
		         //Executes Query
		           ResultSet rs = stmt.executeQuery(query);	           
		           @SuppressWarnings("serial")
				JTable jTable5 = new JTable() {
					public boolean isCellEditable (int row, int column) {
						return false;       		 
		        	 };
		           };
		           JScrollPane jScrollPane = new JScrollPane(jTable5);
		           jScrollPane.setBounds(100, 100, 700, 300);
		           RobinGUI.panel.add(jScrollPane);
		         //Used for inserting rows and columns. 
		         DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
		         //Sets the columns names.
		         String[] tableColumn = {"First Name", "Last Name","Email","Seat Assigned", "Requested Seat"};
		         //Sets the string as the Column header.     
		         model5.setColumnIdentifiers(tableColumn);
		         //While The Query is running do the following.
		         while ( rs.next() ) {   
		        	//Sets the following variables to the string values.
		        	 String employeeName = rs.getString("name");
		        	 String employeeLname = rs.getString("lname");
		            String employeeUsername = rs.getString("email");
		            String employeeID = (rs.getString("seat_assigned"));
		            String requestedSeat = (rs.getString("requested_seat"));
		            //Creates an array with all the previous strings.
		            String[] tableData = {employeeName,employeeLname,employeeUsername,employeeID,requestedSeat};
		            //Adds the array into a row.
		            model5.addRow(tableData);
		         }   
		         jTable5.addMouseListener((MouseListener) new MouseAdapter() {
		        	 public void mouseClicked(MouseEvent e) {
		        		 if (e.getClickCount() == 1)  {
		        		 JTable target = (JTable)e.getSource();
		        		 int row = target.getSelectedRow();
		        		RobinGUI.RequestedEmail = (String) model5.getValueAt(row, 2);
		        		AdminMap.seatNumberLB(100, 75, "User selected: " + RobinGUI.RequestedEmail);
		        		RequestPage.AdminRequestSeat = (String) model5.getValueAt(row, 4);
		        		 }
		        	 }        	 
		         });
		         rs.close();
		         stmt.close();
		         c.close();
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         SwingUtilities.updateComponentTreeUI(panel);	
		      }		
			}
	
   //Method to display seats 
   public static void GetSeatList()  {
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
            "postgres", "123");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         String query = "SELECT seat_number, seat_assigned, employee_name FROM seatid;";
         //Executes Query
           ResultSet rs = stmt.executeQuery(query);
           
           @SuppressWarnings("serial")
		JTable jTable3 = new JTable() {
			public boolean isCellEditable (int row, int column) {
				return false;       		 
        	 };
           };
           JScrollPane jScrollPane = new JScrollPane(jTable3);
           jScrollPane.setBounds(500, 100, 300, 200);
           RobinGUI.panel.add(jScrollPane);
         //Used for inserting rows and columns. 
         DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
         //Sets the columns names.
         String[] tableColumn = {"Seat Number","Assigned", "Employee name"};
         //Sets the string as the Column header.     
         model3.setColumnIdentifiers(tableColumn);
         //While The Query is running do the following.
         while ( rs.next() ) {   
        	//Sets the following variables to the string values.	
        	AdminMap.seatNumber = rs.getString("seat_number");
            AdminMap.seatAssigned = rs.getString("seat_assigned");
            AdminMap.SeatEmployee = rs.getString("employee_name");
            //Creates an array with all the previous strings.
            String[] tableData = {AdminMap.seatNumber,AdminMap.seatAssigned,AdminMap.SeatEmployee};
            //Adds the array into a row.
            model3.addRow(tableData);
         }
         
         jTable3.addMouseListener((MouseListener) new MouseAdapter() {
        	 public void mouseClicked(MouseEvent e) {
        		 if (e.getClickCount() == 1)  {
        		 JTable target2 = (JTable)e.getSource();
        		 int row = target2.getSelectedRow();
        	     AdminMap.seatNumberLB.setText("Seat number selected: " + (String) model3.getValueAt(row, 0));
        	     AdminMap.originalSeatID = (String) model3.getValueAt(row, 0);
        	     AdminMap.seatValue = (String) model3.getValueAt(row, 2);
        	     SwingUtilities.updateComponentTreeUI(panel);	
        		 }
        	 }  	 
         });
         rs.close();
         stmt.close();
         c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         SwingUtilities.updateComponentTreeUI(panel);	
      }		
	}
   
 //Method to display seats for the employee page
   public static void GetSeatList2()  {
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
            "postgres", "123");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         String query = "SELECT seat_number, seat_assigned, employee_name FROM seatid;";
         //Executes Query
           ResultSet rs = stmt.executeQuery(query);
           
           @SuppressWarnings("serial")
		JTable jTable4 = new JTable() {
			public boolean isCellEditable (int row, int column) {
				return false;       		 
        	 };
           };
           JScrollPane jScrollPane = new JScrollPane(jTable4);
           jScrollPane.setBounds(200, 100, 500, 300);
           RobinGUI.panel.add(jScrollPane);
         //Used for inserting rows and columns. 
         DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
         //Sets the columns names.
         String[] tableColumn = {"Seat Number","Assigned", "Employee name"};
         //Sets the string as the Column header.     
         model4.setColumnIdentifiers(tableColumn);
         //While The Query is running do the following.
         while ( rs.next() ) {   
        	//Sets the following variables to the string values.	
        	AdminMap.seatNumber = rs.getString("seat_number");
            AdminMap.seatAssigned = rs.getString("seat_assigned");
            AdminMap.SeatEmployee = rs.getString("employee_name");
            //Creates an array with all the previous strings.
            String[] tableData = {AdminMap.seatNumber,AdminMap.seatAssigned,AdminMap.SeatEmployee};
            //Adds the array into a row.
            model4.addRow(tableData);
         }
         jTable4.addMouseListener((MouseListener) new MouseAdapter() {
        	 public void mouseClicked(MouseEvent e) {
        		 if (e.getClickCount() == 1)  {
        		 JTable target4 = (JTable)e.getSource();
        		 int row = target4.getSelectedRow();
        	     AdminMap.seatNumberLB.setText("Seat number selected: " + (String) model4.getValueAt(row, 0));
        	     EmployeeMap.employeeSeatNumber =  (String) model4.getValueAt(row, 0);
        	     SwingUtilities.updateComponentTreeUI(panel);	
        		 }
        	 }  	 
         });
         rs.close();
         stmt.close();
         c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         SwingUtilities.updateComponentTreeUI(panel);	
      }		
	}
   		//Method to edit account details. 
   		public static void updateName(int id, String name, String lname, String password) {
   			try {
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				stmt = c.createStatement();
       
   				String query = "UPDATE ROBIN SET name = '" + name +  "',lname = '" + lname +  "',password = '" + password +  "' WHERE id = " + id;
   				//Executes Query
   				stmt.executeUpdate(query);
   				c.close();
   				stmt.close();
   				getAccountNotFoundLB(400, 320, "Account details updated.");
   			} catch (Exception e) {
   				e.printStackTrace();
   				System.err.println(e.getClass().getName()+": "+e.getMessage());
   				System.exit(0);
   			}
   			SwingUtilities.updateComponentTreeUI(panel);	
   		}
	
   		//Method to insert new data to the POSTGRES database. 
   		public static void insertAccount(int id, String name, String lname, String email, String password) {	
   			try {
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
    				.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
    						"postgres", "123");
   				stmt = c.createStatement();
       
   				String query = "INSERT INTO ROBIN (email, name, lname, password,seat_assigned,change_request)" 
    				+   " VALUES ('" + email + "','" + name +  "','" + lname +  "', '" + password + "'," +  null + "," +'2' + ")";
   				//Executes Query
   				stmt.executeUpdate(query);
   				c.close();
   				stmt.close();
   				panel.removeAll();
   				getInsertLB(430,325,"Insert complete");
   				CreateEditProfile.mainMenu();
   			} catch (Exception e) {
   				e.printStackTrace();
   				System.err.println(e.getClass().getName()+": "+e.getMessage());
   				panel.removeAll();
   				getAccountNotFoundLB(380, 325, "Email address already exist");
   				CreateEditProfile.mainMenu();
   			}
   			SwingUtilities.updateComponentTreeUI(panel);	
   		}
   		
	//Method to edit email mapid
	public static void updateEmailSeat(int a, String SeatID, String email ) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
							"postgres", "123");
			stmt = c.createStatement();
   
			String query = "UPDATE ROBIN SET seat_assigned = '" + SeatID + "' WHERE email = '" + email + "'";
			//Executes Query
			stmt.executeUpdate(query);  
			c.close(); 
			stmt.close();
			if (a == 1) {
			updateSeatEmail(1,EditProfile.employeeUsername, AdminMap.originalSeatID);
			} else {
				updateSeatEmail(2,RobinGUI.RequestedEmail,RequestPage.AdminRequestSeat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		SwingUtilities.updateComponentTreeUI(panel);	
	}

	//Method to edit email mapid
	public static void  updateSeatEmail(int a, String email, String SeatID) {
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
							"postgres", "123");
			stmt = c.createStatement();
 
			String query = "UPDATE seatid SET employee_name = '" + email + "' WHERE seat_number = '" + SeatID + "'";
			//Executes Query
			stmt.executeUpdate(query);
			c.close(); 
			stmt.close();
			if ( a ==1) {
			panel.removeAll();
			AdminMap.mainMenu();
			AdminMap.buttonErrorLB(400, 350, "Account updated!");
			} else {
				AdminMap.buttonErrorLB(400, 350, "Account updated!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}

	//Method to remove email seat assigned
	public static void removeEmailSeat() {
	
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
							"postgres", "123");
			stmt = c.createStatement();
 
			String query = "UPDATE robin SET seat_assigned = NULL WHERE email = '" + AdminMap.employeeSeatEmpty2 + "';";
			//Executes Query
			stmt.executeUpdate(query);  
			c.close(); 
			stmt.close();
			removeSeatEmail(1, AdminMap.originalSeatID);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}		
	}
	
	//Method to remove email seat assigned in Request Page
		public static void removeEmailSeat2() {
		
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
	 
				String query = "UPDATE robin SET seat_assigned = NULL WHERE seat_assigned = '" + RequestPage.AdminRequestSeat + "';";
				//Executes Query
				stmt.executeUpdate(query);  
				c.close(); 
				stmt.close();
				removeSeatEmail(2, RequestPage.AdminRequestSeat);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}		
		}

	//Method to remove Requested seat and change request.
		public static void removeRequestedSeat(String email) {
		
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
	 
				String query = "UPDATE robin SET requested_seat = NULL, change_request = 2 WHERE email = '" + email + "';";
				//Executes Query
				stmt.executeUpdate(query);  
				c.close(); 
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}	
		}
			
		//Method to add a Requested seat and change request.
				public static void addRequestedSeat(String email, String requestedSeat) {
				
					try {
						Class.forName("org.postgresql.Driver");
						c = DriverManager
								.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
										"postgres", "123");
						stmt = c.createStatement();
			 
						String query = "UPDATE robin SET requested_seat = '" + requestedSeat + "', change_request = 1 WHERE email = '" + email + "';";
						//Executes Query
						stmt.executeUpdate(query);  
						c.close(); 
						stmt.close();
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println(e.getClass().getName()+": "+e.getMessage());
						System.exit(0);
					}	
				}
		
		
	//Method to edit email seat_assigned
	public static void  removeSeatEmail(int a,String seatNumber){
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
							"postgres", "123");
			stmt = c.createStatement();

			String query = "UPDATE seatid SET employee_name = NULL WHERE seat_number = '" + seatNumber+ "';";
			//Executes Query
			stmt.executeUpdate(query);
			c.close(); 
			stmt.close();
			if (a == 1) {
			panel.removeAll();
			AdminMap.mainMenu();
			AdminMap.buttonErrorLB(400, 350, "Account updated!");
			}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
			}
		}
	
	//Method to edit email seat_assigned
		public static void  removeSeatEmail2(String email){
	
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();

				String query = "UPDATE seatid SET employee_name = NULL WHERE employee_name = '" + RobinGUI.RequestedEmail + "';";
				//Executes Query
				stmt.executeUpdate(query);
				c.close(); 
				stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}
			}
	
	//Method to get admin in the database.
	public static void getRequestDetail()  {
	
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT change_request,requested_seat FROM Robin WHERE email = '" + EditProfile.employeeUsername + "';";
		       //Executes Query
		         ResultSet rs = stmt.executeQuery(query);
		         while ( rs.next() ) {   
		            EditProfile.changeRequestDetail = rs.getString("change_request");	
		            EmployeeMap.empRequestSeat = rs.getString("requested_seat");
		         }
		         //Closes statement and connection
		         rs.close();
		         stmt.close();
		         c.close();   	     
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		         SwingUtilities.updateComponentTreeUI(panel);	
		      }		
			}
	
	//Method to count rows in admin page.
	public static void countRows()  {
		
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT COUNT (change_request) FROM robin WHERE change_request = '1';";
		       //Executes Query
		         ResultSet rs = stmt.executeQuery(query);
		         while ( rs.next() ) {   
		        	AdminMap.numberOfRequests = rs.getInt("COUNT");
		         }  
		         rs.close();
		         stmt.close();
		         c.close();
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		         SwingUtilities.updateComponentTreeUI(panel);	
		      }		
			}
	}
