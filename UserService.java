package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IProjectRepository;
import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.ProjectRepository;
import com.vti.backend.datalayer.UserRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserService implements IUserService {
	
	private IProjectRepository projectRepository;
	private IUserRepository	userRepository;
	
	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		projectRepository = new ProjectRepository();
		userRepository    = new UserRepository();
	} 
	
	@Override
	public List <User> getListUserInProject(int projectId) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List <User> users = new ArrayList<> ();

		Manager manager = projectRepository.getManagerInProject(projectId);
		List <Employee> employees = projectRepository.getEmployeeInProject(projectId);
		
		users.add(manager);
		
		for(Employee employee : employees) {
			users.add(employee);
		}
		
		return users;
	}
	
	@Override
	public List <Project> getListManagerInAllProject () throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return projectRepository.getProject();
	}
	
	
	@Override
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException {
		return userRepository.isUserIdExists(id);
	}
	
	@Override
	public User login(String email, String password) throws Exception {
		return userRepository.login(email, password);
	}
}
