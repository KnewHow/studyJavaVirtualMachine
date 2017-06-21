package dynamic.proxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
/**
 * Show dynamic proxy,now we need to add some polite greet before
 * service and after service
 * @author ygh
 * Jun 8, 2017
 */
public class Demo3 {

	@Test
	public void fun1(){
		/**
		 * Target Object that we need advice
		 */
		Waiter manWaiter = new ManWaiter();
		ClassLoader loader = this.getClass().getClassLoader();
		@SuppressWarnings("rawtypes")
		Class[] interfaces={Waiter.class};
		InvocationHandler h = new WaiterInvocationHandler(manWaiter);
		/**
		 * Proxy object we get by Dynamic Proxy
		 */
		Waiter manWaiterProxy = (Waiter) Proxy.newProxyInstance(loader, interfaces, h);
		/**
		 * Run Proxy object's enhance methodF
		 */
		manWaiterProxy.service();
	}
}
