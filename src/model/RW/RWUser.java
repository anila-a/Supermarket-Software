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
import java.util.Scanner;

import model.Administrator;
import model.Checker;
import model.User;

public class RWUser {
	private ArrayList<User> users;
	private static final String file = "users.bin";
	private File fi;
	
	public RWUser() {
		users = new ArrayList<>();
		fi = new File(file);
		if(fi.exists()) {
			readUsers();
			setNr();
		} else {
			createFile();
		}
	}

	private void createFile() {
		System.out.println("First time usage: Please register Administrator data.");
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Name: "); String name = in.next();
		System.out.print("Surname: "); String surname = in.next();
		System.out.print("Username: "); String username = in.next();
		System.out.print("Password: "); String password = in.next();
		System.out.print("Level: "); String level = in.next();
		
		users.add(new Administrator(username, password, name, surname, level));
		writeUsers();
	}

	private void writeUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(fi);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close(); fos.close();
		} catch(FileNotFoundException e) {
			System.err.println("File cannot be written!");
		} catch(IOException e) {
			System.err.println("There is a problem writing the file!");
		}
	}

	private void readUsers() {
		try {
			FileInputStream fis = new FileInputStream(fi);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList<User>) ois.readObject();
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
		
		for(User i: users) 
			if(max < i.getId()) max = i.getId();
		User.setNr(max + 1); 
	}
	
	public ArrayList<User> getUser() {
		return users;
	}
	
	public void addUser(User x) {
		users.add(x);
		writeUsers();
	}

	public void deleteUser(User x) {
		users.remove(x);
		writeUsers();
	}
	
	public User getUserByID(int id) {
		for(User i: users) 
			if(i.getId() == id) return (User) i;
		return null;
	}
	
	public User checkLogin(String username, String pass) {
		for(User i: users) 
			if(((Checker) i).checkUser(username, pass))
				return i;
			return null;
	}
	
	public void update() {
		this.writeUsers();
	}
}
