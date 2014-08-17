package com.thinkingjava.rtti.initialization;

//: initialization/StaticInitialization.java
//Specifying initial values in a class definition.
import static net.mindview.util.Print.*;

class Bowl {
	Bowl(int marker) {
		print("Bowl(" + marker + ")");
	}

	void f1(int marker) {
		print("f1(" + marker + ")");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1);

	Table() {
		print("Table()");
		bowl2.f1(1);
	}

	void f2(int marker) {
		print("f2(" + marker + ")");
	}

	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);

	Cupboard() {
		print("Cupboard()");
		bowl4.f1(2);
	}

	void f3(int marker) {
		print("f3(" + marker + ")");
	}

	static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
	public static void main(String[] args) {
		print("Creating new Cupboard() in main");
		new Cupboard();
		print("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}

	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
	
} 
/*
 * Output: 
 * Bowl(1) 
 * Bowl(2) 
 * Table()
 * f1(1) 
 * Bowl(4) 
 * Bowl(5) 
 * Bowl(3) 
 * Cupboard()
 * f1(2) 
 * Creating new Cupboard() in main 
 * Bowl(3) 
 * Cupboard() 
 * f1(2) 
 * Creating new
 * Cupboard() in main 
 * Bowl(3) 
 * Cupboard() 
 * f1(2) 
 * f2(1) 
 * f3(1)
 * 
 * 
 * (1) 无论创建多少个对象，静态数据都只占用一份存储区域；
 * (2) 静态初始化只有在必要的时刻才会进行，第一次初始化后，将不再初始化；
 * (3) 初始化的顺序是先静态对象，而后“非静态”对象；
 * 
 * 
 * 对象的创建过程，假设有个名为Dog的类：
 * 1、即使没有显示地使用static关键字，构造器实际上也是静态方法。
 *   因此当首次创建类型为Dog的对象时，或者Dog类的静态方法/静态域首次被访问时，
 *   Java解释器必须查找类路径，以定位Dog.class文件；
 * 2、然后载入Dog.class文件，这将创建一个class对象，有关静态初始化的所有动作都会执行。
 * 	 因此，静态初始化只在class对象首次加载的时候进行一次；
 * 3、当用new Dog()创建对象的时候，首先将在堆上为Dog分配足够的存储空间；
 * 4、这块存储空间会被清零，这就自动地将Dog对象中的所有基本类型数据都设置成了默认值。
 * 5、执行所有出现于字段定义处的初始化动作；
 * 6、执行构造器。这个可能会牵涉很多动作，尤其是涉及继承的时候；
 * 
 */// :~
