package com.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.model.selling.ProductSold;
import com.model.selling.Purchase;
import com.model.stock.Product;
import com.model.stock.Store;

public class LoadHelper {
	public static Store loadProducts(String dir) {
		File file = new File(dir);
		List<Product> all_products = new ArrayList<Product>();
		
		  
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st; 
			try {
				while ((st = br.readLine()) != null) {					
					String[] line = st.split(",");					
					all_products.add(new Product(line[0].trim(), Float.valueOf(line[1].trim())));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("There has been a problem while reading");
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File was not found");
			e.printStackTrace();
		} 
		Store store = new Store(all_products);
		return store;
	}
	
	
	public static List<Purchase> loadPurchase(String dir) {
		
		File folder = new File(dir);
		File[] listOfFiles = folder.listFiles();
		List<Purchase> purchases = new ArrayList<Purchase>();
		for (File file: listOfFiles) {
		
			List<ProductSold> boughtProducts = new ArrayList<ProductSold>();
			  
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				String st; 
				try {
					while ((st = br.readLine()) != null) {						
						String[] line = st.split(",");					
						boughtProducts.add(new ProductSold(line[0].trim(), Integer.valueOf(line[1].trim())));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("There has been a problem while reading");
					e.printStackTrace();
				} 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File was not found");
				e.printStackTrace();
			} 
			purchases.add(new Purchase(boughtProducts));
		}
		return purchases;
	} 		

}
