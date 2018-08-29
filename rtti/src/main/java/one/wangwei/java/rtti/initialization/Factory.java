package one.wangwei.java.rtti.initialization;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	
	public static final Factory instance = new  Factory();
	
	private final Map<String,Integer> map = new HashMap<String,Integer>();
	
	public Factory(){
		
		System.out.println("map=" + map);
		
		map.put("test1", 1);
		map.put("test2", 2);
		map.put("test3", 3);
	}
	
	public void testInit(){
		System.out.println("Test factory initialization!");
	}
	
	public static void main(String[] args){
		System.out.println(Factory.instance);
	}
}
