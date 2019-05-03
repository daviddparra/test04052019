package com.model.selling;

import java.util.List;

public class Purchase {
	List<ProductSold> products;

	public Purchase(List<ProductSold> products) {
		super();
		this.products = products;
	}

	public List<ProductSold> getProducts() {
		return products;
	}

	public void setProducts(List<ProductSold> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Purchase [products=" + products + "]";
	}
}
