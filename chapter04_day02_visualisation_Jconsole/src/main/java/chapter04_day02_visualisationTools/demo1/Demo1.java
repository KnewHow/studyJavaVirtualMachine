package chapter04_day02_visualisationTools.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to demo visualization listener for jconsole tool. This case is to
 * demo memory in heap allocate and collect
 * 
 * JVM arguments:-verbose:-Xms100M -Xmx100M -XX:+UseSerialGC
 * 
 * @author ygh Jun 13, 2017
 */
public class Demo1 {
	/**
	 * A memory placeholder object that takes 64KB
	 */
	public byte[] placeholder = new byte[64 * 1024];

	/**
	 * A method to fill heap memory
	 * 
	 * @param num
	 * @throws Exception
	 */
	public static void fillHeap(int num) throws Exception {
		List<Demo1> list = new ArrayList<Demo1>();
		for (int i = 0; i < num; i++) {
			/**
			 * Delay to produce better graph in jconsole tool
			 */
			Thread.sleep(50);
			list.add(new Demo1());
		}
		System.gc();
	}

	public static void main(String[] args) throws Exception {
		fillHeap(1000);
		System.gc();
	}
}
