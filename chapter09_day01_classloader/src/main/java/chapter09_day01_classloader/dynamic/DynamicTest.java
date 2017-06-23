package chapter09_day01_classloader.dynamic;

public class DynamicTest {
	public static void main(String[] args) {
		ManWaiter manWaiter = new ManWaiter();
		Waiter waiter = (Waiter) new ManWaiterHandler(manWaiter).getProxyObjext();
		waiter.service();
		System.getProperties().put("sum.misc.ProxyGenerator.saveGeneratedFiles", true);
	}
}
