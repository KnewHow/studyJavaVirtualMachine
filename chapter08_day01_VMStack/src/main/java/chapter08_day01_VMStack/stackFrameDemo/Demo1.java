package chapter08_day01_VMStack.stackFrameDemo;

/**
 * A class to demo local variable table memory collect
 * 
 * @author ygh Jun 18, 2017
 */
public class Demo1 {

	public static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}

	/**
	 * A method to demo when a local variable take up big memory but use
	 * {@link System.gc()} don't collect it.
	 * 
	 * run result: [GC (System.gc()) 66171K->65864K(126976K), 0.0021591 secs]
	 * [Full GC (System.gc()) 65864K->65796K(126976K), 0.0315539 secs]
	 */
	public static void demo1() {
		@SuppressWarnings("unused")
		byte[] placeholder = new byte[64 * _1MB];
		System.gc();
	}

	/**
	 * In above test case,you may consider the <code>placeholder </code> hasn't
	 * been released,so we use following test:
	 * 
	 * run result: [GC (System.gc()) 66171K->65864K(126976K), 0.0021591 secs]
	 * [Full GC (System.gc()) 65864K->65796K(126976K), 0.0315539 secs]
	 * 
	 * The memory hasn't been release,why?
	 */
	public static void demo2() {
		{
			@SuppressWarnings("unused")
			byte[] placeholder = new byte[64 * _1MB];
		}
		System.gc();
	}

	/**
	 * In this test case ,we find the memory has been released, [GC
	 * (System.gc()) 131331K->131331K(193024K), 0.0041803 secs] [Full GC
	 * (System.gc()) 131331K->259K(193024K), 0.0063840 secs]
	 * 
	 * The reason is following: The slot(Variable Slot) is can be reusable in
	 * local variable table. In above case,there no variable to us the space
	 * which <code>placeholder</code>, but its life and range has disappear,but
	 * none variables to use the space. In this case,we use a variable
	 * <code>a</code> to reuse the space,So the can see the memory is collected.
	 * 
	 * In a word,we can set the variable which we don't use it recently to null
	 * when write huge program,it will be collected auto.
	 * 
	 */
	public static void demo3() {
		{
			@SuppressWarnings("unused")
			byte[] placeholder = new byte[64 * _1MB];
			// placeholder=null;
		}
		@SuppressWarnings("unused")
		int a = 0;
		System.gc();
	}
}
