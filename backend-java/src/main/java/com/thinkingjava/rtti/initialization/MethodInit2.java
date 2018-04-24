package com.thinkingjava.rtti.initialization;

//: initialization/MethodInit2.java
public class MethodInit2 {
	int i = f();
	int j = g(i);
	
	int g(int n) {
		return n * 10;
	}
	int f() {
		return 11;
	}
} // /:~