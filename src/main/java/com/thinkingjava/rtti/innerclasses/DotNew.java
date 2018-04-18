package com.thinkingjava.rtti.innerclasses;

//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

public class DotNew {
	public class Inner {
	}

	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
	}
} // /:~


/**
 * 创建内部类对象，必须使用外部类对象来创建该内部类，而不是去引用外部类的名字。
 */
