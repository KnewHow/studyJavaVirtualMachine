package chapter09_day02_practice.utils;

import java.lang.reflect.Method;

import chapter09_day02_practice.implement.HackSystem;

/**
 * A tool of Java Class execute tool
 * 
 * @author ygh Jun 24, 2017
 */
public class JavaClassExecuter {
	/**
	 * Execute a class <code>main</code> method,replace {@link System} class by
	 * self define class
	 * 
	 * @param classByte
	 * @return
	 */
	public static String execute(byte[] classByte) {
		HackSystem.cleanBuffer();
		ClassModifier cm = new ClassModifier(classByte);
		byte[] modifyBytes = cm.modifyUTF8Constant("java/lang/System", "chapter09_day02_practice/implement/HackSystem");
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class<? extends Object> clazz = loader.loadBytes(modifyBytes);
		try {
			Method method = clazz.getMethod("main", new Class[] { String[].class });
			method.invoke(null, new Object[] { null });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HackSystem.getBufferString();

	}
}
