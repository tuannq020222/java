package com.vti.entity;

public class Manager extends User {
	private int ExpInYear;
	
	public Manager (int id, String FullName, String Email, String Password, int ExpInYear) {
		super(id,FullName,Email,Password,Position.Manager);
		this.ExpInYear = ExpInYear;
	}
	
	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
	
	
}
