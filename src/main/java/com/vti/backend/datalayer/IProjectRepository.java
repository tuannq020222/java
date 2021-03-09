package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;

public interface IProjectRepository {
	
	public List <Employee> getEmployeeInProject(int projectId) throws SQLException, ClassNotFoundException;
	
	public List <Project> getProject() throws SQLException, ClassNotFoundException;
	
	public Manager getManagerInProject(int projectId) throws SQLException, ClassNotFoundException;

}
