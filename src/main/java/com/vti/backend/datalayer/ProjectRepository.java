package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;
//import com.vti.entity.User;

public class ProjectRepository implements IProjectRepository{
	private JdbcUtils jdbcUtils;
	private Connection connection;
	
	public ProjectRepository () throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}
	
	public void CheckConnection() throws ClassNotFoundException, SQLException {
		try {
			connection = jdbcUtils.connect();
			System.out.println("OK");
			//Statement statement = connection.createStatement();
			//ResultSet resultSet = statement.executeQuery(sql);
			
		}finally {
			connection.close();
		}
	}
	
	@Override
	public List <Project> getProject() throws SQLException, ClassNotFoundException {
		List <Project> projects = new ArrayList<>();
		try {
			connection = jdbcUtils.connect();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM `Project` P INNER JOIN `User` U ON P.IdManager = U.UserID";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				int projectId = resultSet.getInt("ProjectID");
				
				int IdManager = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				int ExpInYear   = resultSet.getInt("ExpInYear");
				
				Manager manager = new Manager(IdManager,fullName,email,password,ExpInYear);
				
				Project project = new Project(projectId,manager);
				projects.add(project);
			}
			return projects;
		} finally {
			connection.close();
		}
	}
	
	@Override
	public List <Employee> getEmployeeInProject(int projectId) throws SQLException, ClassNotFoundException {
		List <Employee> employees = new ArrayList<>();
		try {
			connection = jdbcUtils.connect();
			
			String sql = "SELECT * FROM EmployeeProject EP INNER JOIN `User` U ON EP.IdEmployee = U.UserID " + "WHERE EP.ProjectId = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, projectId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int employeeID = resultSet.getInt("IdEmployee");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				String proSkill   = resultSet.getString("proSkill");
				
				Employee employee = new Employee(employeeID,fullName,email,password, projectId, proSkill); 
				employees.add(employee);
			}
			return employees;
		} finally {
			connection.close();
		}
	}
	
	@Override
	public Manager	getManagerInProject(int projectId) throws SQLException, ClassNotFoundException {
		Manager manager = new Manager(0,"","","",0);
		try {
			connection = jdbcUtils.connect();
			
			String sql = "SELECT * FROM `Project` P INNER JOIN `User` U ON P.IdManager = U.UserID " + "WHERE ProjectID = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, projectId);
			
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()) {
	
				int managerID = resultSet.getInt("IdManager");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				int ExpInYear   = resultSet.getInt("ExpInYear");
				
				
				manager.setId(managerID);
				manager.setFullName(fullName);
				manager.setEmail(email);
				manager.setPassword(password);
				manager.setExpInYear(ExpInYear);
			}

			return manager;
		} finally {
			connection.close();
		}
	}
}

