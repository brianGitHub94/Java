import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLRemoveScripts extends RobinGUI {
	static Connection c = null;
    static Statement stmt = null;
    
	//Method to edit email seat_assigned
		public static void  removeSeatEmail(int a,String seatNumber){
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
				String query = "UPDATE seatid SET employee_name = NULL, seat_assigned = 'No' WHERE seat_number = '" + seatNumber+ "';";
				//Executes Query
				stmt.executeUpdate(query);
				c.close(); 
				stmt.close();
				if (a == 1) {
				panel.removeAll();
				AdminMap.mainMenu();
				getFeedbackLB(500, 600, "Account updated!");
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

					String query = "UPDATE seatid SET employee_name = NULL, seat_assigned = 'No' WHERE employee_name = '" + AdminMap.RequestedEmail + "';";
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
					String query = "UPDATE robin SET seat_assigned = NULL WHERE seat_assigned = '" + RequestPage.AdminRequestSeat + "';";
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

		//Method to remove Requested seat and change request to 2 in Robin table in employee map and Admin reqestPage.
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
	
			/*This method executes when REMOVE button is clicked in Admin map page 
			 * and after checkSeatStatus2 Method is ran. */
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
					SQLRemoveScripts.removeSeatEmail(1, AdminMap.originalSeatID);
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}		
			}
}