package one.wangwei.java.rtti.typeinfo.toys;

public class GenericToyTests {
	
	public static void main(String[] args){
		
		Class<FancyToy> ftClass = FancyToy.class;
		
		try {
			FancyToy fancyToy = ftClass.newInstance();
			Class<? super FancyToy> up = ftClass.getSuperclass();
			Object obj = up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	class FancyToy{
	}
}
