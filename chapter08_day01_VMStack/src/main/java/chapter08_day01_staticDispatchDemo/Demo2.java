package chapter08_day01_staticDispatchDemo;

import java.io.Serializable;

/**
 * Show reload priority
 * 
 * @author ygh Jun 18, 2017
 */
public class Demo2 {
	/**
	 * We will comment out the method which this time has been called The
	 * execute priorities: hello char!
	 * 
	 * hello int!
	 * 
	 * hello long!
	 * 
	 * hello Character!
	 *
	 * hello Serializable!
	 * 
	 * hello char...!
	 * 
	 * If appear two super interface such as <code>Serializable</code> and
	 * <code>Comparable<Character></code> the compiler will produce ee The
	 * method sayHello(Serializable) is ambiguous for the type Demo2
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		sayHello('a');
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(char arg) {
		System.out.println("hello char!");
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(int arg) {
		System.out.println("hello int!");
	}

	/**
	 * A reload method
	 * 
	 * @param arg
	 */
	public static void sayHello(long arg) {
		System.out.println("hello long!");
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(Character arg) {
		System.out.println("hello Character!");
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(Serializable arg) {
		System.out.println("hello Serializable!");
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(Comparable<Character> arg) {
		System.out.println("hello Serializable!");
	}

	/**
	 * A reload method
	 *
	 * @param arg
	 */
	public static void sayHello(char... arg) {
		System.out.println("hello char...!");
	}

}
