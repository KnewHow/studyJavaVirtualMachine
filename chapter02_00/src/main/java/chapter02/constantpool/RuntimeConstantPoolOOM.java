package chapter02.constantpool;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to show the JVM run time constant pool <code>OutOfMemoryError</code>
 * We will use {@link String#intern()} to demo
 * 
 * JVM arguments:-XX:PermSize=10M -XX:MaxPermSize=10M
 * But XX:PermSize=10M has been deprecated in JDK 8,and superseded by the -XX:MetaspaceSize
 * option.So the current arguments is following:
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * 
 * @author ygh 2017年6月4日
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i=0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
