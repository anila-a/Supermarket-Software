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

import model.Bill;

public class RWBill {
	private ArrayList<Bill> bills;
	private static final String file = "bills.bin";
	private File fi;
	
	public RWBill() {
		bills = new ArrayList<>();
		fi = new File(file);
		if(fi.exists()) {
			readBills();
			setNr();
		} else {
			writeBills();
		}
	}

	private void writeBills() {
		try {
			FileOutputStream fos = new FileOutputStream(fi);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bills);
			oos.close(); fos.close();
		} catch(FileNotFoundException e) {
			System.err.println("File cannot be written!");
		} catch(IOException e) {
			System.err.println("There is a problem writing the file!");
		}
	}

	private void readBills() {
		try {
			FileInputStream fis = new FileInputStream(fi);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bills = (ArrayList<Bill>) ois.readObject();
			ois.close(); fis.close();
		} catch(FileNotFoundException e) {
			System.err.println("File not found!");
		} catch(IOException e) {
			System.err.println("File is corrupted!");
		} catch(ClassNotFoundException e) {
			System.err.println("Classes do not match!");
		}
	}

	private void setNr() {
		int max = 0;
		
		for(Bill i: bills) 
			if(max < i.getId()) max = i.getId();
		Bill.setNr(max + 1); 
	}
	
	public ArrayList<Bill> getBill() {
		return bills;
	}
	
	public void addBill(Bill x) {
		bills.add(x);
		writeBills();
	}

	public void deleteBill(Bill x) {
		bills.remove(x);
		writeBills();
	}
	
	public Bill getBillByID(int id) {
		for(Bill i: bills) 
			if(i.getId() == id) return (Bill) i;
		return null;
	}

	public void update() {
		this.writeBills();
	}
}
