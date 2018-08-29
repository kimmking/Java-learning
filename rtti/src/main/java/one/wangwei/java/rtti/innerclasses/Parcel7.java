package one.wangwei.java.rtti.innerclasses;

//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

public class Parcel7 {
	public Contents contents() {
		return new Contents() {
			private int i = 11;

			@Override
			public int value() {
				return i;
			}
		};
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
} // /:~
