package chapter07_classInitialize_day01.demo3;

/**
 * Show <code>clinit</code> code thread safe
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo3 {
	public static void main(String[] args) {
		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " start");
				@SuppressWarnings("unused")
				DeadLoopClass dic = new DeadLoopClass();
				System.out.println(Thread.currentThread().getName() + " end");
			}
		};

		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		t1.start();
		t2.start();
		/**
		 * Executing result:
		 * 
		 * Thread-0 start
		 * 
		 * Thread-1 start
		 * 
		 * Thread-0 initialize DeapLoopClass
		 * 
		 * A class <code>clinit</code> is thread safe
		 */
	}
}

class DeadLoopClass {
	static {
		if (true) {
			System.out.println(Thread.currentThread().getName() + " initialize DeapLoopClass");
			while (true)
				;
		}
	}
}
