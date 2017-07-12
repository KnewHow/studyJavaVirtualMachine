package chapter10_compiler_day01.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * The class show 
 * @author ygh
 * Jul 11, 2017
 */
public class Demo1 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("hello", "你好");
		map.put("how are you", "吃了吗");
		System.out.println(map.get("hello"));
		System.out.println(map.get("how are you"));
	}
}
