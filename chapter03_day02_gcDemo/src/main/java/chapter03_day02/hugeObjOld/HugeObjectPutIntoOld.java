package chapter03_day02.hugeObjOld;

/**
 * We know JVM use Copying algorithms to collect memory So it is bad message to
 * put huge size objects to it and those objects life time is transient. Because
 * If the memory don't enough JVM will copy those huge objects,this operation
 * will take much time. We avoid to do this. One method is to put huge object
 * whose size more than maximal threshold,we will put it directed into old
 * generation.
 * 
 * setting threshold of maximal object,it a object size more than it it will be
 * put into old generation directed. Use bytes as unit,but this JVM arguments
 * will in Serial and ParNew GC. In service,we can use it in ParNew+CMS.But in
 * JDK8,I don't see this arguments in JAVA DOC,but it still can be used in JDK8
 * environment.
 * 
 * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3148728
 * 
 * common JVM arguments: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * 
 * -XX:+UseConcMarkSweepGC：ParNew+CMS+Serial Old
 * 
 * -XX:+UseSerialGC:Serial + Serial Old
 * 
 * 
 * @author ygh Jun 11, 2017
 */
public class HugeObjectPutIntoOld {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}
}
