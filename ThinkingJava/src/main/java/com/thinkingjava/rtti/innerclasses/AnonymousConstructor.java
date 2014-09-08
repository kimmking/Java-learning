package com.thinkingjava.rtti.innerclasses;

//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.
import static net.mindview.util.Print.*;

abstract class Base {
	public Base(int i) {
		print("Base constructor, i = " + i);
	}

	public abstract void f();
}

/**
 * i 不要求final，因为i被传递给匿名类的基类的构造器，
 * 它并不会在匿名内部类被直接使用。
 * @author wangwei
 */
public class AnonymousConstructor {
	public static Base getBase(int i) {
		return new Base(i) {
			{
				print("Inside instance initializer");
			}

			@Override
			public void f() {
				print("In anonymous f()");
			}
		};
	}

	public static void main(String[] args) {
		Base base = getBase(47);
		base.f();
	}
} /*
 * Output: Base constructor, i = 47 Inside instance initializer In anonymous f()
 */// :~
