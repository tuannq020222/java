package com.vti.frontend;

import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.entity.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.businesslayer.UserService;
import com.vti.backend.presentation.UserController;
	/**/
public class Function {
	
	private UserController userController;
	
	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}
	
	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập vào Email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				return userController.login(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
	
	public void menuLogin() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.println("MỜI BẠN LOGIN");
		User user = login();
		System.out.println("Login successfull!");
		System.out.println("Chào mừng " + user.getFullName() + "!");
	}

		
	public void getListManagerInAllProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List <Project> projects = userController.getListManagerInAllProject();
		System.out.println("\t\tDanh sách Manager");
		System.out.println("No\tProject ID\tManager ID\tManager Name");
		int count = 0;
		for(Project project : projects) {
			System.out.println(++count + "\t" + project.getProjectId() + "\t\t" + project.getManagerId() + "\t\t" + project.getManagerName());
		}
	}
	
	public void getListUserInProject() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.print("Nhập Project ID : ");
		int projectId = ScannerUtils.inputInt(" Vui lòng nhập đúng số");
		List <User> users = userController.getListUserInProject(projectId);
		int count = 0;
		System.out.println("Project ID : " + projectId);
		System.out.println("\tNo\tUser ID\t\tUser Name\tPosition");
		for(User user : users) {
			System.out.println("\t" + ++count + "\t" +user.getId() + "\t\t" + user.getFullName() + "\t" + user.getPosition());
		}
	}
}
