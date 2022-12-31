import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingUtilities;


public class SQLSelectScripts extends RobinGUI{
	
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
	         String query = "SELECT id, password, name, lname FROM Robin2 WHERE email = '" + username + "';";
	       //Executes Query
	         ResultSet rs = stmt.executeQuery(query);
	         while ( rs.next() ) {   
	            EditProfile.employeeID= rs.getInt("id");
	       		EditProfile.employeeName = rs.getString("name");
	       		EditProfile.employeeLName = rs.getString("lname");
	       		EditProfile.employeePassword = rs.getString("password");  		
	            EditProfile.employeeUsername = username;
	         }  
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
	        	   getFeedbackLB(525,250,"Wrong credentials. Please try again!");
	        	   SwingUtilities.updateComponentTreeUI(panel);
	           }
	             
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}

  //Searches user email to see if the account exists in the profile list page.
   public static void sqlAdmin(String username)  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, password, name, lname FROM Robin2 WHERE email = '" + username + "';";
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
	         if (RobinGUI.searchTB.getText().equals("brian") || !RobinGUI.searchTB.getText().equals(EditProfile.employeeUsername)) {
	        	 panel.removeAll();
	        	 ProfileList.mainMenu();
	        	 getFeedbackLB(615, 525, "Account not found");
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
   		public static void DisplayAccountsMapPage(String username)  {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, name, lname FROM Robin2 WHERE email = '" + username + "';";
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
	         		AdminMap.getUserLB(1000, 300, "Account not found");
	         		AdminMap.emailValue = null;
	         		AdminMap.getRoom();
	         		
	         } else {
	        	 	getUserLB(1000, 300, "Emailed selected: " + EditProfile.employeeUsername);
	        	 	getThirdLB(750, 300,"Employee name: " + EditProfile.employeeName + " " + EditProfile.employeeLName);
	        	 	SwingUtilities.updateComponentTreeUI(panel);		     
	        	 	SQLTableScripts.GetEmailsMapList();
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
   		/*This method executes when Assign button is clicked in Admin map page to check
   		if the employee is assigned to a seat in the Robin2 table. */
   		public static void CheckEmpSeatStatus() {
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT seat_assigned FROM Robin2 WHERE email = '" + AdminMap.emailValue + "';";
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
	         getFeedbackLB(500, 630, "Please remove employee from assigned seat before assigning.");
	         AdminMap.getRoom();
	         }  else {
	        	 rs.close();
		         stmt.close();
		         c.close();
		         CheckSeatStatus();	
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         SwingUtilities.updateComponentTreeUI(panel);	
	      }		
		}
   		/*This method executes when ASSIGN button is clicked in Admin map page to check
   		if the seat is available in the seatID2 table. */
   		public static void CheckSeatStatus() {
   			try {
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT employee_name, seat_assigned FROM seatid2 WHERE seat_number = '" + AdminMap.originalSeatID + "';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   
   					AdminMap.employeeSeatEmpty2 =  rs.getString("employee_name");
   					AdminMap.seatnull =  rs.getString("seat_assigned");
   				}
   				if (AdminMap.seatnull.equals("Yes")) {
   					rs.close();
   					stmt.close();
   					c.close();
   					panel.removeAll();
   					getFeedbackLB(450, 630, "Please make sure the seat is empty.");
   					AdminMap.getRoom();
   				} else {
   					rs.close();
   					stmt.close();
             	c.close();
             	SQLUpdateInsert.AssignSeatToEmp(1,AdminMap.originalSeatID,EditProfile.employeeUsername); 
   				}
   			} catch (Exception e) {
   				e.printStackTrace();
   				System.err.println(e.getClass().getName()+": "+e.getMessage());
   				System.exit(0);
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}
   		
   		
   		/*This method executes when ASSIGN button is clicked in Admin map page to check
   		if the seat is available in the seatID2 table. */
   		public static void CheckFutureRequestList() {
   			try {
   				EmployeeMap.employee_email = "empty";
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT employee_email FROM futurerequest WHERE employee_email = '" + EditProfile.employeeUsername + "' AND status = 'requested';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   
   					EmployeeMap.employee_email =  rs.getString("employee_email");
   					
   				}
   				
   				if (EmployeeMap.employee_email.equals(EditProfile.employeeUsername)) {
	   					rs.close();
	   					stmt.close();
	   					c.close();
	   					EmployeeMap.getRoom();
	   					FutureRequestFeedBackLB(150, 670, "Please make sure you don't have a pending Priorty request.");
	   					SwingUtilities.updateComponentTreeUI(panel);
	   				} else {
	   					rs.close();
	   					stmt.close();
	             	c.close();   	
	             	CheckFutureRequestList2();
	   				}
   				
   			} catch (Exception e) {
   				e.printStackTrace();
   				System.err.println(e.getClass().getName()+": "+e.getMessage());
   				System.exit(0);
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}
   		
   		
   		/*This method executes when ASSIGN button is clicked in Admin map page to check
   		if the seat is available in the seatID2 table. */
   		public static void CheckFutureRequestList2() {
   			try {
   				String requested_time2 = ""+ hour;
   				System.out.println(requested_time2);
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT requested_time FROM futurerequest WHERE seat_number= '" + EmployeeMap.employeeSeatNumber + "' AND requested_date = '" + calanderDate + "';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   
   					EmployeeMap.requested_time  =  rs.getString("requested_time");
   					
   				}
   				
   				if (EmployeeMap.requested_time.equals(requested_time2)) {
	   					rs.close();
	   					stmt.close();
	   					c.close();
	   					EmployeeMap.getRoom();
	   					FutureRequestFeedBackLB(150, 670, "Seat is reserved during that time, pick a different time.");
	   					SwingUtilities.updateComponentTreeUI(panel);
	   				} else {
	   					rs.close();
	   					stmt.close();
	             	c.close();   	
	                SQLUpdateInsert.addPriortyRequestedSeat(EditProfile.employeeUsername,EmployeeMap.employeeSeatNumber,calanderDate,hour.toString(),Pagetitle);
	   				}
   			
   				
   			} catch (Exception ignore) {
   			 SQLUpdateInsert.addPriortyRequestedSeat(EditProfile.employeeUsername,EmployeeMap.employeeSeatNumber,calanderDate,hour.toString(),Pagetitle);
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}

   		
   		/*This method executes when ASSIGN button is clicked in Admin map page to check
   		if the seat is available in the seatID2 table. */
   		public static void CheckFutureRequestList3() {
   			try {
   				String email = null;
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT employee_email FROM futurerequest WHERE employee_email = '" +EditProfile.employeeUsername + "';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   
   				 email =  rs.getString("employee_email");
   					
   				}
   				
   				if (email.equals(EditProfile.employeeUsername)) {
   						rs.close();
   						stmt.close();
   						c.close();   	
   						SQLRemoveScripts.deleteFutureRequest();
	   				} else {
	             	rs.close();
   					stmt.close();
   					c.close();
   					EmployeeMap.getRoom();
   					FutureRequestFeedBackLB(300, 670, "Seat is empty");
   					SwingUtilities.updateComponentTreeUI(panel);
	   				}
   			
   				
   			} catch (Exception ignore) {
   				FutureRequestFeedBackLB(300, 670, "Seat is empty");
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}
   		
   		public static void CheckFutureRequestList4() {
   			try {
   				
   				String email = null;
   				String seat = null;
   				String day = null;
   				String time = null;		
   				
   				Class.forName("org.postgresql.Driver");
   				c = DriverManager
   						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
   								"postgres", "123");
   				c.setAutoCommit(false);
   				stmt = c.createStatement();
   				String query = "SELECT seat_number, employee_email, requested_date, requested_time FROM futurerequest WHERE employee_email = '" + EditProfile.employeeUsername + "';";
   				//Executes Query
   				ResultSet rs = stmt.executeQuery(query); 
   				while ( rs.next() ) {   		
   				seat = rs.getString("seat_number");
   				email =  rs.getString("employee_email");
   				day = rs.getString("requested_date");
   				time = rs.getString("requested_time");
   				}
   				
   				if (email.equals(null)){
   					getPriortyStatusLB(270,530,"No Priorty Request");
   						rs.close();
   						stmt.close();
   						c.close();   	
   						
	   				} else {
	   					getPriortyStatusLB(100,520,"Priorty request: Seat:" + seat + " Email:"+ email + " Day:" + day + " " + " Time:" + time  );
	             	rs.close();
   					stmt.close();
   					c.close();
	   				}
   			
   				
   			} catch (Exception ignore) {
   				getPriortyStatusLB(270,530,"No Priorty Request");
   				SwingUtilities.updateComponentTreeUI(panel);	
   			}		
   		}
   		
   		
   		/*This method executes when REMOVE button is clicked in Admin map page to check
   		if the seat is empty in the seatID2 table. */
   		public static void checkSeatStatus2(int number, String seatNumber, String UserEmail) {
   			try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT employee_name FROM seatid2 WHERE seat_number = '" + seatNumber + "';";
		       //Executes Query
		         ResultSet rs = stmt.executeQuery(query); 
		         while ( rs.next() ) {   
		        	 AdminMap.employeeSeatEmpty2 =  rs.getString("employee_name");
		         }
		         if (AdminMap.employeeSeatEmpty2 == null && number == 1) {
			        rs.close();
			        stmt.close();
			        c.close();
			        panel.removeAll();
	         		getFeedbackLB(500, 630, "Remove request cancelled. Seat was already empty.");
			        AdminMap.getRoom();
		         } else if(!(AdminMap.employeeSeatEmpty2.equals(UserEmail)) && number == 1) {
		        	 rs.close();
				     stmt.close();
				     c.close();
				     panel.removeAll();
				     getFeedbackLB(500, 630, "Remove request cancelled. Employee was already removed.");
				     AdminMap.getRoom();
		         }   
		         else {
		        	rs.close();
		            stmt.close();
		            c.close();
		            if (number == 1) {
		            SQLRemoveScripts.removeEmailSeat(1, AdminMap.employeeSeatEmpty2);
		            } else {
		            	 SQLRemoveScripts.removeEmailSeat(2, EditProfile.employeeUsername);
		            }
		         		 }
       
   			  } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
         SwingUtilities.updateComponentTreeUI(panel);	
      }		
	}

	//Method to get RequestInformation for the employee page and employee map to verify the request status.
	public static void getRequestDetail()  {
	
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT change_request,requested_seat, seat_assigned FROM Robin2 WHERE email = '" + EditProfile.employeeUsername + "';";
		       //Executes Query
		         ResultSet rs = stmt.executeQuery(query);
		         while ( rs.next() ) {   
		            EditProfile.changeRequestDetail = rs.getString("change_request");	
		            EmployeeMap.empRequestSeat = rs.getString("requested_seat");
		            employeePage.empSeatid = rs.getString("seat_assigned");
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
	
	//Method to count rows in admin page to show the amount of request on the label.
	public static void countRows()  {
		
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
		            "postgres", "123");
		         c.setAutoCommit(false);
		         stmt = c.createStatement();
		         String query = "SELECT COUNT (change_request) FROM robin2 WHERE change_request = '1';";
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
