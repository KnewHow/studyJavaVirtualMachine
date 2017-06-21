package chapter04_day03_visualVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A class to test Btrace to implement two random number which is between 0-1000
 * then print the sum
 * 
 * @author ygh Jun 14, 2017
 */
public class BTraceTest {

	public static void main(String[] args) throws Exception {
		BTraceTest test = new BTraceTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			reader.readLine();
			int a = (int) Math.round(Math.random() * 1000);
			int b = (int) Math.round(Math.random() * 1000);
			System.out.println(test.plus(a, b));
		}
	}

	public int plus(int a, int b) {
		return a + b;
	}
}
