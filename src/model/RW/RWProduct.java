/* 
 * CEN 215 - Object Oriented Programming - Supermarket Software project
 * Fall 2019 - Computer Engineering - Epoka University
 * 
 * Created by Anila - January 2020
 * 
 * */

package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Product;

public class RWProduct {
	public static ArrayList<Product> products;
	private static final String file = "products.bin";
	private File fi;
	
	public RWProduct() {
		products = new ArrayList<>();
		fi = new File(file);
		if(fi.exists()) {
			readProducts();
		} else {
			writeProducts();
		}
	}

	private void writeProducts() {
		try {
			FileOutputStream fos = new FileOutputStream(fi);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(products);
			oos.close(); fos.close();
		} catch(FileNotFoundException e) {
			System.err.println("File cannot be written!");
		} catch(IOException e) {
			System.err.println("A problem occurred when writing the file.");
		}
	}
	
	private void readProducts() {
		try {
			FileInputStream fis = new FileInputStream(fi);
			ObjectInputStream ois = new ObjectInputStream(fis);
			products = (ArrayList<Product>) ois.readObject();
			ois.close(); fis.close();
		} catch(FileNotFoundException e){
			System.err.println("File cannot be written!");
		} catch(IOException e) {
			System.err.println("There is a problem writing the file!");
		} catch(ClassNotFoundException e) {
			System.err.println("Classes do not match!");
		}
	}
	
	private void setNr() {
		int max = 0;
		
		for(Product i: products) 
			if(max < i.getId()) max = i.getId();
		Product.setNr(max + 1); 
	}
	
	public ArrayList<Product> getProduct() {
		return products;
	}
	
	public void addProduct(Product x) {
		products.add(x);
		writeProducts();
	}
	
	public void deleteProduct(Product x) {
		products.remove(x);
		writeProducts();
	}
	
	public Product getProductByID(int id) {
		for(Product i: products) 
			if(i.getId() == id) return (Product) i;
		return null;
	}
	
	public Product getProductByBarcode(String barcode) {
		for(Product i: products) 
			if(i.getBarcode().equals(barcode)) return (Product) i;
		return null;
	}

	/*public static int changeQuantityByBarcode(String barcode, int x) {
		for(Product i: products) 
			if(i.getBarcode().equals(barcode)) return Integer.parseInt(i.getQuantity()) - x;
		//update();
		return (Integer) null;
	}	*/
	
	public void update() {
		writeProducts();
	}
	
}
