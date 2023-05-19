package oop.lab03.shapes;

import oop.lab03.shapes.interfaces.Polygon;

public class Square implements Polygon {

	final static int EDGE = 4;
	
	private double edgeLength;
	
	public Square(double edgeLength) {
		this.edgeLength = edgeLength;
	}

	public double getArea() {
		return this.edgeLength * this.edgeLength;
	}
	
	public double getPerimeter() {
		return EDGE * this.edgeLength;
	}

	public int getEdgeCount() {
		return EDGE;
	}

}
