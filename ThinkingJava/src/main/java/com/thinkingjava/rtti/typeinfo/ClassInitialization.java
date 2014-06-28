package com.thinkingjava.rtti.typeinfo;

import java.util.Random;

public class ClassInitialization {
	
	public static Random rand = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException{
		Class initable = Initable.class;
//		System.out.println("After creating Initable ref");
//		System.out.println(Initable.staticFinal);
//		System.out.println(Initable.staticFinal2);
//		
		System.out.println(Initable2.staticNonFinal);
//		
//		Class  initable3 = Class.forName("com.thinkingjava.rtti.typeinfo.Initable3");
		
//		System.out.println(Initable3.staticNonFinal);
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

