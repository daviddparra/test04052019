package com.model.stock;

import java.util.List;

public class Store {
	private List<Product> products;
	
	public Store(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Product getProductByName(String name) {
		if (products != null && products.size() > 0) {
			for (Product product: products) {
				if (product.getName().equalsIgnoreCase(name)) {
					return product;
				}
			}
		}
		return null;
	}
	
	public float getPriceByName(String name) {
		Product result = getProductByName(name);
		return result != null? result.getPrice(): 0; 
	}
}
