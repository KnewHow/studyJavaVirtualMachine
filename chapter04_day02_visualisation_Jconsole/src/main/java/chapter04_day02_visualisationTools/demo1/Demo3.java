package chapter04_day02_visualisationTools.demo1;

/**
 * A class to demo visualization listener for jconsole tool. This case is to
 * demo thread dead lock
 * 
 * @author ygh Jun 13, 2017
 */
public class Demo3 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {

			/**
			 * 下面的代码会产生死锁，产生死锁的原因不是因为，1,2相互颠倒，而是 Integer.valueOf(a)
			 * 这个方法当参数[-128,127]之间时，会缓存对象。多次
			 * 调用Integer.valueOf(2)，返回的其实是一个对象，所以会产生死锁。但是a的值超过了
			 * 这范围，那么每次返回一个新的对象，那么就不存在锁的问题了
			 */
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
			/**
			 * 下面的代码不会产生死锁
			 */
//			new Thread(new SynAddRunable(255, 299)).start();
//			new Thread(new SynAddRunable(299, 255)).start();
		}
	}
}

class SynAddRunable implements Runnable {

	int a, b;

	public SynAddRunable(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a + b);
			}
		}
	}

}
