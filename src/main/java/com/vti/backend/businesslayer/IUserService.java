package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;
import com.vti.entity.User;

public interface IUserService {
	
	public List<Project> getListManagerInAllProject () throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List <User> getListUserInProject(int projectId) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;

	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException ;
	
	public User login(String email, String password) throws Exception ;
}
