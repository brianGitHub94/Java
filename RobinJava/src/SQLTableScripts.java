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

public class SQLTableScripts extends RobinGUI {

	static Connection c = null;
    static Statement stmt = null;
    
	//Method to get all accounts in the profile list. (Admin)
	public static void DisplayAllAccounts()  {
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
		           jScrollPane.setBounds(275, 100, 550, 300);
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
	
		//Method to display emails in a JTable in the AdminMap page.
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
		           jScrollPane.setBounds(100, 100, 400, 200);
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
		        		SwingUtilities.updateComponentTreeUI(panel);	
		        		SQLSelectScripts.DisplayAccountsMapPage(searchTB.getText());
		        		RobinGUI.searchTB.setText("");
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
		
		//Method to display request information in the RequestPage (Admin)
			public static void GetRequestList()  {
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
			           jScrollPane.setBounds(200, 100, 700, 300);
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
			        		 AdminMap.RequestedEmail = (String) model5.getValueAt(row, 2);
			        		AdminMap.seatNumberLB(200, 75, "User selected: " + AdminMap.RequestedEmail);
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
		
			//Method to display seats in the AdminMap page.
			public static void GetSeatList(String roomName)  {
				try {
					RobinGUI.arrayAssigned.clear();
					RobinGUI.arrayNumber.clear();
					Class.forName("org.postgresql.Driver");
					c = DriverManager
							.getConnection("jdbc:postgresql://localhost:5432/brianacosta",
									"postgres", "123");
					c.setAutoCommit(false);
					stmt = c.createStatement();
					String query = "SELECT seat_number, seat_assigned, employee_name FROM seatid WHERE room_name = '" + roomName  +"'ORDER BY seat_id USING <;";
					//Executes Query
					ResultSet rs = stmt.executeQuery(query); 
					@SuppressWarnings("serial")
					JTable jTable3 = new JTable() {
						public boolean isCellEditable (int row, int column) {
							return false;       		 
						};
					};
			        JScrollPane jScrollPane = new JScrollPane(jTable3);
			        jScrollPane.setBounds(100, 330, 400, 200);
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
			            //The following if is for JavaGraphics class in order to properly display the map seats with the correct color.
			            if (rs.getString("seat_assigned").equals("Yes"))  {
			            	//Inserts each value to an array list. 
			            	RobinGUI.arrayAssigned.add("Yes");
			            	RobinGUI.arrayNumber.add(rs.getString("seat_number"));
			            } else {
			            	RobinGUI.arrayAssigned.add("No");
			            	RobinGUI.arrayNumber.add(rs.getString("seat_number"));
			            }   
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
	   
	   //Method to display seats for the employee map page.
	   public static void GetSeatList2(String roomNumber)  {
	      try {
	    	  RobinGUI.arrayAssigned.clear();
	    	  RobinGUI.arrayNumber.clear();
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/brianacosta",
	            "postgres", "123");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         String query = "SELECT seat_number, seat_assigned, employee_name FROM seatid where room_name = '" + roomNumber + "' ORDER BY seat_id USING <;";
	         //Executes Query
	           ResultSet rs = stmt.executeQuery(query);
	           
	           @SuppressWarnings("serial")
			JTable jTable4 = new JTable() {
				public boolean isCellEditable (int row, int column) {
					return false;       		 
	        	 };
	           };
	           JScrollPane jScrollPane = new JScrollPane(jTable4);
	           jScrollPane.setBounds(10, 100, 500, 300);
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
	            if (rs.getString("seat_assigned").equals("Yes"))  {
	            	RobinGUI.arrayAssigned.add("Yes");
	            	RobinGUI.arrayNumber.add(rs.getString("seat_number"));
	            } else {
	            	RobinGUI.arrayAssigned.add("No");
	            	RobinGUI.arrayNumber.add(rs.getString("seat_number"));
	            }
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
}
