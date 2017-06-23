package chapter09_day01_classloader.demo2;

import java.util.ArrayList;
import java.util.List;

import chapter09_day01_classloader.demo1.Demo1;

public class Father {
	public static void main(String[] args) {
		List<Demo1> list = new ArrayList<Demo1>();
		list.add(new Demo1());
	}

	public void thinking() {
		System.out.println("thinking");
	}

}
