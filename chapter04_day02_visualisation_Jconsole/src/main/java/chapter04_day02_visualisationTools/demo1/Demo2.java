package chapter04_day02_visualisationTools.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A class to demo visualization listener for jconsole tool. This case is to
 * demo thread wait in different ways. We will write two method to implement
 * endless-loop thread and wait thread which not be notified
 * 
 * @author ygh Jun 13, 2017
 */
public class Demo2 {
	/**
	 * A method to simulate busy thread
	 */
	public static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true)
					;
			}
		}, "testBusyThread");
		thread.start();
	}

	/**
	 * A method is to simulate wait thread
	 * 
	 * @param lock
	 */
	public static void createLockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}, "testLockThread");
		thread.start();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		createLockThread(new Object());
	}
}
