package dynamic.proxy.demo3;

/**
 * A implement for waiter 
 * @author ygh
 * Jun 8, 2017
 */
public class ManWaiter implements Waiter {

	@Override
	public void service() {
		System.out.println("Man waiter service...");
	}

}
