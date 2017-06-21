package dynamic.proxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WaiterInvocationHandler implements InvocationHandler {

	private Waiter waiter;

	public WaiterInvocationHandler(Waiter waiter) {
		super();
		this.waiter = waiter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Hello!");
		/**
		 * Target method
		 */
		this.waiter.service();
		System.out.println("See you!");
		return null;
	}

}
