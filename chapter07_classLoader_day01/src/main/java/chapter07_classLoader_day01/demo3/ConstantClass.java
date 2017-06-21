package chapter07_classLoader_day01.demo3;

/**
 * A class which has a constant filed just for test
 * 
 * @author ygh Jun 17, 2017
 */
public class ConstantClass {

	static {
		System.out.println("ConstantClass initialize");
	}
	/**
	 * The modifier only be <code>int</code>. In compiler time,the variable will
	 * be transfered to <code>NoInitialization</code> pool,it don't have
	 * relationship with itself
	 */
	public static final 
	
	int value = 123;
}
