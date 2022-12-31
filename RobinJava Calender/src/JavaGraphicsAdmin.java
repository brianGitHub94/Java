import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JavaGraphicsAdmin extends JPanel{

	static int xValue[] = {820,920,1020,820,920,1020};
	
	static int yValue[] = {420,420,420,520,520,520};
	static int yValue2[] = {420,380,420,520,570,520};
	static int yValue3[] = {380,420,380,570,520,570};
	
	public void paint(Graphics g) {
		
	if (AdminMap.roomNumber == 1) {
		g.drawRect(800, 350, 300, 300);	
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
		g.drawRect(800, 350, 300, 300);
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
		g.drawRect(800, 350, 300, 300);
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
