package it.unibo.oop.lab05.ex3;

public class ProductImpl implements Product {

	private String name;
	private double quantity;
	
	public ProductImpl(String name, double quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getQuantity() {
		return quantity;
	}
	
	public boolean equals(Product p) {
		return name.equals(p.getName());
	}
	
	public final String toString() {
        return "ProductImpl [name=" + name + ", quantity=" + quantity + "]";
    }
}
