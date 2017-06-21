package dynamic.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * A class to show dynamic proxy
 * 
 * @author ygh Jun 8, 2017
 */
public class Demo1 {

	/**
	 * View which system class loader:sun.misc.Launcher$AppClassLoader
	 * 
	 * 
	 */
	@Test
	public void fun1() {
		System.out.println(Demo1.class.getClassLoader().getClass().getName());
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
		/*
		 * Result of above code: sun.misc.Launcher$AppClassLoader
		 * sun.misc.Launcher$AppClassLoader
		 */
	}

	/**
	 * Demo how to create a proxy object We use the
	 * {@link Proxy #newProxyInstance(ClassLoader, Class[], java.lang.reflect.InvocationHandler)}
	 * to create a proxy object, but we need three parameters
	 * {@link ClassLoader} {@link Class[]} {@link InvocationHandler}
	 * 
	 * <code>{@link ClassLoader}</code> we know is a loader to load class from
	 * dish into memory.For example it can load a class file A.class into
	 * Class<A> in JVM memory(mthod area),you can get it by any Java Class
	 * {@link Class#getClassLoader()}
	 * 
	 * 
	 * <code>{@link Class[]} interfaces</code> A array of interface which the
	 * created class will implement. We can get it easily
	 * 
	 * <code>{@link InvocationHandler} h</code> we interfaces first
	 */

	@Test
	public void fun2() {
		ClassLoader loader = this.getClass().getClassLoader();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = { A.class, B.class };
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Hello Dynamic Proxy");
				return null;
			}
		};
		Object obj = Proxy.newProxyInstance(loader, interfaces, h);

		System.out.println(obj instanceof A);// true
		System.out.println(obj instanceof B);// true
		/**
		 * Above result indicate we has get a Object that implement interface A
		 * and B.But this class don't has obj.class file.it is create by proxy.
		 */

		A a = (A) obj;
		B b = (B) obj;
		/**
		 * Execute <code>invoke</code> method
		 */
		a.a();
		b.b();
		a.hashCode();
		/**
		 * Don't execute <code>invoke</code> method You can read official doc to
		 * get details
		 */
		a.getClass();
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
