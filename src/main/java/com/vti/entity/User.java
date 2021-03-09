package com.vti.entity;

public class User {
	private int id;
	private String FullName;
	private String Email;
	private String Password;
	private Position position;
	
	public User(int id, String FullName, String Email, String Password, Position position) {
		this.id = id;
		this.FullName = FullName;
		this.Email = Email;
		this.Password = Password;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	

}
