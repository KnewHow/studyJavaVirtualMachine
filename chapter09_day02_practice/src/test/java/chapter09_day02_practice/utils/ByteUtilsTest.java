package chapter09_day02_practice.utils;

import java.util.Arrays;

import org.junit.Test;

public class ByteUtilsTest {

	@Test
	public void test() {
		byte[] b = ByteUtils.intToBytes(1001, 2);
		System.out.println(Arrays.toString(b));
		System.out.println(ByteUtils.bytesToInt(b, 0, 2));
	}

	@Test
	public void test2() {
		System.out.println(1001 & 0xff);
	}

}
