package one.wangwei.java.rtti.typeinfo;

import java.util.Random;

/**
 * @author wangwei
 *
 */
public class ClassInitialization {
	
	public static Random rand = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException{
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		
		System.out.println(Initable2.staticNonFinal);
		Class  initable3 = Class.forName("one.wangwei.java.rtti.typeinfo.Initable3");
		
		System.out.println(Initable3.staticNonFinal);
	}
}


class Initable{
	static final int staticFinal = 47;
	static final int staticFinal2= ClassInitialization.rand.nextInt(1000);
	static{
		System.out.println("Initablizing Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;
	static{
		System.out.println("Initablizing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 47;
	static{
		System.out.println("Initablizing Initable3");
	}
}

/**
 * result :
 * 
 * (1).class 不会初始化
 * (2) class.forName("")立即初始化
 * (3)static final 定义的编译期常量
 * (4)static 而不是final, 访问前总是要进行链接(为这个域分配存储空间)
 * 和初始化（初始化存储空间）
 */


