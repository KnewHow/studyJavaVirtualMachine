package chapter09_day02_practice.utils;

/**
 * A hot swap class loader to implement class loader when runtime
 * 
 * @author ygh Jun 23, 2017
 */
public class HotSwapClassLoader extends ClassLoader {

	public HotSwapClassLoader(ClassLoader parent) {
		super(HotSwapClassLoader.class.getClassLoader());
	}

	/**
	 * Load a Class by parent method,but we specify a byte array
	 * 
	 * @param classBytes
	 * @return
	 */
	public Class<?> loadClass(byte[] classBytes) {
		return defineClass(null, classBytes, 0, classBytes.length);
	}

}
