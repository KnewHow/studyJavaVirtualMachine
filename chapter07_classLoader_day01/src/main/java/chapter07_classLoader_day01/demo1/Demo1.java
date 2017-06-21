package chapter07_classLoader_day01.demo1;

/**
 * Show caller super class static filed don't let sub class initialize
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo1 {
	public static void main(String[] args) {
		/**
		 * Run result:super class initialize
		 */
		System.out.println(SubClass.value);
	}
}
