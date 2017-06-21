package chapter08_day02_reload.singleDispatch;



public class SingleDispatch {
	public static void main(String[] args) {
		/**
		 * From this program,we know at compile moment, compiler can location
		 * which method will be call. but compiler don't know who is the method
		 * recover. This is reload
		 * 
		 * At run time,JVM don't care which method will be call, it just care
		 * who is the method recover. This is rewrite
		 * 
		 * We know Java is single dispatch today.
		 * 
		 */
		Father father = new Father();
		Father son = new Son();
		father.hardChoose(new _360());
		son.hardChoose(new QQ());
	}
}

/**
 * A super class to show ploymorphism
 * 
 * @author ygh Jun 19, 2017
 */
class Father {
	public void hardChoose(QQ arg) {
		System.out.println("Father choose QQ");
	}

	public void hardChoose(_360 arg) {
		System.out.println("Father choose 360");
	}
}

/**
 * A sub class to show ploymorphism
 * 
 * @author ygh Jun 19, 2017
 */
class Son extends Father {
	public void hardChoose(QQ arg) {
		System.out.println("Son choose QQ");
	}

	public void hardChoose(_360 arg) {
		System.out.println("Son choose 360");
	}
}

/**
 * Just a test class
 * 
 * @author ygh Jun 19, 2017
 */
class QQ {

}

/**
 * Just a test class
 * 
 * @author ygh Jun 19, 2017
 */
class _360 {

}
