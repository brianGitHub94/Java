import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

	@SuppressWarnings("serial")
	public class JavaGraphics extends JPanel{	
		static int xValue[] = {720,820,920,720,820,920};
		static int yValue[] = {170,170,170,270,270,270};
		
		
		public void paint(Graphics g) {
			if (EmployeeMap.empRoomNumber == 1) {
				g.drawString("Main Room", 810, 90);
				g.drawRect(700, 100, 300, 300);	
				for (int i = 0; i < 6; i++) {
					if (EmployeeMap.arrayAssigned.get(i).equals("Yes")) {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.RED);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					} else {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.GREEN);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					}
				}
				
			} else if (EmployeeMap.empRoomNumber == 2 ) {
				g.drawString("Room Two", 810, 90);
				g.drawRect(700, 100, 300, 300);
				for (int i = 0; i < 6; i++) {
					if (EmployeeMap.arrayAssigned.get(i).equals("Yes")) {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.RED);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					} else {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.GREEN);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					}
				}
				
			} else if (EmployeeMap.empRoomNumber == 3 ) {
				g.drawString("Room Three", 810, 90);
				g.drawRect(700, 100, 300, 300);
				for (int i = 0; i < 6; i++) {
					if (EmployeeMap.arrayAssigned.get(i).equals("Yes")) {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.RED);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					} else {
						g.setColor(Color.BLACK);
						g.drawString("Seat " + EmployeeMap.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
						g.setColor(Color.GREEN);
						g.fillRect(xValue[i], yValue[i], 50, 50);
					}
				}		
			}
		}		
}
