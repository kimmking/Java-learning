package one.wangwei.java.rtti.innerclasses;

//: innerclasses/Parcel11.java
// Nested classes (static inner classes).

/**
 * 嵌套类（静态内部类）
 * 意味着:
 * (1) 要创建嵌套类的对象，并不需要其外围类的对象；
 * (2) 不能从嵌套的对象中访问非静态的外围类对象；
 * @author wangwei
 *
 */
public class Parcel11 {
	private static class ParcelContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected static class ParcelDestination implements Destination {
		private String label;

		private ParcelDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}

		// Nested classes can contain other static elements:
		public static void f() {
		}

		static int x = 10;

		static class AnotherLevel {
			public static void f() {
			}

			static int x = 10;
		}
	}

	public static Destination destination(String s) {
		return new ParcelDestination(s);
	}

	public static Contents contents() {
		return new ParcelContents();
	}

	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmania");
	}
} // /:~
