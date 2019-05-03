package com.receipt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Main;
import com.model.selling.ProductSold;
import com.model.selling.Purchase;
import com.model.ticketing.ProductReceipt;
import com.model.ticketing.Receipt;

public class ReceiptGenerator {
	public static void generateReceipts(List<Purchase> purchases, String dir, String newDir) throws Exception {
		File newDirectory = new File(dir, newDir);
		if (!newDirectory.exists()) {			
			if (newDirectory.mkdir()) {
				System.out.println("New folder created");
			} else {			
				throw new Exception("Folder cannot be created, therefore the receipt cannot be created.");
			}
		}
		
		for (Purchase purchase: purchases) {
			List<ProductReceipt> prodRec = new ArrayList<ProductReceipt>();
			for (ProductSold soldProd: purchase.getProducts()) {
				prodRec.add(new ProductReceipt(Main.getShop().getProductByName(soldProd.getName()), soldProd.getAmount()));
			}
			createReceipt(newDirectory, new Receipt(prodRec));
		}
	}
	
	public static void createReceipt(File newDirectory, Receipt receipt) {
		Random rand = new Random();
		File file = new File(newDirectory, rand.nextInt() + ".txt");
        try {
			if(file.createNewFile()) {
			    System.out.println(file.getAbsolutePath()+" File Created");				    
			} else {
				System.out.println("File "+file.getAbsolutePath()+" already exists");
			}
			FileWriter writer = new FileWriter(file);  
		    BufferedWriter buffer = new BufferedWriter(writer); 
		    for (ProductReceipt writingProd : receipt.getProducts()) {
		    	buffer.write(writingProd.getProduct().getName() + " " + writingProd.getAmount() + " at " + writingProd.getProduct().getPrice() + " = " + writingProd.getProduct().getPrice() * writingProd.getAmount());
		    	buffer.newLine();
		    }
		    buffer.write("Total price: " + receipt.getTotalPrice());  
		    buffer.close();  			     
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
