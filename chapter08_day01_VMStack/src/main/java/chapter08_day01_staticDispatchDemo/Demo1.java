package chapter08_day01_staticDispatchDemo;

/**
 * A class to demo static dispatch,in this case,we use a reload to show
 * 
 * @author ygh Jun 18, 2017
 */
public class Demo1 {

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		sayHello(man);
		sayHello(woman);

		/**
		 * Run result: human say hello!
		 * 
		 * human say hello!
		 * 
		 * Reload is a static dispatch,its location method is at compile moment.
		 * At the compile moment <code>Human</code> is a static types,but
		 * <code>Man</code> and <code>Woman</code> is dynamic type which can be
		 * known at the run time.
		 */
	}

	/**
	 * A method to show reload
	 * 
	 * @param h
	 */
	public static void sayHello(Human h) {
		System.out.println("human say hello!");
	}

	/**
	 * A method to show reload
	 * 
	 * @param m
	 */
	public static void sayHello(Man m) {
		System.out.println("human say hello!");
	}

	/**
	 * A method to show reload
	 * 
	 * @param w
	 */
	public static void sayHello(Woman w) {
		System.out.println("human say hello!");
	}

}

/**
 * A abstract super class
 * 
 * @author ygh Jun 18, 2017
 */
abstract class Human {

}

class Man extends Human {

}

class Woman extends Human {

}
