package chapter07_classInitialize_day01.demo1;

public class Demo1 {
	static {
		/**
		 * <code>clinit</code> is the code to execute static code and variable
		 * initialize in class.So we can initialize i,but don't access it.
		 */
		i = 2;
		// Sysstem.out.println(i);
	}

	static int i = 1;
}
