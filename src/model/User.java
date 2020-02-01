package model;

import java.io.Serializable;

public abstract class User implements Serializable {
	
	public int id;
	public String username;
	public String password;
	private static int nrUsers = 0;
	
	public User(String username, String password) {
		this.id = nrUsers++;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public static void setNr(int x) {
		nrUsers = x;
	}
}

