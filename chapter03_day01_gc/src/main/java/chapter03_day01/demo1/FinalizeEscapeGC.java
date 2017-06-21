package chapter03_day01.demo1;

/**
 * Show <code>finalize</code> method self rescue and recovery
 * JVM arguments:-verbose:gc -XX:+PrintGCDetails
 * @author ygh Jun 9, 2017
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVA_HOOK = null;

	private final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	private byte[] bigSize = new byte[10 * _1MB];

	public void alive() {
		System.out.println("I am alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method is executing");
		FinalizeEscapeGC.SAVA_HOOK = this;
	}

	public static void main(String[] args) throws Exception {
		SAVA_HOOK = new FinalizeEscapeGC();
		/**
		 * The object will rescue itself at first time
		 */
		SAVA_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVA_HOOK != null) {
			SAVA_HOOK.alive();
		} else {
			System.out.println("I am dead!");
		}

		/**
		 * The object will rescue itself at second time
		 */
		SAVA_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVA_HOOK != null) {
			SAVA_HOOK.alive();
		} else {
			System.out.println("I am dead!");
		}

		/**
		 * Run result: finalize method is executing I am alive I am dead! JVM
		 * only call <code>finalize()</code> one time, Next time will pass this
		 * method
		 */

	}

}
