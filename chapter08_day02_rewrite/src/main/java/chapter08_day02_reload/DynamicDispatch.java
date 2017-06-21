package chapter08_day02_reload;

/**
 * Show Java Reload
 * 
 * @author ygh Jun 19, 2017
 */
public class DynamicDispatch {

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}
}

/**
 * A abstract super class to show
 * 
 * @author ygh Jun 19, 2017
 */
abstract class Human {
	protected abstract void sayHello();
}

/**
 * Just a sub-class
 * 
 * @author ygh Jun 19, 2017
 */
class Man extends Human {

	@Override
	protected void sayHello() {
		System.out.println("Man say hello");
	}

}

/**
 * Just a sub class
 * 
 * @author ygh Jun 19, 2017
 */
class Woman extends Human {

	@Override
	protected void sayHello() {
		System.out.println("Woman say hello");
	}

}
