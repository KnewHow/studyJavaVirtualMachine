package chapter04_day01_tools.HSDIS;

/**
 * 
 * @author ygh
 * Jun 13, 2017
 * JVM arguments:-verbose:-XX:+UnlockDiagnosticVMOptions -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum test.Bar
 */
public class Bar {
	int a=1;
	static int b=2;
	public int sum(int c){
		return a+b+c;
	}
	
	public static void main(String[] args) {
		new Bar().sum(3);
	}
}
