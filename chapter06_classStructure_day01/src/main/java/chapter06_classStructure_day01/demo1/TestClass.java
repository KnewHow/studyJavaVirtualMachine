package chapter06_classStructure_day01.demo1;

/**
 * A class to show the {@link Class} structure
 * 
 * @author ygh Jun 16, 2017
 */
public class TestClass {
	private int m;

	public int inc() {
		int x;
		try {
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}
	}
}
