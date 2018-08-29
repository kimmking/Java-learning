package one.wangwei.java.rtti.typeinfo;

/**
 * 
 * @author wangwei
 *
 */
public class BoundedClassReferences {
	
	public static void main(String[] args){
		
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
	}
}

