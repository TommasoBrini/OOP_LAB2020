package oop.lab03.shapes;

import oop.lab03.shapes.interfaces.Polygon;

public class Triangle implements Polygon {

	final static int EDGE = 3;
	
	private final double l1;
	private final double l2;
	private final double l3;
	
	public Triangle(double l1, double l2, double l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}

	public double getArea() {
		final double semiPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - this.l1) * (semiPerimeter - this.l2) * (semiPerimeter - this.l3));
    }

	public double getPerimeter() {
		return this.l1 + this.l2 + this.l3;
	}

	public int getEdgeCount() {
		return EDGE;
	}

}
