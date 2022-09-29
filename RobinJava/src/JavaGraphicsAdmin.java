import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JavaGraphicsAdmin extends JPanel{

	static int xValue[] = {670,770,870,670,770,870};
	
	static int yValue[] = {170,170,170,270,270,270};
	static int yValue2[] = {170,130,170,270,320,270};
	static int yValue3[] = {130,170,130,320,270,320};
	
	public void paint(Graphics g) {
		
	if (AdminMap.roomNumber == 1) {
		g.drawRect(650, 100, 300, 300);	
		for (int i = 0; i < 6; i++) {
			if (RobinGUI.arrayAssigned.get(i).equals("Yes")) {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
				g.setColor(Color.RED);
				g.fillRect(xValue[i], yValue[i], 50, 50);
			} else {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue[i]- 10));
				g.setColor(Color.GREEN);
				g.fillRect(xValue[i], yValue[i], 50, 50);
			}
		}
		
	} else if (AdminMap.roomNumber == 2 ) {
		g.drawRect(650, 100, 300, 300);
		for (int i = 0; i < 6; i++) {
			if (RobinGUI.arrayAssigned.get(i).equals("Yes")) {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue2[i]- 10));
				g.setColor(Color.RED);
				g.fillRect(xValue[i], yValue2[i], 50, 50);
			} else {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue2[i]- 10));
				g.setColor(Color.GREEN);
				g.fillRect(xValue[i], yValue2[i], 50, 50);
			}
		}
		
	} else if (AdminMap.roomNumber == 3 ) {
		g.drawRect(650, 100, 300, 300);
		for (int i = 0; i < 6; i++) {
			if (RobinGUI.arrayAssigned.get(i).equals("Yes")) {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue3[i]- 10));
				g.setColor(Color.RED);
				g.fillRect(xValue[i], yValue3[i], 50, 50);
			} else {
				g.setColor(Color.BLACK);
				g.drawString("Seat " + RobinGUI.arrayNumber.get(i), (xValue[i] + 5 ), (yValue3[i]- 10));
				g.setColor(Color.GREEN);
				g.fillRect(xValue[i], yValue3[i], 50, 50);
				}
			}		
		}
	}
}
