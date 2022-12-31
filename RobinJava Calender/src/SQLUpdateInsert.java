import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.SwingUtilities;

public class SQLUpdateInsert extends RobinGUI{
	static Connection c = null;
    static Statement stmt = null;
    
	//Method to edit account details. 
		public static void EditAccountInfo(int id, String name, String lname, String password) {
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
   
				String query = "UPDATE ROBIN2 SET name = '" + name +  "',lname = '" + lname +  "',password = '" + password +  "' WHERE id = " + id;
				//Executes Query
				stmt.executeUpdate(query);
				c.close();
				stmt.close();
				getFeedbackLB(580, 320, "Account details updated.");
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
   
				String query = "INSERT INTO ROBIN2 (email, name, lname, password,seat_assigned,change_request)" 
				+   " VALUES ('" + email + "','" + name +  "','" + lname +  "', '" + password + "'," +  null + "," +'2' + ")";
				//Executes Query
				stmt.executeUpdate(query);
				c.close();
				stmt.close();
				panel.removeAll();
				getFeedbackLB(590,325,"Insert complete");
				CreateEditProfile.mainMenu();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					panel.removeAll();
					getFeedbackLB(550, 325, "Email address already exist");
					CreateEditProfile.mainMenu();
			}
			SwingUtilities.updateComponentTreeUI(panel);	
		}
		
		//Method to assign seat number to employee in robin2 table.
		public static void AssignSeatToEmp(int a, String SeatID, String email ) {
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager
						.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
								"postgres", "123");
				stmt = c.createStatement();
				String query = "UPDATE ROBIN2 SET seat_assigned = '" + SeatID + "' WHERE email = '" + email + "'";
				//Executes Query
				stmt.executeUpdate(query);  
				c.close(); 
				stmt.close();
			if (a == 1) {
				AssignEmpSeatID(1,EditProfile.employeeUsername, AdminMap.originalSeatID);
			} else {
				AssignEmpSeatID(2,AdminMap.RequestedEmail,RequestPage.AdminRequestSeat);
			}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}
			SwingUtilities.updateComponentTreeUI(panel);	
		}

	//Method to assign employee a seat in SeatID2 Edits email _name and seat_assigned
	public static void AssignEmpSeatID(int a, String email, String SeatID) {
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
						"postgres", "123");
		stmt = c.createStatement();
		String query = "UPDATE seatid2 SET employee_name = '" + email + "', seat_assigned = 'Yes' WHERE seat_number = '" + SeatID + "'";
		//Executes Query
		stmt.executeUpdate(query);
		c.close(); 
		stmt.close();
		if ( a ==1) {
		panel.removeAll();
		getFeedbackLB(500, 630, "Account updated!");
		AdminMap.emailValue = null;
		AdminMap.employeeAssigned = null;
		AdminMap.seatValue = null;
		AdminMap.getRoom();
		} else {
			getFeedbackLB(400, 350, "Account updated!");
		}
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
		 
					String query = "UPDATE robin2 SET requested_seat = '" + requestedSeat + "', change_request = 1 WHERE email = '" + email + "';";
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
	
	//Method to add a Priorty equested seat and change request.
	public static void addPriortyRequestedSeat(String email, String requestedSeat,String requested_date, String requested_time,String room_name) {
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					stmt = c.createStatement();
		 
					String query = "INSERT INTO futurerequest (requested_date, requested_time,seat_number,room_name, employee_email, status)"
							+ "VALUES ('" + requested_date + "','" + requested_time+  "','" + requestedSeat +  "', '" + room_name  + "','" +  email+ "','" +"requested" + "');";
					//Executes Query
					stmt.executeUpdate(query);  
					c.close(); 
					stmt.close();
					panel.removeAll();
					FutureRequestFeedBackLB(250, 670, "Your seat has been reserved");
					EmployeeMap.getRoom();
					
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}	
	}
	
	
	
}