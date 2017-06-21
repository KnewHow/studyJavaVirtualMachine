package chapter02.directMemory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Test the direct memory <code>OutOfMemoryError</code>
 * VM argument：-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author ygh 2017年6月6日
 */
public class DirectMemoryOOM {
	private static final long _1MB = 1024 * 1024;

	public static void main(String[] args) throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}
}
