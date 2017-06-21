package chapter02.JVMorNativeStackError;

/**
 * A class to test JVM <code>StackOverflowError</code> and
 * <code>OutOfMemoryError</code> We know JVM will throw stack over flow when
 * application recurse too deeply. We also know JVM will throw out of memory
 * error when not enough memory to expand stack.
 * 
 * We know JVM stack and native stack is thread owns privately. So we can create
 * many thread to consume stack memory to simulate really environment.
 * 
 * JVM arguments:-Xss 2M let each thread have 2 MB stack memory and produce many
 * thread to consume all stack memory
 * 
 * @author ygh 2017年6月4日
 */
public class JVMStackOFEDemo2 {
	private int threadCounter = 0;

	public static void main(String[] args) {
		JVMStackOFEDemo2 oom = new JVMStackOFEDemo2();
		try {
			oom.stackLeakByThread();
		} catch (Throwable e) {
			System.out.println("thread amount:" + oom.threadCounter);
		}
	}

	/**
	 * A method to create thread endless 
	 */
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
			threadCounter++;
		}
	}

	/**
	 * each thread execute method, in this case 
	 * each thread need to do a endless loop to 
	 * keep thread active
	 */
	public void dontStop() {
		while (true) {

		}
	}
}
