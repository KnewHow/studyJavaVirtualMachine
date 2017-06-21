package dynamic.proxy.demo5;

import org.junit.Test;

public class Demo5 {

	@Test
	public void fun1(){
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}
