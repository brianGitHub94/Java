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
   
				String query = "UPDATE ROBIN SET name = '" + name +  "',lname = '" + lname +  "',password = '" + password +  "' WHERE id = " + id;
				//Executes Query
				stmt.executeUpdate(query);
				c.close();
				stmt.close();
				getFeedbackLB(490, 320, "Account details updated.");
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
				getFeedbackLB(515,325,"Insert complete");
				CreateEditProfile.mainMenu();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					panel.removeAll();
					getFeedbackLB(475, 325, "Email address already exist");
					CreateEditProfile.mainMenu();
			}
			SwingUtilities.updateComponentTreeUI(panel);	
		}
		
		//Method to assign seat number to employee in robin table.
		public static void AssignSeatToEmp(int a, String SeatID, String email ) {
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

	//Method to assign employee a seat in SeatID. Edits email _name and seat_assigned
	public static void AssignEmpSeatID(int a, String email, String SeatID) {
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
						"postgres", "123");
		stmt = c.createStatement();
		String query = "UPDATE seatid SET employee_name = '" + email + "', seat_assigned = 'Yes' WHERE seat_number = '" + SeatID + "'";
		//Executes Query
		stmt.executeUpdate(query);
		c.close(); 
		stmt.close();
		if ( a ==1) {
		panel.removeAll();
		getFeedbackLB(500, 600, "Account updated!");
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
}