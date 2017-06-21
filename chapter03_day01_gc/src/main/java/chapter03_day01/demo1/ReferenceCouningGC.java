package chapter03_day01.demo1;
/**
 * Show what way the JVM GC,is Reference counting?
 * JVM arguments:-verbose:gc -XX:+PrintGCDetails
 * @author ygh
 * Jun 9, 2017
 */
public class ReferenceCouningGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;
	/**
	 * A bytes array just to take up some memory
	 */
	@SuppressWarnings("unused")
	private byte[] bigSize = new byte[_1MB * 2];

	public static void main(String[] args) {
		testGC();
	}

	public static void testGC() {
		ReferenceCouningGC objA = new ReferenceCouningGC();
		ReferenceCouningGC objB = new ReferenceCouningGC();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		System.gc();
		/*
		 * PSYoungGen: 4731K->384K(18432K)] indicate objA and objB
		 * has been recovery
		 */
	}
}
