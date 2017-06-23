package chapter09_day01_classloader.demo1;

import java.util.ArrayList;
import java.util.List;

import chapter09_day01_classloader.demo2.Father;

public class Demo1 {
	public static void main(String[] args) {
		List<Father> fatherList = new ArrayList<Father>();
		Father f = new Father();
		fatherList.add(f);
		f.thinking();
		System.out.println(fatherList.toString());
	}
}
