package model;

public class Economist extends User implements Checker {
	
	private String name;
	private String surname;
	private Date bday;
	private String email;
	private String phone;
	private String address;
	private String level;
	private String salary;
	
	public Economist(String username, String password, String name, String surname, Date bday, String email,
			String phone, String address, String level, String salary) {
		super(username, password);
		
		this.name = name;
		this.surname = surname;
		this.bday = bday;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.level = level;
		this.salary = salary;
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

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Economist [name=" + name + ", surname=" + surname + ", bday=" + bday + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", level=" + level + ", salary=" + salary + "]";
	}
	
	public boolean checkUser(String username, String password) {
		return username.equals(this.getUsername()) && password.equals(this.getPassword());
	}
}

