package chapter08_day03_dynamicType;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodHandleTest {

	public static void main(String[] args) throws Throwable {

		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new A();
		System.out.println(obj.getClass());
		System.out.println(getPrintlnMH(obj));
		getPrintlnMH(obj).invokeExact("ygh");

		// while (true) {
		// Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new
		// A();
		// System.out.println(obj.getClass());
		// reflection(obj).invoke(obj, "ygh");
		// }

	}

	/**
	 * Get a method handler of <code>println</code>
	 * 
	 * @param reveiver
	 *            A instance of A
	 * @return A method handler of println
	 * @throws Exception
	 */
	public static MethodHandle getPrintlnMH(Object reveiver) throws Exception {
		MethodType mt = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
	}

	/**
	 * Get a method reflection object
	 * 
	 * @param receiver
	 *            A instance of A
	 * @return A method reflection object
	 * @throws Exception
	 */
	public static Method reflection(Object receiver) throws Exception {
		Method method = receiver.getClass().getMethod("println", String.class);
		return method;
	}
}

class A {
	public void println(String s) {
		System.out.println(s);
	}
}
