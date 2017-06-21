package chapter08_day01_ClassParse.parseDemo;

/**
 * A class to show how many types methods which can be referenced directly at
 * Class parse moment. We know,if use following instructions to call a
 * method,the method can be referenced directly at parse moment. Let's to test
 * some different types methods
 * 
 * @author ygh Jun 18, 2017
 */
public class Demo1 {

	static{
		System.out.println("static code");
	}
	/**
	 * A constructor of super class
	 */
	public Demo1() {
		super();
	}

	/**
	 * A static method in self class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		sayHello();
	}

	public void caller() {
		privateMethod();
		finalMethod();
	}

	/**
	 * A static method in self class
	 */
	public static void sayHello() {
		System.out.println("say hello");
	}

	private void privateMethod() {
		System.out.println("this just a private method");
	}

	/**
	 * A final method
	 */
	public final void finalMethod() {
		System.out.println("a final mehtod");
	}

	/**
	 * From "javap -verbose Demo1.class" get participate code 1: invokespecial
	 * #1 // Method java/lang/Object."<init>":()V
	 * 
	 * 0: invokestatic #2 // Method sayHello:()V
	 * 
	 * 1: invokespecial #3 // Method privateMethod:()V
	 * 
	 * 5: invokevirtual #4 // Method finalMethod:()V
	 * 
	 * From above information,we can prove that static method,private
	 * method,final method and parent method and self constructor method can be
	 * referenced directly when parse class
	 */
}
