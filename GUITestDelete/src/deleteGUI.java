import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deleteGUI {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel titlePageLB = new JLabel();
	static JTextField usernameTB = new JTextField();
	static JTextField passwordTB = new JTextField();
	static JLabel usernameLB = new JLabel();
	static JLabel passwordLB = new JLabel();
	static JTextField fNameTB = new JTextField();
	static JTextField lNameTB = new JTextField();
	static JLabel fNameLB = new JLabel();
	static JLabel lNameLB = new JLabel();
	static JLabel welcomeLB = new JLabel();
	static JButton homeBTN = new JButton();
	static JButton loginBTN = new JButton();
	
	public deleteGUI() {
		//Setting the size of the window when it opens.
		frame.setSize(550,550);
		//Default close operation.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//To set a title which will be displayed out the top center of the window.
		frame.setTitle("RobinJava");
		//Sets panel layout to null.
		panel.setLayout(null);
		//More default frame options.
		//frame.pack();
		frame.setVisible(true);
		frame.add(panel);
		
		return;
		}
		
		
		//Get screen title
		public static void getTitle(int xValue, String title)  {
			//Title label
			titlePageLB.setBounds(xValue,20,250,30);
			titlePageLB.setText(title);
		panel.add(titlePageLB);
			return;
		}
		
		
		//Get Username label
		static void getUserLB(int lbX, int lbY, String text)  {
			usernameLB.setBounds(lbX,lbY,250,30);
			usernameLB.setText(text);
			panel.add(usernameLB);
		}
		//Get Password label
		static void getPassLB(int lbX, int lbY, String text)  {
			passwordLB.setBounds(lbX,lbY,250,30);
			passwordLB.setText(text);
			panel.add(passwordLB);
		}
		//Get Username textbox
		static void getUserTB(int tbX, int tbY, String text)  {
			usernameTB.setBounds(tbX,tbY,250,30);
			//Adding text box to panel.
			panel.add(usernameTB);
			//Setting text to null.
			usernameTB.setText(text);
		
		}
		//Get Password textbox
		static void getPassTB(int tbX, int tbY, String text)  {
			passwordTB.setBounds(tbX,tbY,250,30);
			//Adding text box to panel.
			panel.add(passwordTB);
			//Setting text to null.
			passwordTB.setText(text);
			
		}
		
	
	
}
