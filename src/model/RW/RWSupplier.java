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

import model.Supplier;

public class RWSupplier {
	private ArrayList<Supplier> suppliers;
	private static final String file = "suppliers.bin";
	private File fi;
	
	public RWSupplier() {
		suppliers = new ArrayList<>();
		fi = new File(file);
		if(fi.exists()) {
			readSuppliers();
			setNr();
		} else {
			writeSuppliers();
		}
	}

	private void writeSuppliers() {
		try {
			FileOutputStream fos = new FileOutputStream(fi);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(suppliers);
			oos.close(); fos.close();
		} catch(FileNotFoundException e) {
			System.err.println("File cannot be written!");
		} catch(IOException e) {
			System.err.println("There is a problem writing the file!");
		}
	}

	private void readSuppliers() {
		try {
			FileInputStream fis = new FileInputStream(fi);
			ObjectInputStream ois = new ObjectInputStream(fis);
			suppliers = (ArrayList<Supplier>) ois.readObject();
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
		
		for(Supplier i: suppliers) 
			if(max < i.getId()) max = i.getId();
		Supplier.setNr(max + 1); 
	}
	
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public void addSuppliers(Supplier x) {
		suppliers.add(x);
		writeSuppliers();
	}

	public void deleteSuppliers(Supplier x) {
		suppliers.remove(x);
		writeSuppliers();
	}
	
	public Supplier getSupplierByID(int id) {
		for(Supplier i: suppliers) 
			if(i.getId() == id) return (Supplier) i;
		return null;
	}
	
	public void update() {
		this.writeSuppliers();
	}	
}
