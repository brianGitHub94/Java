import javax.swing.JFrame;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class BrianAcostaHerencia
{
   public static void main (String args[])
   {
      JFrame marco = new JFrame();
      marco.setSize(640, 480);
      marco.setTitle("Primitivos Gráficos");
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      marco.setVisible(true);
      
      GraphicComponent grafico = new GraphicComponent();
      marco.add(grafico);
   }
}

class GraphicComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
    
      Poligono miPoligono = new Poligono(5, 40, 25);
      miPoligono.setCoordForOneVertex(0,20,40);
      miPoligono.setCoordForOneVertex(1,60,40);
      miPoligono.setCoordForOneVertex(2,60,10);
      miPoligono.setCoordForOneVertex(3,20,10);  
      miPoligono.setCoordForOneVertex(4,30,30);  
      miPoligono.moveDown(100); 
      miPoligono.draw(g);
      
      Triangulo triangle1 = new Triangulo(10,10,30,50,40,20,25,30);
      triangle1.draw(g);

      Rectangulo rectangle1= new Rectangulo(80,60,140,80);
      rectangle1.draw(g);
      
      g.setColor(Color.BLUE);
      rectangle1.grow(2);
      rectangle1.draw(g);
      
      
      String name = triangle1.displayStringInside("luis");
      g.drawString(name, 25 - 2 * name.length() , 30);
      name = triangle1.displayStringInside("Brian");
      g.drawString(name, 107 - 3 * name.length(), 75);
      System.out.println(triangle1.getArea());
      System.out.println(rectangle1.getArea());
      System.out.println(miPoligono.getPerimeter());
      
      
   }
}

class Poligono 
{
   double x[], //contains x coordinate for vertices
           y[], //contains y coordinate for vertices
           xc,  //(xc,yc) = figure's center or
           yc;  //reference point
       
   int totalPoints; //number of vertices
   private double perimeter; 
  
   //number 2
   Poligono()
   {
    perimeter = 0;
   }
            
   Poligono(int totalPoints, double xc, double yc)
   {
      this.totalPoints = totalPoints;
      x = new double[totalPoints];
      y = new double[totalPoints]; 
      this.xc = xc;
      this.yc = yc;
   }
   
   
      Poligono(double p) { 
         this.perimeter = p;
   }
         
          double getPerimeter() {
          return perimeter;
  }
   
   
   void setCenterCoords(double xc, double yc)
   {
      this.xc = xc;
      this.yc = yc;
   }
   
   void setCoordForOneVertex(int index, double x, double y)
   {
      if ((index < totalPoints)&& (index >= 0))
      {
         this.x[index] = x;
         this.y[index] = y;
      }
   }
   
   void grow(double factor)
   {
      int i;
      
      for (i = 0; i < totalPoints; i++)
      {
         x[i] = (x[i] - xc) * factor + xc;
         y[i] = (y[i] - yc) * factor + yc;
      }
   }
      
   void moveDown(double displacement)
   {
      for (int i = 0; i < totalPoints; i++)
      {
         y[i] = y[i] + displacement;
      }
      yc = yc + displacement;
   }
   
   void draw(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      int i;
      Line2D.Double linea = new Line2D.Double(150, 200, 200, 240);
      for (i = 0; i < totalPoints - 1; i++)
      {
    	 linea = new Line2D.Double(x[i], y[i], x[i+1], y[i+1]);
         g2.draw(linea);
      }
 	  linea = new Line2D.Double(x[0], y[0], x[totalPoints - 1], y[totalPoints - 1]);
      g2.draw(linea);
   }
}

class Triangulo extends Poligono
{
  double y1;
  double y2;
  
   Triangulo(double x1, double y1, double x2, double y2,
            double x3, double y3, double xc, double yc) {
        
      super(3,xc,yc);
      setCoordForOneVertex(0, x1, y1);
      setCoordForOneVertex(1, x2, y2);
      setCoordForOneVertex(2, x3, y3);
      this.y1 = y1;
      this.y2 = y2;
       
  }    
  
      double getArea() {
      double a = y1 * y2 / 2;    
      return a;
 } 
      //New method: TO DO
     String displayStringInside(String theString)
       { 
       
        return theString;
       }
}

   class Rectangulo extends Poligono {
   
      //New: Given constructor
      Rectangulo ()
      {
      super(4,0.0,0.0);
       }
      //Rectangulo Overcharge constructor that recieves four double parametros.
      
      double x1;
      double y2;
      
      Rectangulo (double x1, double y1, double x2, double y2)
      {
      //a Super constructor.
      super(4,0.0,0.0);
      //Two double variables that have been initialized. 
      double midX,
              midY;
       //Declared variable midX to equal to the promedio of x1 and x2.      
      midX = (x1 + x2)/2.0;
      //Declared variable midy to equal to the promedio of y1 and y2.      
      midY = (y1 + y2)/2.0;
      /*declares following variables with the parameters that were inserted 
      when the object is made with the overchare constructor. */
      setCenterCoords(midX,midY);
      setCoordForOneVertex(0, x1, y1);
      setCoordForOneVertex(1, x2, y1);
      setCoordForOneVertex(2, x2, y2);        
      setCoordForOneVertex(3, x1, y2);   
      this.x1 = x1;
      this.y2 = y2; 
   }
   
   //New method: TO DO
     double getArea() {
      double a = x1 * y2;
      return a;
   }   
    
   //New method: TO DO
   String displayStringInside(String theString)
   {
     return theString;
   }
}

      //*** New class: Given and to be Explained
      class Cuadrado extends Rectangulo  {
      // The class cuadrado extends to the super class Rectangulo
      
      
      
        Cuadrado (double x1, double y1, double width) {
        // the class has 3 atributes
       
          super(x1,y1,x1+width,y1+width);  
        /* This is the code that will call 
           the method in the super class Rectangulo. */
      }
  }