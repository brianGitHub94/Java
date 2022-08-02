import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingUtilities;

public class SQLScripts extends RobinGUI{

	//Method to check if user and password matches in the database. 
public static void sqlConnection(String username)  {
		Connection c = null;
	    Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT id, password, name, lname FROM Robin WHERE email = '" + username + "';";
	       
	         ResultSet rs = stmt.executeQuery(query);
	         while ( rs.next() ) {   
	            EditProfile.employeeID= rs.getInt("id");
	       		EditProfile.employeeName = rs.getString("name");
	       		EditProfile.employeeLName = rs.getString("lname");
	       		EditProfile.employeePassword = rs.getString("password");  		
	            EditProfile.employeeUsername = username;
	         }
	           //If email and password matches from the database it'll enter employee page.
	           if (RobinGUI.usernameTB.getText().equals(username) && RobinGUI.passwordTB.getText().equals(EditProfile.employeePassword) && !username.equals("brian")) {
	        	  panel.removeAll();
	        	   employeePage.mainMenu();
	        	   //If admin username and password matches from database it''ll enter admin page.
	           } else if (username.equals("brian") && RobinGUI.passwordTB.getText().equals(EditProfile.employeePassword)) {
	        	   panel.removeAll();
	        	   AdminPage.mainMenu();
	           }          
	         //Clses statement and connection
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
		//Method to edit account details. 
public static void updateName(int id, String name, String lname, String password) {
	
	Connection c = null;
	Statement stmt = null;
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
          "postgres", "123");
       stmt = c.createStatement();
       
       String query = "UPDATE ROBIN SET name = '" + name +  "',lname = '" + lname +  "',password = '" + password +  "' WHERE id = " + id;
       stmt.executeUpdate(query);
       

        c.close();
        stmt.close();
       
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
     //System.out.println("Opened database successfully");
    SwingUtilities.updateComponentTreeUI(panel);	
	}
	

public static void insertAccount(int id, String name, String lname, String email, String password, String mapid ) {
	
	Connection c = null;
	Statement stmt = null;
	int a = Integer.parseInt(mapid);
	
	
	
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
          "postgres", "123");
       stmt = c.createStatement();
       
       String query = "INSERT INTO ROBIN (email, name, lname, password,mapid)" 
    		+   " VALUES ('" + email + "','" + name +  "','" + lname +  "', '" + password + "'," +  a + ")";
       
       stmt.executeUpdate(query);
       
       getInsertLB(230,350,"Insert complete");
        c.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
     //System.out.println("Opened database successfully");
    SwingUtilities.updateComponentTreeUI(panel);	
	}
	
}
