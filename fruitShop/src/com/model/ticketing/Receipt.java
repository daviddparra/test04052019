package com.model.ticketing;

import java.util.List;

public class Receipt {
	private List<ProductReceipt> products;

	public Receipt(List<ProductReceipt> products) {
		super();
		this.products = products;
	}

	public List<ProductReceipt> getProducts() {
		return products;
	}

	public void setProducts(List<ProductReceipt> products) {
		this.products = products;
	}
	
	public float getTotalPrice() {
		float total = 0;
		if (products != null && products.size() > 0) {
			for (ProductReceipt prod: products) {
				total += prod.getAmount() * prod.getProduct().getPrice();
			}
		}
		return total;
	}
}
