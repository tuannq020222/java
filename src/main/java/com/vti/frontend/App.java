package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.vti.Utils.ScannerUtils;


public class App {
	/**/
	public static void main(String[] args) throws Exception  {

		Function function = new Function();
		
		function.menuLogin();
		
		while(true) {
			System.out.println("Ấn số để lựa chọn");
			System.out.println("1. Xem danh sách các Manager");
			System.out.println("2. Tra cứu danh sách thành viên trong Project");
			System.out.println("0. THOÁT");
			System.out.print("Choose /> ");
			int i = ScannerUtils.inputInt("vui lòng nhập số!");
			if(i == 1)
				function.getListManagerInAllProject();
			else if(i == 2)
				function.getListUserInProject();
			else if(i == 0)
			{
				System.out.println("Tạm biệt !");
				break;
			}
			else
				System.err.println("Nhập lại");
			System.out.println("------------------------------------------------------");
		}
	}
}


