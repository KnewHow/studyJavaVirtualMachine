package chapter07_classLoader_day01.demo3;

/**
 * Show reference class constant don't initialize a class
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo3 {
	public static void main(String[] args) {
		/**
		 * executing result is "123",but if you change <code>int</code> into
		 * <code>Integer</code>, it will initialize <code>ConstantClass</code>
		 * 
		 */
		System.out.println(ConstantClass.value);
	}
}
