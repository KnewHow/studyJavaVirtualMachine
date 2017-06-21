package chapter07_classLoader_day01.demo4;

import java.io.IOException;
import java.io.InputStream;

/**
 * Show {@link ClassLoader} principle and some tests
 * 
 * @author ygh Jun 17, 2017
 */
public class Demo4 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = myClassLoader.loadClass("chapter07_classLoader_day01.demo4.Demo4");
		System.out.println(obj.getClass());
		System.out.println(obj instanceof chapter07_classLoader_day01.demo4.Demo4);
	}
}
