package it.unibo.oop.lab05.ex4;

import java.util.TreeSet;
import java.util.Set;

import it.unibo.oop.lab05.ex3.Product;
import it.unibo.oop.lab05.ex3.WarehouseImpl;

public class OrderedWarehouse extends WarehouseImpl {
	
	public Set<Product> allProducts() {
		return new TreeSet<>(super.allProducts());
	}
}
