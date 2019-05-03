package com;

import java.util.List;

import com.init.LoadHelper;
import com.model.selling.Purchase;
import com.model.stock.Store;
import com.receipt.ReceiptGenerator;

public class Main {
	
	private static Store shop;
	
	public  static Store getShop() {
		 if (shop==null) {
			 shop = LoadHelper.loadProducts("./products.txt");
		 }
		 return shop;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		List<Purchase> list = LoadHelper.loadPurchase("./purchases");
		try {
			ReceiptGenerator.generateReceipts(list, "./", "receipts");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
