package chapter02.heapOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to show the heap dump <code>OutOfMemoryError</code> We know when the
 * JVM don't enough memory to allocate object and can not expand,it will throw
 * the <code>OutOfMemoryError</code>.So we create object constantly then it will
 * take up all memory
 * @author ygh 2017年6月3日
 */
public class HeapOOF {
	/**
	 * A ordinary {@link #main(String[])} method
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
 * A Class as the variable of the <code>List</code> to take up all memory in JVM heap
 * 
 * @author ygh 2017年6月3日
 */
class OOMObject {

}
