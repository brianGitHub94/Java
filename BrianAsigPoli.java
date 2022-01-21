   //done in 2021
   abstract class DispositivoPortatil {
   //variables for the superclass
     String modelo, tecladoFisico, inputPantalla;
     double capMemRam;
     
     //Default constructor
     DispositivoPortatil()
     {
     modelo = null;
     tecladoFisico = null;
     inputPantalla = null;
     capMemRam = 0.0;
     }
     //constructor with 3 parameters
     DispositivoPortatil(String m, String t, String i, double c)  {
     modelo = m;
     tecladoFisico = t;
     inputPantalla = i;
     capMemRam = c;
     }
     //toString method which will take all the variables and put them into a string.
     public String toString()  {
     return(modelo + " " + tecladoFisico + " " + inputPantalla + " " + capMemRam);
     }
     //add method which adds variable a and b and returns the sum
     int add(int a, int b)  {
     a = a + b;
     return a;
     }
     //abstract methods getInput and setInput
     public abstract String getInput(); 
     public abstract void setInput(String input);  
    
 }
     //Tablet subclass that extends form DispositivoPortatil
     class Tablet extends DispositivoPortatil {
      //default constructor
      Tablet() {
      modelo = "Nook";
      capMemRam = 16.0;   
      }  
      //constructor with 4 parameters
      Tablet(String m, String t, String i, double c)  
      {
       modelo = m;
       inputPantalla = i;
       capMemRam = c;
      }
        //getters and setters
        public String getInput() {    
            return this.inputPantalla;
         }
      
        public void setInput(String input) {
            this.inputPantalla = input; }     
 }
        //Laptop subclass that extends form DispositivoPortatil.
        class Laptop extends DispositivoPortatil {  
        //Default constructor    
        Laptop() {
        modelo = "Aspire One";
        capMemRam = 4.0;
        }
        //constructor with 4 parameters.
        Laptop(String m, String t, String i, double c) {
        modelo = m;
        tecladoFisico = t;
        capMemRam = c;  
        }
      
        //getters and setters.
        public String getInput() {
        return this.inputPantalla;
   }
        public void setInput(String input)  {
        this.inputPantalla = input;
   }
          
}  
        //Celular subclass that extends form DispositivoPortatil.
        class Celular extends DispositivoPortatil  {
         //Default constructor 
        Celular() {
        modelo = "iPhone";
        capMemRam = 16.0;
      }
        //constructor with 4 parameters.
        Celular(String m, String t, String i, double c) {
        modelo = m;
        //if modelo = iphone or galaxy it'll use the inputPatalla from celular class else it uses the teclado from celular class.
        if(modelo == "iPhone" || modelo == "Galaxy") {
        inputPantalla = i;
        }
        else if (modelo == "Blackberry" || modelo == "Sidekick") {
        tecladoFisico = t;
        }
        capMemRam = c;  
        }
        
         //getters and setters.  
         public String getInput() {
         //If modelo = blackberry or sidekick it'll set the getter to teclado, else inputPantalla.
         if(modelo == "Blackberry" || modelo == "Sidekick") {
         return this.tecladoFisico;  
         }
         return this.inputPantalla;
         
   }     
         //If modelo = blackberry or sidekick it'll set the setter to teclado, else inputPantalla.
         public void setInput(String input) { 
         if(modelo == "Blackberry" || modelo == "Sidekick") {
         this.tecladoFisico = input;  
         }
         this.inputPantalla = input;
   }     
   
   
}  
      //main class.
      public class BrianAsigPoli  {
      
      public static void main(String[] args) {
      //creates 6 objects from 3 different subclasses.
      //uses default constructor.
      Tablet a = new Tablet();
      Laptop b = new Laptop();
      Celular c = new Celular();
      //uses overcharged constructor.
      Tablet d = new Tablet("iPad","No","Yes",12);
      Laptop e = new Laptop("mac","Magic keyboard","touchbar",64);
      Celular f = new Celular("Blackberry","keyboard","touchScreen",9);
      //Prints the 6 objects form the 3 subclasses.
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);
      System.out.println(e);
      System.out.println(f); 
      //Using the add method.     
      System.out.println(c.add(2,2));
      //Using the getInput method.
      System.out.println(f.getInput());
      //Using the setInput method.
      e.setInput("normal teclado");
      System.out.println(e.getInput());
      }
   }