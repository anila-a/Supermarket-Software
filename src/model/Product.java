package model;

import java.io.Serializable;

public class Product implements Serializable {
	
	public int id;
	public String name;
	public String barcode;
	public String category;
	public String supplier;
	public Date purchase;
	public Date expire;
	public String price;
	public String quantity;
	public static int nrProducts = 0;
	
	public Product(String name, String barcode, String category, String supplier, Date purchase, Date expire, String price, String quantity) {
		this.id = nrProducts++;
		this.name = name;
		this.barcode = barcode;
		this.category = category;
		this.supplier = supplier;
		this.purchase = purchase;
		this.expire = expire;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getPurchase() {
		return purchase;
	}

	public void setPurchase(Date purchase) {
		this.purchase = purchase;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public static void setNr(int x) {
		nrProducts = x;
	}
}
