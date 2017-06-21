package chapter03_day02.TenuringThreshold;

/**
 * The JVM is not to move young generation objects to old generation each time.
 * If happen Minor GC,objects will be moved from Edue to Survivor in young
 * generation. At this region, There are many tenure counters to record every
 * objects tenure If one object tenure more maximal threshold,it will be moved
 * from generation to old generation. But if one object size is more than
 * Survivor size,it is also be move old generation because the Survivor don't
 * sore it enough.
 * 
 * We can use a JVM arguments to set the maximal threshold of tenure.
 * 
 * -XX:MaxTenuringThreshold=threshold
 * 
 * Sets the maximum tenuring(生存周期) threshold for use in adaptive GC sizing. The
 * largest value is 15. The default value is 15 for the
 * parallel(平行的)(throughput) collector(收集器), and 6 for the CMS collector.
 * (默认值是15对于吞吐量GC收集器，6是非常好的对于CMS收集器)
 * 
 * The following example shows how to set the maximum tenuring threshold to 10:
 * 
 * -XX:MaxTenuringThreshold=10
 * 
 * -XX:+PrintTenuringDistribution
 * 
 * -XX:+UseSerialGC:Serial + Serial Old
 * 
 * JVM common arguments:
 * 
 * common JVM arguments: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * 
 * @author ygh Jun 11, 2017
 */
public class TenuringThresholdDemo {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		/**
		 * trigger GC collect by deleting reference list
		 */
		allocation3 = null;
		/**
		 * TODO
		 */
		allocation3 = new byte[4 * _1MB];
	}
}
