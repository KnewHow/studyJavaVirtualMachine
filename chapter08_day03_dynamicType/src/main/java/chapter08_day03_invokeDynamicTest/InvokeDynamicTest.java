package chapter08_day03_invokeDynamicTest;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Demo invokedynamic introduce
 * 
 * @author ygh Jun 20, 2017
 */
public class InvokeDynamicTest {

	public static void main(String[] args) throws Throwable {
		INDY_BootStrapMethod().invoke("ygh");
	}

	public static void testMethod(String s) {
		System.out.println("hello String:" + s);
	}

	/**
	 * A method to get a method <code>{@link CallSite}</code>,in this method,we
	 * will use {@link ConstantCallSite} to implement it.
	 * 
	 * @param lookup
	 *            The {@link MethodHandles.Lookup} factory
	 * @param name
	 *            The name of the method which hoped to get
	 * @param mt
	 *            The method type of the method
	 * @return A {@link CallSite} of the method
	 * @throws Throwable
	 */
	public static CallSite BootStrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
		Class<? extends Object> clazz = lookup.lookupClass();
		return new ConstantCallSite(lookup.findStatic(clazz, name, mt));
	}

	/**
	 * A method to get
	 * {@linkplain InvokeDynamicTest#BootStrapMethod(java.lang.invoke.MethodHandles.Lookup, String, MethodType)}
	 * method type,but we use byte code descriptor to describe it.
	 * 
	 * @return
	 */
	private static MethodType MT_BootStrapMethod() {
		return MethodType.fromMethodDescriptorString(
				"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
				null);
	}

	private static MethodHandle MH_BootStrapMethod() throws Throwable {
		return MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootStrapMethod", MT_BootStrapMethod());
	}

	private static MethodHandle INDY_BootStrapMethod() throws Throwable {
		CallSite cs = (CallSite) MH_BootStrapMethod().invokeWithArguments(MethodHandles.lookup(), "testMethod",
				MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
		return cs.dynamicInvoker();
	}

}
