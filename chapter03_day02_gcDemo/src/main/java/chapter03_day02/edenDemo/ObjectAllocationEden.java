package chapter03_day02.edenDemo;

/**
 * In this case,we will allocate object in Eden Region at young generation to
 * show Minor GC. First we specifies the maximum 20M size (in bytes) of the
 * memory allocation pool in bytes with arguments "-Xmx20". We initialize heap
 * memory 20M with arguments "-Xms20M", then allocate this memory to young
 * generation 10M with arguments "-Xmn10M". Then will set the ratio between Eden
 * space size and survivor is 8 with arguments "XX:SurvivorRatio=8". We also to
 * choose the type of GC use arguments "-XX:UseXXX". At the end,we need add
 * following arguments before run JVM, then analysis the GC log
 * 
 * JVM Arguments: -verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * 
 * Choose GC
 * 
 * System default is :Parallel Scavenge+Parallel Old
 * 
 * -XX:+UseConcMarkSweepGC：ParNew+CMS+Serial Old
 * 
 * -XX:+UseSerialGC:Serial + Serial Old
 * 
 * -XX:+UseG1GC :Garbage-First
 * 
 * @author ygh Jun 10, 2017
 */
public class ObjectAllocationEden {

	private static final int _1MB = 1024*1024;

	public static void main(String[] args) {
		testAllocation();
	}

	public static void testAllocation() {
		@SuppressWarnings("unused")
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}
}
