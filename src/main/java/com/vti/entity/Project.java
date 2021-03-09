package com.vti.entity;

public class Project {
	private int projectId;
	private Manager manager;
	
	public Project(int projectID, Manager manager) {
		this.projectId = projectID;
		this.manager = manager;
	}

	public int getProjectId() {
		return projectId;
	}

	public int getManagerId() {
		return manager.getId();
	}
	
	public String getManagerName() {
		return manager.getFullName();
	}
}