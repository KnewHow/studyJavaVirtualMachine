package chapter09_day01_classloader.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ManWaiterHandler implements InvocationHandler {

	private ManWaiter mamWaiter;

	public ManWaiterHandler(ManWaiter mamWaiter) {
		super();
		this.mamWaiter = mamWaiter;
	}

	public ManWaiter getMamWaiter() {
		return mamWaiter;
	}

	public void setMamWaiter(ManWaiter mamWaiter) {
		this.mamWaiter = mamWaiter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("welcome");
		return method.invoke(this.getMamWaiter(), args);
	}

	public Object getProxyObjext() {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.getMamWaiter().getClass().getInterfaces(),
				this);
	}

}
