package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class Bill implements Serializable {
	
	public int id;
	public static Date billDate;
	private static double total;
	private static ArrayList<Product> products;
	private static int nrBills = 0;
	
	public Bill(Date billDate, double total, ArrayList<Product> products) {
		this.id = nrBills++;
		this.billDate = billDate;
		this.total = total;
		this.products = products;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public static double getTotal() {
		return total + (15 * total) / 100;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static ArrayList<Product> getProduct() {
		return products;
	}

	public static int getNrBills() {
		return nrBills;
	}

	public static void setNrBills(int nrBills) {
		Bill.nrBills = nrBills;
	}

	public static void setNr(int x) {
		nrBills = x++;
	}
	
	public static void writeBill(int nrBills, ObservableList<Product> pr, double total) {
		try {
			File folder = new File("bills");
			folder.mkdir();
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("bills" + "/" + "bill["+nrBills+"].txt"), true));
			pw.println("SUPERMARKET SOFTWARE - Bill No." + nrBills + "\n");
			for(Product i: pr) {
				pw.println(i.getQuantity() + " x " + i.getPrice() + " \t" + i.getName() + "   \t" + Integer.parseInt(i.getQuantity()) * Double.parseDouble(i.getPrice()));
		}
			pw.println("\nTOTAL: " + total);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("No rights to write in the file!");
		}
	}
}
