package chapter07_classLoader_day01.demo2;
/**
 * A sub class
 * @author ygh
 * Jun 17, 2017
 */
public class SubClass extends SubperClass {
	static {
		System.out.println("sub class initialize");
	}
}
