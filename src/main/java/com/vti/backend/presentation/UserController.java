package com.vti.backend.presentation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Project;
import com.vti.entity.User;

public class UserController {

	private IUserService userService;
	
	public UserController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new UserService();
	}
	
	public List <Project> getListManagerInAllProject () throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return userService.getListManagerInAllProject();
	}
	
	public List <User> getListUserInProject(int projectId) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return userService.getListUserInProject(projectId);
	}
	
	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}
	
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException {
		return userService.isUserIdExists(id);
	}
}
