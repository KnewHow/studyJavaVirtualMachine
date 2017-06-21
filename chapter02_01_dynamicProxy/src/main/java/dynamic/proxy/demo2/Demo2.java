package dynamic.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * A class to show dynamic proxy
 * 
 * @author ygh Jun 8, 2017
 */
public class Demo2 {

	/**
	 * Show the relationship between interface method and invoke method
	 */
	@Test
	public void fun1() {
		ClassLoader loader = this.getClass().getClassLoader();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = { A.class, B.class };
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Hello Dynamic Proxy");
				return "xxx";
				/**
				 * NullPointerException will be throw If interface method's
				 * return type is primitive,you can get details by official doc
				 */
				// return null;
			}
		};
		Object obj = Proxy.newProxyInstance(loader, interfaces, h);

		A a = (A) obj;
		Object result = a.show("show", 100);
		System.out.println(result);
	}

}

/**
 * A interface that let proxy class to implement it
 * 
 * @author ygh Jun 8, 2017
 */
interface A {
	/**
	 * Just a test method
	 */
	public void a();

	public int show(String str, Integer i);
}

/**
 * A interface that let proxy class to implement it
 * 
 * @author ygh Jun 8, 2017
 */
interface B {
	/**
	 * Just a test method
	 */
	public void b();
}
