package chapter02.methodArea;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Test JVM method area <code>OutOfMemoryError</code> We know the method area is
 * to store the information of class. Such as class name,modifier of
 * accessing,constant pool,field describe,method describe and so on. So if we
 * want to make JVM produce <code>OutOfMemoryError</code>, we should make lots
 * of object instance to full with its memory
 * 
 * XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * 
 * @author ygh 2017年6月6日
 */
public class JVMMethodAreaOOM {
	public static void main(String[] args) {
		createObjectEndless2();
	}

	public static void createObjectEndless1() {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

	public static void createObjectEndless2() {
		final int i=0;
		while (true) {
			Waiter waiter = new ManWaiter();
			ProxyFactory factory = new ProxyFactory();
			BeforeAdvice beforeAdvice = new BeforeAdvice() {
				
				@Override
				public void before() {
					System.out.println("before"+i);
				}
			};
			
			AfterAdvice afterAdvice = new AfterAdvice() {
				
				@Override
				public void after() {
					System.out.println("after"+i);
				}
			};
			factory.setBeforeAdvice(beforeAdvice);
			factory.setTargetObject(waiter);
			factory.setAfterAdvice(afterAdvice);
			Waiter proxyObject = (Waiter) factory.getProxyObject();
			proxyObject.service();
		}
	}
}

class OOMObject {

}

interface Waiter{
	public void service();
}


class ManWaiter implements Waiter{

	@Override
	public void service() {
		System.out.println("Man Service....");
	}
	
}