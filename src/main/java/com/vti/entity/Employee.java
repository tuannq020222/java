package com.vti.entity;

public class Employee extends User{
	private int projectId;
	private String proSkill;
	
	public Employee(int id, String FullName,String Email, String Password, int projectId, String proSkill) {
		super(id,FullName,Email,Password,Position.Employee);
		this.projectId = projectId;
		this.proSkill = proSkill;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	
}
