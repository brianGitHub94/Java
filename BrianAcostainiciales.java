//Brian Acosta Calero
//11-1-17
//A00508404


import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Polygon;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;

public class BrianAcostainiciales
{
   public static void main (String args[])
   {
      JFrame marco = new JFrame();
      marco.setSize(640, 480);
      marco.setTitle("Primitivos Gráficos");
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      marco.setVisible(true);
      
      GraphicComponent grafico = new GraphicComponent();
      //marco.add(grafico);
   }
}
   class GraphicComponent extends JComponent 
   {
     public void paintComponent(Graphics g)
     {
     
       Graphics2D g2 = (Graphics2D) g;
       //Color for the letter B
       Color red = new Color(200, 0, 0);
       g2.setColor(red);
       // Letter B and it's coordinates
       Rectangle LetterB = new Rectangle(5, 30, 60, 270) ;
       g2.fill(LetterB);
       
        Rectangle LetterB2 = new Rectangle(60, 30, 90, 120) ;
       g2.fill(LetterB2);
       
       Rectangle LetterB3 = new Rectangle(60, 180, 90, 120) ;
       g2.fill(LetterB3);
       // Change it to green
       Color green = new Color(0, 180, 120);
       g2.setColor(green);
       Rectangle LetterB4 = new Rectangle(50, 200, 80, 80) ;
       g2.fill(LetterB4);
       
       Rectangle LetterB5 = new Rectangle(50, 50, 80, 80) ;
       g2.fill(LetterB5);
       //End of Letter B
       // Color for Letter A
       Color blue = new Color(0, 0, 255);
       g2.setColor(blue);
       // Beginning of letter A
        Rectangle LetterA = new Rectangle(200, 30, 50, 300) ;
       g2.fill(LetterA);
       
        Rectangle LetterA2 = new Rectangle(200, 30, 180, 50) ;
       g2.fill(LetterA2);
       
        Rectangle LetterA3 = new Rectangle(350, 30, 50, 300) ;
       g2.fill(LetterA3);
       
       Rectangle LetterA4 = new Rectangle(200, 120, 200, 50) ;
       g2.fill(LetterA4);
       //End of Letter A
       //Color for Letter C
       Color purple = new Color(150, 50, 200);
       g2.setColor(purple);
       // Letter C
       Rectangle LetterC = new Rectangle(420, 30, 50, 300) ;
       g2.fill(LetterC);
     
      Rectangle LetterC2 = new Rectangle(420, 30, 180, 50) ;
       g2.fill(LetterC2);
     
     Rectangle LetterC3 = new Rectangle(420, 280, 180, 50) ;
       g2.fill(LetterC3);
       // End of Program
       {
       }
       }
       }