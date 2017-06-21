package dynamic.proxy.demo4;

import org.junit.Test;

public class Demo4 {

	@Test
	public void fun1() {
		Waiter waiter = new ManWaiter();
		BeforeAdvice beforeAdvice = new BeforeAdvice() {
			@Override
			public void before() {
				System.out.println("您好");
			}
		};

		AfterAdvice afterAdvice = new AfterAdvice() {
			@Override
			public void after() {
				System.out.println("再见");
			}
		};
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setBeforeAdvice(beforeAdvice);
		proxyFactory.setTargetObject(waiter);
		proxyFactory.setAfterAdvice(afterAdvice);
		Waiter proxyObject = (Waiter) proxyFactory.getProxyObject();
		proxyObject.service();
	}
}
