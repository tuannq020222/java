package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.Position;
import com.vti.entity.User;

public class UserRepository implements IUserRepository{
	private JdbcUtils jdbcUtils;
	private Connection connection;
	
	public UserRepository () throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}
	
	@Override
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException {
		try {

			connection = jdbcUtils.connect();

			String sql = "SELECT * FROM `User` " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

			return false;
		} finally {
			connection.close();
		}

	}
	
	@Override
	public User login(String email, String password) throws Exception {
		try {

			connection = jdbcUtils.connect();

			String sql = "SELECT * FROM `User` " + "WHERE Email = ? AND Password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				Position position = Position.valueOf(resultSet.getString("Position"));

				User user = new User(userId, fullName, email, password, position);
				return user;
			} else {
				throw new Exception("Tài khoản hoặc mật khẩu sai !");
			}

		} finally {
			connection.close();
		}

	}
}

