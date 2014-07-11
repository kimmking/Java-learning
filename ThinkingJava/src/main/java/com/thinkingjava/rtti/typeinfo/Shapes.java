package com.thinkingjava.rtti.typeinfo;

//: typeinfo/Shapes.java
import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}
	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	public String toString() {
		return "Triangle";
	}
}

class Rhomboid extends Shape {
	@Override
	public String toString() {
		return "Rhomboid";
	}
}

public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
				new Triangle());
		for (Shape shape : shapeList)
			shape.draw();

		// Rhomboid 转型测试
		Rhomboid rhomboid = new Rhomboid();
		if (rhomboid instanceof Shape) {
			Shape shape = rhomboid;
			shape.draw();

			if (shape instanceof Circle) {
				Circle circle = (Circle) shape;
				circle.draw();
			}
		}
	}
} /*
 * Output: Circle.draw() Square.draw() Triangle.draw()
 */// :~
