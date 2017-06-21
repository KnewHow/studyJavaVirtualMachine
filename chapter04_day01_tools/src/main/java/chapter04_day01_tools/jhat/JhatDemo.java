package chapter04_day01_tools.jhat;

import java.util.Map.Entry;

/**
 * 
 * @author ygh Jun 13, 2017
 */
public class JhatDemo {
	public static void main(String[] args) {
		for (Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
			Thread thread = stackTrace.getKey();
			StackTraceElement[] stacks = stackTrace.getValue();
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			System.out.println("\n线程： " + thread.getName() + "\n");
			for (StackTraceElement ele : stacks) {
				System.out.println(ele.toString());
			}
		}
	}
}
