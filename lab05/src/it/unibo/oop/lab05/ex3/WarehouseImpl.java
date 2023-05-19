package it.unibo.oop.lab05.ex3;

import java.util.HashSet;
import java.util.Set;

public class WarehouseImpl implements Warehouse {

	private final Set<Product> set = new HashSet<>();
	
	public void addProduct(Product p) {
		this.set.add(p);
	}

	public Set<String> allNames() {
		Set<String> names = new HashSet<>();
		for(Product p : set) {
			names.add(p.getName());
		}
		return names;
	}

	public Set<Product> allProducts() {
		return new HashSet<>(this.set);
	}

	public boolean containsProduct(Product p) {
		return set.contains(p);
	}

	public double getQuantity(String name) {
		for (final Product p : set) {
			if (p.getName().equals(name)) {
				return p.getQuantity();
			}
		}
		return 0;
	}

}
