package chapter02.JVMorNativeStackError;

/**
 * A class to test JVM <code>StackOverflowError</code> and
 * <code>OutOfMemoryError</code> We know JVM will throw stack over flow when
 * application recurse too deeply. We also know JVM will throw out of memory
 * error when not enough memory to expand stack.
 * 
 * In this case, we will show a endless recursive method to consume all stack
 * memory to get test result.
 * 
 * @author ygh 2017年6月4日
 */
public class JVMStackOFEDemo1 {
	private int stackLength = 1;

	public static void main(String[] args) {
		JVMStackOFEDemo1 oom = new JVMStackOFEDemo1();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length:" + oom.stackLength);
			throw e;
		}
	}

	/**
	 * A method the construct an endless recursive method
	 */
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
}
