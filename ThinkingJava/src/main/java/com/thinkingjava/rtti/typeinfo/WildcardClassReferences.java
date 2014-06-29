package com.thinkingjava.rtti.typeinfo;
/*
 * 泛化
 */
public class WildcardClassReferences {
	
	public static void main(String[] args){
		
		Class<?> intClass = int.class;
		
		intClass = double.class;
	}
}
