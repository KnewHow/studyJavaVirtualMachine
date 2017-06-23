package chapter09_day02_practice.implement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class HackSystem {
	public final static InputStream in = System.in;
	private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	private static final PrintStream out = new PrintStream(buffer);
	
	public static String getBufferString(){
		return buffer.toString();
	}
	
	public static void cleanBuffer(){
		buffer.reset();
	}
	
}
