package chapter07_classInitialize_day01.demo4;

/**
 * A class to test static constructor code and static constructor code
 * 
 * @author ygh Jun 18, 2017
 */
public class Demo4 {

	public static void main(String[] args) {
		System.out.println(Child.value);

		System.out.println(new Child());

		/**
		 * run result: parent static constructor//load Class Parent
		 * 
		 * 123
		 * 
		 * child static construtor //load Class Child
		 * 
		 * parent constructor //constructor Class Parent
		 * 
		 * child construtor //Constructor Class child
		 * 
		 * chapter07_classInitialize_day01.demo4.Child@15db9742
		 * 
		 * we know the Class<T> is be cached in method area
		 * 
		 */
	}
}

class Parent {
	static {
		System.out.println("parent static constructor");
	}
	public static int value = 123;

	public Parent() {
		super();
		System.out.println("parent constructor");
	}

}

class Child extends Parent {
	static {
		System.out.println("child static construtor");
	}

	public Child() {
		super();
		System.out.println("child construtor");
	}

}