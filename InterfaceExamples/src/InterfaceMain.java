interface WaterBottle {
	
	//This variable is final
	String a = "this is a String";
	
	//This method is abstract 
	void testMethod();
	
}





public class InterfaceMain implements WaterBottle{

	public static void main(String[] args) {
	
		/*System.out.println("This is another string!");
		System.out.println(a.toUpperCase());
		//Creates an object
		InterfaceMain b = new InterfaceMain();
		//Prints method from Interface
		b.testMethod();
		
		
		
		int key = 6;
		String text = "Znoy&oy&g&ygsvrk&zk~z";
		
		System.out.println(text);
		
		char[] chars = text.toCharArray();

		for(char c: chars)  {

			c -= key;

			System.out.print(c); 
			} */
			
		
		String text = "brianAcosta"; 
		System.out.println(text);
		
		char reverseArray [] = text.toCharArray();
		int arrayPosition = text.length();	
		char chars [] = text.toCharArray();
		
		for(char c: chars)  {
			
			arrayPosition = arrayPosition - 1;
		    reverseArray[arrayPosition] = c;
		    		
			}
				System.out.println(reverseArray);
		}
		
		
		
		
		
		
		

	@Override
	public void testMethod() {
		//Defining Interface method.
		System.out.println(5);
		
	}

}
