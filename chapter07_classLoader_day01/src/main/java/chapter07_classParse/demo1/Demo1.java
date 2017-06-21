package chapter07_classParse.demo1;

/**
 * Show </<code>Class</code> parse when there are many same name field in super
 * class and interfaces
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo1 {
	public static void main(String[] args) {
		/**
		 * <code>Sub</code> will use itself <code>ClassLoader</code> to load the
		 * <code>A</code> filed
		 */
		System.out.println(Sub.A);
	}
}

interface Interface0 {
	int A = 0;
}

interface Interface1 {
	int A = 1;
}

interface Interface2 {
	int A = 2;
}

class Parent implements Interface1 {
	public static int A = 3;
}

class Sub extends Parent implements Interface2 {
	/**
	 * If followed code be deleted,parent class and interface have
	 * <code>A</code> filed at same time. At this moment, JVM compiler will give
	 * a "The field Sub.A is ambiguous" to indicate it refuse to compile this
	 * code.
	 */
	public static int A = 4;
}
