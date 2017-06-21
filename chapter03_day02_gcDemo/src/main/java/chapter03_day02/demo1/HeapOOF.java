package chapter03_day02.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to show the heap dump <code>OutOfMemoryError</code> that use
 * different GCs.
 * 
 * System default is :Parallel Scavenge+Parallel Old
 * 
 * -XX:+UseConcMarkSweepGC：ParNew+CMS+Serial Old
 * 
 *  -XX:+UseSerialGC:Serial + Serial Old
 *  
 *  -XX:+UseG1GC :Garbage-First
 *  
 *  You can get detail information from gc.log
 * 
 * @author ygh 2017年6月3日
 */
public class HeapOOF {
	/**
	 * A ordinary {@link #main(String[])} method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}

/**
 * A Class as the variable of the <code>List</code> to take up all memory in JVM
 * heap
 * 
 * @author ygh 2017年6月3日
 */
class OOMObject {

}
