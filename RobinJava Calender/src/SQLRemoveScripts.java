import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

public class SQLRemoveScripts extends RobinGUI {
	static Connection c = null;
    static Statement stmt = null;
    
	//Method to edit email seat_assigned
		public static void  removeSeatEmail(int number,String seatNumber){
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
				String query = "UPDATE seatid2 SET employee_name = NULL, seat_assigned = 'No' WHERE seat_number = '" + seatNumber+ "';";
				//Executes Query
				stmt.executeUpdate(query);
				c.close(); 
				stmt.close();
				if (number == 1) {
				panel.removeAll();
				AdminMap.getRoom();
				getFeedbackLB(500, 630, "Account updated!");
				AdminMap.emailValue = null;
				AdminMap.employeeAssigned = null;
				AdminMap.seatValue = null;
				} 
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}
			}
		
		//Method to edit seat in Seat ID and set seat_assign to No, and employee_name to null in request Page.
			public static void  removeCurrentEmpSeat(String email){
		
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();

					String query = "UPDATE seatid2 SET employee_name = NULL, seat_assigned = 'No' WHERE employee_name = '" + AdminMap.RequestedEmail + "';";
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
	
			//Method to edit seat in Seat ID and set seat_assign to No, and employee_name to null in Request Page.
			public static void remCurrentEmpSeatID() {	
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();
					String query = "UPDATE robin2 SET seat_assigned = NULL WHERE seat_assigned = '" + RequestPage.AdminRequestSeat + "';";
					//Executes Query
					stmt.executeUpdate(query);  
					c.close(); 
					stmt.close();
					SQLRemoveScripts.removeSeatEmail(2, RequestPage.AdminRequestSeat);
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}		
			}

		//Method to remove Requested seat and change request to 2 in Robin2 table in employee map and Admin reqestPage.
			public static void removeRequestedSeat(String email) {	
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();		 
					String query = "UPDATE robin2 SET requested_seat = NULL, change_request = 2 WHERE email = '" + email + "';";
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
	
			/*This method executes when REMOVE button is clicked in Admin map page 
			 * and after checkSeatStatus2 Method is ran. */
			public static void removeEmailSeat(int number, String Email) {		
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();		 
					String query = "UPDATE robin2 SET seat_assigned = NULL WHERE email = '" + Email + "';";
					//Executes Query
					stmt.executeUpdate(query);  
					c.close(); 
					stmt.close();
					//If user is in admin page 1 will be triggered. If user is in employee page 2 will be triggered.
					if (number == 1) {
					SQLRemoveScripts.removeSeatEmail(1, AdminMap.originalSeatID);
					} else if (number == 2) {
						SQLRemoveScripts.removeSeatEmail(2, employeePage.empSeatid);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}		
			}
			
			/*This method executes when REMOVE button is clicked in Admin map page 
			 * and after checkSeatStatus2 Method is ran. */
			public static void deleteFutureRequest() {		
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();		 
					String query = "DELETE FROM futureRequest WHERE employee_email = '" + EditProfile.employeeUsername + "';";
					//Executes Query
					stmt.executeUpdate(query);  
					c.close(); 
					stmt.close();
					panel.removeAll();
					FutureRequestFeedBackLB(220, 670, "Reservation removed successfully");
					EmployeeMap.getRoom();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}		
			}
			
			/*This method executes when REMOVE button is clicked in Admin map page 
			 * and after checkSeatStatus2 Method is ran. */
			public static void deleteFutureRequest2() {		
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();		 
					String query = "DELETE FROM futureRequest WHERE employee_email = '" + AdminMap.RequestedEmail + "';";
					//Executes Query
					stmt.executeUpdate(query);  
					c.close(); 
					stmt.close();
					panel.removeAll();
					FutureRequestFeedBackLB(530, 420, "Reservation removed successfully");
					RequestPage.ScheduledRequestPage();
					
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}	
			}
}