package chapter02.constantpool;
/**
 * A test of {@link String #intern()}
 * @author ygh
 * 2017年6月6日
 */
public class Demo {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern()==str2);
		
	}
}
