package chapter09_day02_practice.implement;

import java.io.FileInputStream;
import java.io.InputStream;

import chapter09_day02_practice.utils.JavaClassExecuter;

/**
 * 
 * @author ygh Jun 24, 2017
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/home/ygh/TestClass.class");
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		JavaClassExecuter.execute(b);
	}
}
