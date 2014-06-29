package com.thinkingjava.rtti.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwei
 * @info
 * (1) newInstance() 需要无参构造器
 */
class CountedInteger{
	private static long counter;
	private final long id = counter ++ ;
	@Override
	public String toString() {
		return "CountedInteger [id=" + id + "]";
	}
}

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type = type;
	}
	public List<T> create(int nElements){
		List<T> result = new ArrayList<T>();
		try {
			for(int i=0;i < nElements;i ++){
				result.add(type.newInstance());
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args){
		FilledList<CountedInteger> fl = 
				new FilledList<CountedInteger>(CountedInteger.class);
		
		System.out.println(fl.create(15));
	}
}


