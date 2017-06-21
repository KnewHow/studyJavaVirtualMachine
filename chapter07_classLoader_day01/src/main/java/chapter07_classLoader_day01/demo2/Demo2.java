package chapter07_classLoader_day01.demo2;

/**
 * define a reference class by array that don't produce initialize action
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo2 {

	public static void main(String[] args) {
		/**
		 * Execute result:None,we can consider we just declare array,but there
		 * no object of <code>SubperClass</code> in it.
		 */
		@SuppressWarnings("unused")
		SubperClass[] sbs = new SubperClass[10];
	}
}
