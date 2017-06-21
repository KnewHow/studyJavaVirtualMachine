package chapter07_classInitialize_day01.demo2;

/**
 * Show initialize order
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo2 {
	public static void main(String[] args) {
		/**
		 * From execute result,parent <code>clinit</code> is priorer than sub
		 * class,but static code and initialize is order by code
		 */
		System.out.println(Sub.B);
	}
}

class Parent {
	/**
	 * result is 2
	 */
	// public static int A = 1;
	// static {
	// A = 2;
	// }

	/**
	 * Result is 1
	 */
	static {
		A = 2;
	}
	public static int A = 1;

}

class Sub extends Parent {
	public static int B = A;
}
