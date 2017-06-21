package chapter07_classLoader_day01.demo2;
/**
 * A super class
 * 
 * @author ygh Jun 17, 2017
 */
public class SubperClass {
	static {
		System.out.println("super class initialize");
	}
	public  int key = 123;
	public static int value = 123;
}