package oop.lab03.shapes;

import oop.lab03.shapes.interfaces.Shape;

public class Circle implements Shape {

	private final double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

}
