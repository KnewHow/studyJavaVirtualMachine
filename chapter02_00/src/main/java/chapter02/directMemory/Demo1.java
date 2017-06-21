package chapter02.directMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class to show direct memory at the
 * Java Virtual Machine
 * @author ygh
 * 2017年6月3日
 */

public class Demo1 {

	/**
	 * These local parameters and method entrance will be store be stored the
	 * JVM stack.
	 */
	public void fun1(){
		Integer a=0;
		List<String> list = new ArrayList<String>();
		System.out.println(list.toString()+a);
	}
}
