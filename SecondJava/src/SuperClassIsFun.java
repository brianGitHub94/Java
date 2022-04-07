class Monkey {
	
	
	
}


abstract class Dog {
	
	int a = 5;
	
	void bark()  {
		System.out.println();
		
	}
	
	abstract void poop();
	
}




public class SuperClassIsFun extends Dog {

	public static void main(String[] args) {
		
		String e = "This is a String";
		System.out.println(e);
		
		Monkey m1 = new Monkey();
		Monkey m2 = new Monkey();
		Monkey m3 = new Monkey();

		Monkey[] monkeys = {m1, m2,m3};
		
		SuperClassIsFun c = new SuperClassIsFun();
		System.out.println(c.a = 9);
		c.poop();
		c.bark();
	}

	@Override
	void poop() {
		System.out.println("Dog pooped!");
		
	}
	
}
