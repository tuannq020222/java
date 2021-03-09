package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.User;

public interface IUserRepository {
	public User login(String email, String password) throws Exception ;
	
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException ;

}
