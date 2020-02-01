package model;

import java.io.Serializable;

public class Supplier implements Serializable {
	
	public int id;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String address;
	private static int nrSuppliers = 0;
	
	public Supplier(String name, String surname, String email, String phone, String address) {
		this.id = nrSuppliers++;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.address = address;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public static void setNr(int x) {
		nrSuppliers = x;
	}
}
