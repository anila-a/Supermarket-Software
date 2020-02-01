package model;

public class Administrator extends User implements Checker{
	
	private String name;
	private String surname;
	private String level;
		
	public Administrator(String username, String password, String name, String surname, String level) {
		super(username, password);
			
		this.name = name;
		this.surname = surname;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getLevel() {
		return level;
	}
		
	public boolean checkUser(String username, String password) {
		return username.equals(this.getUsername()) && password.equals(this.getPassword());
	}
}

